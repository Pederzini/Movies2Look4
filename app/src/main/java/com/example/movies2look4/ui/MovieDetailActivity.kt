package com.example.movies2look4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies2look4.R
import com.example.movies2look4.models.Movie
import com.example.movies2look4.extensions.toImageUrl
import kotlinx.android.synthetic.main.activity_movie_detail.*

const val EXTRA_MOVIE = "movie"

class MovieDetailActivity : AppCompatActivity() {

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
        intent.extras?.let {
            val movie = it.getParcelable(EXTRA_MOVIE) as Movie?

            if (movie != null) {
                Glide.with(this)
                    .load(movie.backdropPath.toImageUrl())
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .into(movie_cover)
                Glide.with(this)
                    .load(movie.posterPath.toImageUrl())
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .into(movie_poster)
                movie_title_value.text = movie.title
                original_movie_title_value.text = movie.originalTitle
                release_date_value.text = movie.releaseDate
                rating_value.text = movie.voteAverage.toString()
                vote_count.text = movie.voteCount.toString()
                movie_overview_value.text = movie.overview
            }
        }
    }
}