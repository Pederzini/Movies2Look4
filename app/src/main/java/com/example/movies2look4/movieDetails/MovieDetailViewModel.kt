package com.example.movies2look4.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.model.Movie

class MovieDetailViewModel(private val movie: Movie?) : ViewModel() {

    private val stateMovie = MutableLiveData<MovieDetailViewState>()
    val viewStateMovie: LiveData<MovieDetailViewState>
        get() = stateMovie

    init {
        checkMovie()
    }

    private fun checkMovie() {
        if (movie != null) {
            when {
                movie.title.isNullOrEmpty() -> stateMovie.value = MovieDetailViewState.HideTitle
                movie.originalTitle.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailViewState.HideMovieOriginalTitle
                movie.releaseDate.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailViewState.HideMovieReleaseDate
                movie.voteAverage == 0.0 -> stateMovie.value = MovieDetailViewState.HideMovieRating
                movie.voteCount == 0L -> stateMovie.value = MovieDetailViewState.HideMovieVoteCount
                movie.overview.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailViewState.HideMovieOverview
                movie.posterPath.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailViewState.ShowMoviePosterPlaceholder
                movie.backdropPath.isNullOrEmpty() -> stateMovie.value =
                    MovieDetailViewState.ShowMovieCoverPlaceholder
            }
        } else stateMovie.value = MovieDetailViewState.HideMovieInfo
    }

}