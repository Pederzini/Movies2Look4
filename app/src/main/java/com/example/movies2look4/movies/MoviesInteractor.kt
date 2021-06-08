package com.example.movies2look4.movies

import com.example.movies2look4.network.MoviesEndpoints

class MoviesInteractor(private val moviesEndpoints: MoviesEndpoints) {

    fun getMovieList() = moviesEndpoints.getTopRatedMovies()

}