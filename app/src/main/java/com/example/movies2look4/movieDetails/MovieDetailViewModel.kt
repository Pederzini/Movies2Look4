package com.example.movies2look4.movieDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.model.Movie
import javax.inject.Inject

class MovieDetailViewModel : ViewModel() {

    // usar o sealed class com os objects para expor o estado para a tela
    // tipo .value = view state.hide
    // regra de sealed class -> expor dados para uma view uso data class
    // se for só um estado/msg, uso object
    // não expor nullable, tem que tratar aqui
    // na resposta da api, não preciso usar sealed class. Só preciso expor o erro que foi retornado
    // pelo rxjava

    sealed class MovieState {
        object HideTitle : MovieState()
        object HideMovieOriginalTitle : MovieState()
        object HideMovieReleaseDate : MovieState()
        object HideMovieRating : MovieState()
        object HideMovieVoteCount : MovieState()
        object HideMovieOverview : MovieState()
        object ShowMoviePosterPlaceholder : MovieState()
        object ShowMovieCoverPlaceholder : MovieState()
        object HideMovieInfo : MovieState()
        data class ShowMovieInfo(val movie: Movie) : MovieState()
    }

    private val stateMovie = MutableLiveData<MovieState>()
    val viewStateMovie: LiveData<MovieState>
        get() = stateMovie

    fun checkMovie(movie: Movie) {
        when {
            movie.title.isNullOrEmpty() -> stateMovie.value = MovieState.HideTitle
            movie.originalTitle.isNullOrEmpty() -> stateMovie.value =
                MovieState.HideMovieOriginalTitle
            movie.releaseDate.isNullOrEmpty() -> stateMovie.value =
                MovieState.HideMovieReleaseDate
            movie.voteAverage == 0.0 -> stateMovie.value = MovieState.HideMovieRating
            movie.voteCount == 0L -> stateMovie.value = MovieState.HideMovieVoteCount
            movie.overview.isNullOrEmpty() -> stateMovie.value = MovieState.HideMovieOverview
            movie.posterPath.isNullOrEmpty() -> stateMovie.value =
                MovieState.ShowMoviePosterPlaceholder
            movie.backdropPath.isNullOrEmpty() -> stateMovie.value =
                MovieState.ShowMovieCoverPlaceholder
            else -> stateMovie.value = MovieState.ShowMovieInfo(movie)
        }
    }

//    override fun onDestroy() {
//        this.movieDetailView = null
//    }

//    interface MovieDetailContract {
//
//        interface View {
//            fun hideMovieInfo()
//            fun showMovieInfo(movie: Movie)
//            fun hideMovieTitle()
//            fun hideMovieOriginalTitle()
//            fun hideMovieReleaseDate()
//            fun hideMovieRating()
//            fun hideMovieVoteCount()
//            fun hideMovieOverview()
//            fun showMoviePosterPlaceholder()
//            fun showMovieCoverPlaceholder()
//        }
//
//        interface Presenter {
//            fun checkMovie(movie: Movie?)
//            fun onDestroy()
//        }
//
//    }

}