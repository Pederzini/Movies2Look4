package com.example.movies2look4.network

import com.example.movies2look4.network.MoviesApiConnection.buildMoviesApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesApiResponses {

    val moviesIdOnly = mutableListOf<String>()

    fun getMoviesIds() {

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            buildMoviesApiService().getMoviesIds()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response -> onResponse(response) }, { t -> onFailure(t) })
        )

    }

    fun onFailure(t: Throwable) {
        println(t.message)
    }

    fun onResponse(response: List<String>) {
        val pattern = "title|/".toRegex()
        response.forEach {
            moviesIdOnly.add(it.replace(pattern, ""))
        }
        println(moviesIdOnly.toString())
    }

}