package com.example.movies2look4.movies

import com.example.movies2look4.model.Movie

sealed class MoviesViewState {

    class ErrorInternet(val errorMessage: Int) : MoviesViewState()
    class ErrorServer(val errorMessage: Int) : MoviesViewState()
    class ErrorGeneric(val errorMessage: Int) : MoviesViewState()
    class ErrorApp(val errorMessage: Int) : MoviesViewState()
    data class Success(val movieList: List<Movie>) : MoviesViewState()

}