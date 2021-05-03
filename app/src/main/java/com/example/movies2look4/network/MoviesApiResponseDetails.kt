package com.example.movies2look4.network

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.movies2look4.models.Movie
import com.example.movies2look4.network.MoviesApiConnection.buildMoviesApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesApiResponseDetails {

    fun getMoviesDetails(recyclerView: RecyclerView, id: String) {

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            buildMoviesApiService().getMoviesAllDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->
//                    recyclerView.adapter = MoviesGridAdapter(response)
                    onResponse(response)
                }, { t ->
                    onFailure(t)
                })
        )

    }

    fun onFailure(t: Throwable) {
        println(t.message)
    }

    fun onResponse(response: Movie) {

        println(response.toString())
        println(response)
        Log.e("AAAAAAAAAAAAAAAAAAA", response.toString())
    }

}