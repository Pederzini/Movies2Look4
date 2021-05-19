package com.example.movies2look4.movies

import com.example.movies2look4.network.MoviesApiConnection

class MovieListModel {

    fun getMovieList() = MoviesApiConnection.buildMoviesApiService().getTopRatedMovies()

}