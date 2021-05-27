package com.example.movies2look4.movies

import com.example.movies2look4.network.MoviesEndpoints
import javax.inject.Inject

class MovieListModel @Inject constructor(private val moviesEndpoints: MoviesEndpoints){

    fun getMovieList() = moviesEndpoints.getTopRatedMovies()

}