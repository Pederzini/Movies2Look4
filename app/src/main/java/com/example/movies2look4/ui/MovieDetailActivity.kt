package com.example.movies2look4.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.movies2look4.R

class MovieDetailActivity : AppCompatActivity() {

    lateinit var cover: ImageView
    lateinit var poster: ImageView
    lateinit var title: TextView
    lateinit var originalTitle: TextView
    lateinit var releaseDate: TextView
    lateinit var rating: TextView
    lateinit var voteCount: TextView
    lateinit var overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar?.hide()
        startVariables()
        fillMovieInfo()

    }

    fun startVariables() {
        cover = findViewById(R.id.movie_cover)
        poster = findViewById(R.id.movie_poster)
        title = findViewById(R.id.movie_title_value)
        originalTitle = findViewById(R.id.original_movie_title_value)
        releaseDate = findViewById(R.id.release_date_value)
        rating = findViewById(R.id.rating_value)
        voteCount = findViewById(R.id.vote_count)
        overview = findViewById(R.id.movie_overview_value)
    }

    fun fillMovieInfo() {
        intent.extras?.let {
            Glide.with(this)
                .load(it.getString("coverUrl"))
                .into(cover)
            Glide.with(this)
                .load(it.getString("posterUrl"))
                .into(poster)
            title.text = it.getString("englishTitle")
            originalTitle.text = it.getString("originalTitle")
            releaseDate.text = it.getString("releaseDate")
            rating.text = it.getString("rating")
            voteCount.text = it.getString("voteCount")
            overview.text = it.getString("overview")
        }
    }
}