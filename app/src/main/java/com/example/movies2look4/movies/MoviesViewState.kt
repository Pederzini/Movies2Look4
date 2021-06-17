package com.example.movies2look4.movies

import com.example.movies2look4.model.Movie

sealed class MoviesViewState {

    data class ErrorInternet(val errorMessage: Int) : MoviesViewState()
    data class ErrorServer(val errorMessage: Int) : MoviesViewState()
    data class ErrorGeneric(val errorMessage: Int) : MoviesViewState()
    data class ErrorApp(val errorMessage: Int) : MoviesViewState()
    data class Success(val movieList: List<Movie>) : MoviesViewState()

}