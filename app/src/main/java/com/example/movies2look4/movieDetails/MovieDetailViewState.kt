package com.example.movies2look4.movieDetails

sealed class MovieDetailViewState {
    object HideTitle : MovieDetailViewState()
    object HideMovieOriginalTitle : MovieDetailViewState()
    object HideMovieReleaseDate : MovieDetailViewState()
    object HideMovieRating : MovieDetailViewState()
    object HideMovieVoteCount : MovieDetailViewState()
    object HideMovieOverview : MovieDetailViewState()
    object ShowMoviePosterPlaceholder : MovieDetailViewState()
    object ShowMovieCoverPlaceholder : MovieDetailViewState()
    object HideMovieInfo : MovieDetailViewState()
}
