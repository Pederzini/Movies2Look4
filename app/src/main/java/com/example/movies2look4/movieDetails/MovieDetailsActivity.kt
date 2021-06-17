package com.example.movies2look4.movieDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies2look4.R
import com.example.movies2look4.extensions.toImageUrl
import com.example.movies2look4.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

const val EXTRA_MOVIE = "movie"

class MovieDetailActivity : AppCompatActivity() {

    private val movieDetailViewModel by inject<MovieDetailsViewModel> {
        parametersOf(
            intent.extras?.let {
                it.getParcelable<Movie>(EXTRA_MOVIE) as Movie
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.hide()
        fillMovieInfo()

        fab.setOnClickListener {
            onBackPressed()
        }
    }

    private fun fillMovieInfo() {
        movieDetailViewModel.viewStateMovie.observe(this, { movieState ->
            if (movieState is MovieDetailsViewState.ShowMovieInfo) showMovieInfo(movieState.movie)
            else hideMovieInfo()
        })
    }

    private fun hideMovieInfo() {
        view_flipper.showNext()

        fab_movie_error.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showMovieInfo(movie: Movie) {
        Glide.with(this)
            .load(movie.backdropPath?.toImageUrl())
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(movie_cover)

        Glide.with(this)
            .load(movie.posterPath?.toImageUrl())
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.placeholder)
            )
            .into(movie_poster)

        movie_title_value.text = movie.title
        original_movie_title_value.text = movie.originalTitle
        release_date_value.text = movie.releaseDate
        rating_value.text = movie.voteAverage.toString()
        vote_count.text = getString(R.string.vote_count, movie.voteCount.toString())
        movie_overview_value.text = movie.overview
    }

}