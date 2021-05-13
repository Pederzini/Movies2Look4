package com.example.movies2look4.movie_list

import com.example.movies2look4.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class MovieListPresenter(
    private var movieListView: MovieListContract.View?,
    private val movieListModel: MovieListModel
) : MovieListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.clear()
        this.movieListView = null
    }

    override fun requestDataFromServer() {
        compositeDisposable.add(movieListModel.getMovieList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                if (!response.results.isNullOrEmpty()) {
                    movieListView?.setDataToRecyclerView(response.results)
                }
            },
                { error ->
                    when (error) {
                        is IOException -> movieListView?.showError(R.string.error_internet)
                        is HttpException -> {
                            if (error.code() == 500) {
                                movieListView?.showError(R.string.error_server) //ocultar botao try again
                            } else {
                                movieListView?.showError(R.string.error_generic)
                            }
                        }
                        else -> movieListView?.showError(R.string.error_app)// podemos assumir q é um erro do app
                    }
                }
            ))
    }
}