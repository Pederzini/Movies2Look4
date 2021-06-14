package com.example.movies2look4.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.model.Movie

class MovieDetailsViewModel(val movie: Movie?) : ViewModel() {

    private val stateMovie = MutableLiveData<MovieDetailsViewState>()
    val viewStateMovie: LiveData<MovieDetailsViewState>
        get() = stateMovie

    init {
        checkMovie()
    }

    private fun checkMovie() {
        if (movie != null) {
            if (movie.title.isNullOrEmpty()) movie.title = "-"
            if (movie.originalTitle.isNullOrEmpty()) movie.originalTitle = "-"
            if (movie.releaseDate.isNullOrEmpty()) movie.releaseDate = "-"
            if (movie.voteAverage == null) movie.voteAverage = 0.0
            if (movie.voteCount == null) movie.voteCount = 0L
            if (movie.overview.isNullOrEmpty()) movie.overview = "-"
            if (movie.posterPath.isNullOrEmpty()) movie.posterPath = "-"
            if (movie.backdropPath.isNullOrEmpty()) movie.backdropPath = "-"
            stateMovie.value = MovieDetailsViewState.ShowMovieInfo(movie)
        } else stateMovie.value = MovieDetailsViewState.HideMovieInfo
    }

}