package com.example.movies2look4.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.model.Movie

class MovieDetailViewModel(private val movie: Movie?) : ViewModel() {

    // usar o sealed class com os objects para expor o estado para a tela
    // tipo .value = view state.hide
    // regra de sealed class -> expor dados para uma view uso data class
    // se for só um estado/msg, uso object
    // não expor nullable, tem que tratar aqui
    // na resposta da api, não preciso usar sealed class. Só preciso expor o erro que foi retornado
    // pelo rxjava

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