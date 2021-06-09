package com.example.movies2look4.movieDetails

import com.example.movies2look4.model.Movie

sealed class MovieDetailsViewState {
    data class ShowMovieInfo(val movie: Movie) : MovieDetailsViewState()
    object HideMovieInfo : MovieDetailsViewState()
}
