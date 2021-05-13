package com.example.movies2look4.movie_details

import com.example.movies2look4.model.Movie

interface MovieDetailContract {

    interface View {
        fun hideMovieInfo()
        fun showMovieInfo(movie: Movie)
        fun hideMovieTitle()
        fun hideMovieOriginalTitle()
        fun hideMovieReleaseDate()
        fun hideMovieRating()
        fun hideMovieVoteCount()
        fun hideMovieOverview()
        fun showMoviePosterPlaceholder()
        fun showMovieCoverPlaceholder()
    }

    interface Presenter {
        fun checkMovie(movie: Movie?)
        fun onDestroy()
    }

}