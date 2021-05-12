package com.example.movies2look4.movie_details

import com.example.movies2look4.model.Movie

class MovieDetailPresenter(private val movieDetailView: MovieDetailContract.View): MovieDetailContract.Presenter {

    override fun checkMovie(movie: Movie?){
        if(movie != null) {
            when {
                movie.title.isNullOrBlank() -> movieDetailView.hideMovieTitle()
                movie.originalTitle.isNullOrBlank() -> movieDetailView.hideMovieOriginalTitle()
                movie.releaseDate.isNullOrBlank() -> movieDetailView.hideMovieReleaseDate()
                movie.voteAverage.isNaN() -> movieDetailView.hideMovieRating()
                movie.voteCount.toFloat().isNaN() -> movieDetailView.hideMovieVoteCount()
                movie.overview.isNullOrBlank() -> movieDetailView.hideMovieOverview()
                movie.posterPath.isNullOrBlank() -> movieDetailView.showMoviePosterPlaceholder()
                movie.backdropPath.isNullOrBlank() -> movieDetailView.showMovieCoverPlaceholder()
                else -> movieDetailView.showMovieInfo(movie)
            }
        } else {
            println("")
        }
    }
}