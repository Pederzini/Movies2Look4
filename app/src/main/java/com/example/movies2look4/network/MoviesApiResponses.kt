package com.example.movies2look4.network

import androidx.recyclerview.widget.RecyclerView
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.models.Movie
import com.example.movies2look4.models.MovieFewInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesApiResponses {

    val moviesIdOnly = mutableListOf<String>()
    val moviesList = mutableListOf<Movie>()
    val moviesFewInfoList = mutableListOf<MovieFewInfo>()

    fun getMoviesIds(recyclerView: RecyclerView) {

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            MoviesApiConnection.buildMoviesApiService().getMoviesIds()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { response -> onResponseId(recyclerView, response) },
                    { t -> onFailureId(t) })
        )
    }

    fun getMoviesAllDetails(recyclerView: RecyclerView, id: String) {

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            MoviesApiConnection.buildMoviesApiService().getMoviesAllDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->
//                    recyclerView.adapter = MoviesGridAdapter(response)
                    onResponseAllDetails(recyclerView, response)
                }, { t ->
                    onFailureAllDetails(t)
                })
        )
    }

    fun getMoviesFewDetails(recyclerView: RecyclerView, id: String) {
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            MoviesApiConnection.buildMoviesApiService().getMoviesFewDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->
//                    recyclerView.adapter = MoviesGridAdapter(response)
                    onResponseFewDetails(recyclerView, response)
                }, { t ->
                    onFailureFewDetails(t)
                })
        )

    }

    fun onFailureId(t: Throwable) {
        println(t.message)
    }

    fun onResponseId(recyclerView: RecyclerView, response: List<String>) {
        val pattern = "title|/".toRegex()
        response.forEach {
            moviesIdOnly.add(it.replace(pattern, ""))
        }
        println(moviesIdOnly.toString())

//        moviesIdOnly.forEach {
//            getMoviesFewDetails(recyclerView, it)
//        }
        getMoviesFewDetails(recyclerView, moviesIdOnly[0])
        getMoviesFewDetails(recyclerView, moviesIdOnly[10])
        getMoviesFewDetails(recyclerView, moviesIdOnly[2])
//        getMoviesFewDetails(recyclerView, moviesIdOnly[3])
//        getMoviesFewDetails(recyclerView, moviesIdOnly[4])
//        getMoviesFewDetails(recyclerView, moviesIdOnly[5])

    }

    fun onFailureAllDetails(t: Throwable) {
        println(t.message)
    }

    fun onResponseAllDetails(recyclerView: RecyclerView, response: Movie) {
        moviesList.add(response)
//        recyclerView.adapter = MoviesGridAdapter(moviesList)

    }

    fun onFailureFewDetails(t: Throwable) {
        println(t.message)
    }

    fun onResponseFewDetails(recyclerView: RecyclerView, response: MovieFewInfo) {
        moviesFewInfoList.add(response)
        recyclerView.adapter = MoviesGridAdapter(moviesFewInfoList)
    }

}