package com.example.movies2look4.movie_details

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies2look4.R
import com.example.movies2look4.extensions.toImageUrl
import com.example.movies2look4.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

const val EXTRA_MOVIE = "movie"

class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View {

    private val movieDetailPresenter by lazy {
        MovieDetailPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.hide()
        setAnimations()
        fillMovieInfo()

        fab.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        movieDetailPresenter.onDestroy()
    }

    private fun setAnimations() {
        view_flipper.inAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        view_flipper.outAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
    }

    private fun fillMovieInfo() {
        intent.extras?.let {
            val movie = it.getParcelable(EXTRA_MOVIE) as Movie?
            movieDetailPresenter.checkMovie(movie)
        }
    }

    override fun hideMovieInfo() {
        view_flipper.showNext()

        fab_movie_error.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showMovieInfo(movie: Movie) {
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

    override fun hideMovieTitle() {
        movie_title_value.visibility = View.GONE
    }

    override fun hideMovieOriginalTitle() {
        original_movie_title_value.visibility = View.GONE
    }

    override fun hideMovieReleaseDate() {
        release_date_value.visibility = View.GONE
    }

    override fun hideMovieRating() {
        rating_value.visibility = View.GONE
    }

    override fun hideMovieVoteCount() {
        vote_count.visibility = View.GONE
    }

    override fun hideMovieOverview() {
        movie_overview_value.visibility = View.GONE
    }

    override fun showMoviePosterPlaceholder() {
        movie_poster.setImageResource(R.drawable.placeholder)
    }

    override fun showMovieCoverPlaceholder() {
        movie_poster.setImageResource(R.drawable.ic_broken_image)
    }
}