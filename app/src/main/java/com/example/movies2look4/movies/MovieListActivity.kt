package com.example.movies2look4.movies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies2look4.R
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.model.Movie
import com.example.movies2look4.movieDetails.EXTRA_MOVIE
import com.example.movies2look4.movieDetails.MovieDetailActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.HttpException
import java.io.IOException

private const val FLIPPER_PROGRESS = 0
private const val FLIPPER_CONTENT = 1
private const val FLIPPER_ERROR = 2

class MovieListActivity : AppCompatActivity() {

    private val movieListViewModel: MovieListViewModel by lazy {
        ViewModelProvider(this).get(MovieListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         initUI()
    }

    private fun initUI() {
        movies_grid.layoutManager = GridLayoutManager(this, 3)

        movieListViewModel.requestDataFromServer()

        movieListViewModel.viewStateApiError.observe(this, Observer { error ->
            when (error) {
                is IOException -> showErrorTryAgain(R.string.error_internet)
                is HttpException -> {
                    if (error.code() == 500) {
                        showError(R.string.error_server)
                    } else {
                        showErrorTryAgain(R.string.error_generic)
                    }
                }
                else -> showError(R.string.error_app)
            }
        })

        movieListViewModel.viewStateApiResponse.observe(this, Observer {
            setDataToRecyclerView(it)
        })
    }

    private fun setDataToRecyclerView(moviesList: List<Movie>) {
        view_flipper_main.displayedChild = FLIPPER_CONTENT
        movies_grid.adapter = MoviesGridAdapter(moviesList) {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, it)
            startActivity(intent)
        }
    }

    private fun showError(resourceId: Int) {
        view_flipper_main.displayedChild = FLIPPER_ERROR

        Snackbar.make(movie_error_main, getString(resourceId), Snackbar.LENGTH_INDEFINITE)
            .setAction("Close app") { finish() }
            .show()
    }

    private fun showErrorTryAgain(resourceId: Int) {
        view_flipper_main.displayedChild = FLIPPER_ERROR

        Snackbar.make(movie_error_main, getString(resourceId), Snackbar.LENGTH_INDEFINITE)
            .setAction("Try again") {
                view_flipper_main.displayedChild = FLIPPER_PROGRESS
                movieListViewModel.requestDataFromServer()
            }
            .show()
    }

}