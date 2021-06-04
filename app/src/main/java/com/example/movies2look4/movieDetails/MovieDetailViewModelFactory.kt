package com.example.movies2look4.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies2look4.model.Movie


class MovieDetailViewModelFactory(
    private val movie: Movie?
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(movie) as T
    }
}