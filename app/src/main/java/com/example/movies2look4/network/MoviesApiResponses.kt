package com.example.movies2look4.network

import androidx.recyclerview.widget.RecyclerView
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.models.Movie
import com.example.movies2look4.models.MoviesList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesApiResponses {

    fun getMovies(recyclerView: RecyclerView) {

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            MoviesApiConnection.buildMoviesApiService().getTopRatedMovies("bf29c0907a7efae474e0f225d3c03de8")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { response -> onResponseId(recyclerView, response) },
                    { t -> onFailureId(t) })
        )
    }

    fun onFailureId(t: Throwable) {
        println(t.message)
    }

    fun onResponseId(recyclerView: RecyclerView, response: MoviesList) {
        println(response.results[0].title)
        recyclerView.adapter = MoviesGridAdapter(response.results)
    }
}