package com.example.movies2look4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies2look4.R
import com.example.movies2look4.network.MoviesApiResponses

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.movies_grid)
        val moviesApiResponses = MoviesApiResponses()
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        moviesApiResponses.getMovies(recyclerView)
    }
}