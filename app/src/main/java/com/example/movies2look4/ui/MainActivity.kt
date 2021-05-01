package com.example.movies2look4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies2look4.R
import com.example.movies2look4.network.MoviesApiResponseDetails
import com.example.movies2look4.network.MoviesApiResponseId

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesApiResponseId = MoviesApiResponseId()
        moviesApiResponseId.getMoviesIds()
        val moviesApiResponseDetails = MoviesApiResponseDetails()
        moviesApiResponseDetails.getMoviesDetails()

    }
}