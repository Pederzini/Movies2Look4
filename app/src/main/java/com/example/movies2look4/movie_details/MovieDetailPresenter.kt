package com.example.movies2look4.movie_details

import com.example.movies2look4.model.Movie

private const val ZERO = 0.0

class MovieDetailPresenter(private var movieDetailView: MovieDetailContract.View?): MovieDetailContract.Presenter {

    override fun checkMovie(movie: Movie?){
        if(movie != null) {
            when {
                movie.title.isEmpty() -> movieDetailView?.hideMovieTitle()
                movie.originalTitle.isNullOrBlank() -> movieDetailView?.hideMovieOriginalTitle()
                movie.releaseDate.isNullOrBlank() -> movieDetailView?.hideMovieReleaseDate()
                movie.voteAverage.isNaN() -> movieDetailView?.hideMovieRating()
                movie.voteCount.toDouble().isNaN() || movie.voteCount.toDouble().equals(ZERO)-> movieDetailView?.hideMovieVoteCount()
                movie.overview?.isNullOrBlank() -> movieDetailView?.hideMovieOverview()
                movie.posterPath.isNullOrBlank() -> movieDetailView?.showMoviePosterPlaceholder()
                movie.backdropPath.isNullOrBlank() -> movieDetailView?.showMovieCoverPlaceholder()
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