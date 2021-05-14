package com.example.movies2look4.movie_details

import com.example.movies2look4.model.Movie

class MovieDetailPresenter(private var movieDetailView: MovieDetailContract.View?): MovieDetailContract.Presenter {

    override fun checkMovie(movie: Movie?){
        if(movie != null) {
            when {
                movie.title.isEmpty() -> movieDetailView?.hideMovieTitle()
                movie.originalTitle.isEmpty() -> movieDetailView?.hideMovieOriginalTitle()
                movie.releaseDate.isEmpty() -> movieDetailView?.hideMovieReleaseDate()
                movie.voteAverage.isNaN() -> movieDetailView?.hideMovieRating()
                movie.voteCount == 0L -> movieDetailView?.hideMovieVoteCount()
                movie.overview.isEmpty() -> movieDetailView?.hideMovieOverview()
                movie.posterPath.isEmpty() -> movieDetailView?.showMoviePosterPlaceholder()
                movie.backdropPath.isEmpty() -> movieDetailView?.showMovieCoverPlaceholder()
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