package com.example.movies2look4.movies

import com.example.movies2look4.model.Movie

sealed class MovieListViewState {

    class ErrorInternet(val errorMessage: Int) : MovieListViewState()
    class ErrorServer(val errorMessage: Int) : MovieListViewState()
    class ErrorGeneric(val errorMessage: Int) : MovieListViewState()
    class ErrorApp(val errorMessage: Int) : MovieListViewState()
    data class Success(val movieList: List<Movie>) : MovieListViewState()

}