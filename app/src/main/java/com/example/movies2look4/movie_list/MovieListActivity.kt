package com.example.movies2look4.movie_list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies2look4.R
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.model.Movie
import com.example.movies2look4.movie_details.EXTRA_MOVIE
import com.example.movies2look4.movie_details.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MovieListActivity : AppCompatActivity(), MovieListContract.View {

    private val movieListPresenter by lazy {
        MovieListPresenter(
            this,
            MovieListModel()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        moviesGrid.layoutManager = GridLayoutManager(this, 3)
        movieListPresenter.requestDataFromServer()
    }

    override fun onDestroy() {
        super.onDestroy()
        movieListPresenter.onDestroy()
    }

    override fun setDataToRecyclerView(moviesList: List<Movie>) {
        moviesGrid.adapter = MoviesGridAdapter(moviesList) {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, it)
            startActivity(intent)
        }
    }

    override fun onResponseFailure(t: Throwable) {
        Toast.makeText(this, "NETWORK ERROR $t", Toast.LENGTH_SHORT).show()
        // snack bar
        // toast
        // esconder lista de filmes
        // t.cause (fazer no presenter)
        // dar uma olhada no view flipper
    }
}