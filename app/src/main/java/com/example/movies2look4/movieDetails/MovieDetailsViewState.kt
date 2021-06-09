package com.example.movies2look4.movieDetails

sealed class MovieDetailsViewState {
    object HideTitle : MovieDetailsViewState()
    object HideMovieOriginalTitle : MovieDetailsViewState()
    object HideMovieReleaseDate : MovieDetailsViewState()
    object HideMovieRating : MovieDetailsViewState()
    object HideMovieVoteCount : MovieDetailsViewState()
    object HideMovieOverview : MovieDetailsViewState()
    object ShowMoviePosterPlaceholder : MovieDetailsViewState()
    object ShowMovieCoverPlaceholder : MovieDetailsViewState()
    object HideMovieInfo : MovieDetailsViewState()
}
