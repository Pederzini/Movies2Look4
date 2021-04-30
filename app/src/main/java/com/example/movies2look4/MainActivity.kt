package com.example.movies2look4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies2look4.network.MoviesApiResponses

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val moviesApiResponses = MoviesApiResponses()
            moviesApiResponses.getMoviesIds()
    }
}