package com.example.movies2look4.movie_list

import com.example.movies2look4.network.MoviesApiConnection
import com.example.movies2look4.network.MoviesApiResponses
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieListModel {

    fun getMovieList() = MoviesApiConnection.buildMoviesApiService().getTopRatedMovies()

}