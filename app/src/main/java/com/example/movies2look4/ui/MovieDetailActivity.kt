package com.example.movies2look4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movies2look4.R
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.hide()
        fillMovieInfo()

    }

    fun fillMovieInfo() {
        intent.extras?.let {
            Glide.with(this)
                .load(it.getString("coverUrl"))
                .into(movie_cover)
            Glide.with(this)
                .load(it.getString("posterUrl"))
                .into(movie_poster)
            movie_title_value.text = it.getString("englishTitle")
            original_movie_title_value.text = it.getString("originalTitle")
            release_date_value.text = it.getString("releaseDate")
            rating_value.text = it.getString("rating")
            vote_count.text = it.getString("voteCount")
            movie_overview_value.text = it.getString("overview")
        }
    }
}