package com.example.movies2look4.movie_list

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies2look4.R
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.model.Movie
import com.example.movies2look4.movie_details.EXTRA_MOVIE
import com.example.movies2look4.movie_details.MovieDetailActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_detail.*

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
        setAnimations()
        initUI()
    }

    private fun initUI() {
        movies_grid.layoutManager = GridLayoutManager(this, 3)
        movieListPresenter.requestDataFromServer()
    }

    private fun setAnimations() {
        view_flipper_main.inAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        view_flipper_main.outAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
    }

    override fun onDestroy() {
        super.onDestroy()
        movieListPresenter.onDestroy()
    }

    override fun setDataToRecyclerView(moviesList: List<Movie>) {
        movies_grid.adapter = MoviesGridAdapter(moviesList) {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, it)
            startActivity(intent)
        }
    }

    override fun showError(resourceId: Int) {
        view_flipper_main.showNext()

        Snackbar.make(movie_error_main, getString(resourceId), Snackbar.LENGTH_INDEFINITE)
            .setAction("Close app") { onBackPressed() }
            .show()
    }

    override fun showErrorTryAgain(resourceId: Int) {
        view_flipper_main.showNext()

        Snackbar.make(movie_error_main, getString(resourceId), Snackbar.LENGTH_INDEFINITE)
            .setAction("Try again") {
                movieListPresenter.requestDataFromServer()
                view_flipper_main.showPrevious()
            }
            .show()
    }

}