package com.example.movies2look4.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.model.Movie

class MovieDetailsViewModel(private val movie: Movie?) : ViewModel() {

    private val stateMovie = MutableLiveData<MovieDetailsViewState>()
    val viewStateMovie: LiveData<MovieDetailsViewState>
        get() = stateMovie

    init {
        checkMovie()
    }

    private fun checkMovie() {
        if (movie != null) {
            when {
                movie.title.isNullOrEmpty() -> stateMovie.value = MovieDetailsViewState.HideTitle
                movie.originalTitle.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailsViewState.HideMovieOriginalTitle
                movie.releaseDate.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailsViewState.HideMovieReleaseDate
                movie.voteAverage == 0.0 -> stateMovie.value = MovieDetailsViewState.HideMovieRating
                movie.voteCount == 0L -> stateMovie.value = MovieDetailsViewState.HideMovieVoteCount
                movie.overview.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailsViewState.HideMovieOverview
                movie.posterPath.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailsViewState.ShowMoviePosterPlaceholder
                movie.backdropPath.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailsViewState.ShowMovieCoverPlaceholder
            }
        } else stateMovie.value = MovieDetailsViewState.HideMovieInfo
    }

}