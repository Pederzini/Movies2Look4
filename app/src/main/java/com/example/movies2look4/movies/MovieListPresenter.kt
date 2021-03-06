package com.example.movies2look4.movies

import com.example.movies2look4.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieListPresenter @Inject constructor(
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
                { error -> handleError(error) }
            ))
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is IOException -> movieListView?.showErrorTryAgain(R.string.error_internet)
            is HttpException -> {
                if (error.code() == 500) {
                    movieListView?.showError(R.string.error_server)
                } else {
                    movieListView?.showErrorTryAgain(R.string.error_generic)
                }
            }
            else -> movieListView?.showError(R.string.error_app)
        }
    }


}