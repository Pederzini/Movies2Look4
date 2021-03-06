package com.example.movies2look4.movies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies2look4.R
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.application.MyApplication
import com.example.movies2look4.model.Movie
import com.example.movies2look4.movieDetails.EXTRA_MOVIE
import com.example.movies2look4.movieDetails.MovieDetailActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

private const val FLIPPER_PROGRESS = 0
private const val FLIPPER_CONTENT = 1
private const val FLIPPER_ERROR = 2

class MovieListActivity : AppCompatActivity(), MovieListContract.View {

    @Inject lateinit var movieListPresenter : MovieListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDagger()
        initUI()
    }

    private fun initDagger() {
        DaggerMovieListComponent.builder()
            .appComponent((application as MyApplication).appComponent)
            .movieListModule(MovieListModule(this))
            .build()
            .inject(this)
    }


    private fun initUI() {
        movies_grid.layoutManager = GridLayoutManager(this, 3)
        movieListPresenter.requestDataFromServer()
    }

    override fun onDestroy() {
        super.onDestroy()
        movieListPresenter.onDestroy()
    }

    override fun setDataToRecyclerView(moviesList: List<Movie>) {
        view_flipper_main.displayedChild = FLIPPER_CONTENT
        movies_grid.adapter = MoviesGridAdapter(moviesList) {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, it)
            startActivity(intent)
        }
    }

    override fun showError(resourceId: Int) {
        view_flipper_main.displayedChild = FLIPPER_ERROR

        Snackbar.make(movie_error_main, getString(resourceId), Snackbar.LENGTH_INDEFINITE)
            .setAction("Close app") { finish() }
            .show()
    }

    override fun showErrorTryAgain(resourceId: Int) {
        view_flipper_main.displayedChild = FLIPPER_ERROR

        Snackbar.make(movie_error_main, getString(resourceId), Snackbar.LENGTH_INDEFINITE)
            .setAction("Try again") {
                view_flipper_main.displayedChild = FLIPPER_PROGRESS
                movieListPresenter.requestDataFromServer()
            }
            .show()
    }

}