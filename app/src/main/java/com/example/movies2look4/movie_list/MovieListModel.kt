package com.example.movies2look4.movie_list

import com.example.movies2look4.network.MoviesApiConnection

class MovieListModel {

    fun getMovieList() = MoviesApiConnection.buildMoviesApiService().getTopRatedMovies()

}