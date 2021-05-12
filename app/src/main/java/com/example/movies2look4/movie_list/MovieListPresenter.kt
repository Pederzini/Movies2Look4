package com.example.movies2look4.movie_list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

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
                { t -> movieListView?.onResponseFailure(t) }
            ))
    }
}