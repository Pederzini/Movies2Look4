package com.example.movies2look4.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movies2look4.R
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.network.MoviesApiResponses
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesApiResponses = MoviesApiResponses()
        moviesGrid.layoutManager = GridLayoutManager(this, 3)

        compositeDisposable.add((
                moviesApiResponses.getMovies()
                    .subscribe({ response ->
                        if (!response.results.isNullOrEmpty()) {
                            moviesGrid.adapter = MoviesGridAdapter(response.results) {
                                val intent = Intent(this, MovieDetailActivity::class.java)
                                intent.putExtra(EXTRA_MOVIE, it)
                                startActivity(intent)
                            }
                        }
                    },
                        { t -> throw t }
                    )))
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}