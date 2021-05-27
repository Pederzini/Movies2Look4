package com.example.movies2look4.movieDetails

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movies2look4.R
import com.example.movies2look4.application.MyApplication
import com.example.movies2look4.extensions.toImageUrl
import com.example.movies2look4.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

const val EXTRA_MOVIE = "movie"

class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View {

    @Inject
    lateinit var movieDetailPresenter: MovieDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        initDagger()

        supportActionBar?.hide()
        fillMovieInfo()

        fab.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initDagger() {
        DaggerMovieDetailComponent.builder()
            .appComponent((application as MyApplication).appComponent)
            .movieDetailModule(MovieDetailModule(this))
            .build()
            .inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        movieDetailPresenter.onDestroy()
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