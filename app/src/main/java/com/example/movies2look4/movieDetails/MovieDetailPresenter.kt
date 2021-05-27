package com.example.movies2look4.movieDetails

import com.example.movies2look4.model.Movie
import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(private var movieDetailView: MovieDetailContract.View?) :
    MovieDetailContract.Presenter {

    override fun checkMovie(movie: Movie?) {
        if (movie != null) {
            when {
                movie.title.isNullOrEmpty() -> movieDetailView?.hideMovieTitle()
                movie.originalTitle.isNullOrEmpty() -> movieDetailView?.hideMovieOriginalTitle()
                movie.releaseDate.isNullOrEmpty() -> movieDetailView?.hideMovieReleaseDate()
                movie.voteAverage == 0.0 -> movieDetailView?.hideMovieRating()
                movie.voteCount == 0L -> movieDetailView?.hideMovieVoteCount()
                movie.overview.isNullOrEmpty() -> movieDetailView?.hideMovieOverview()
                movie.posterPath.isNullOrEmpty() -> movieDetailView?.showMoviePosterPlaceholder()
                movie.backdropPath.isNullOrEmpty() -> movieDetailView?.showMovieCoverPlaceholder()
                else -> movieDetailView?.showMovieInfo(movie)
            }
        } else {
            movieDetailView?.hideMovieInfo()
        }
    }

    override fun onDestroy() {
        this.movieDetailView = null
    }


}