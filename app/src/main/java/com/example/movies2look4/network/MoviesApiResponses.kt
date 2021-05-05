package com.example.movies2look4.network

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesApiResponses {

    fun getMovies() = MoviesApiConnection.buildMoviesApiService().getTopRatedMovies()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
}