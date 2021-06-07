package com.example.movies2look4.movies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies2look4.R
import com.example.movies2look4.adapter.MoviesGridAdapter
import com.example.movies2look4.di.movieListViewModelModule
import com.example.movies2look4.di.netModule
import com.example.movies2look4.model.Movie
import com.example.movies2look4.movieDetails.EXTRA_MOVIE
import com.example.movies2look4.movieDetails.MovieDetailActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

private const val FLIPPER_PROGRESS = 0
private const val FLIPPER_CONTENT = 1
private const val FLIPPER_ERROR = 2

class MovieListActivity : AppCompatActivity() {

    private val movieListViewModel by viewModel<MovieListViewModel>()
//    private val movieListViewModel: MovieListViewModel by lazy {
//        ViewModelProvider(this).get(MovieListViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin {
            androidContext(this@MovieListActivity)
            androidLogger(Level.DEBUG)
            modules(listOf(movieListViewModelModule, netModule))
        }
        initUI()
    }

    private fun initUI() {
        movies_grid.layoutManager = GridLayoutManager(this, 3)

        movieListViewModel.viewStateApiResponse.observe(this, { response ->
            when (response) {
                is MovieListViewState.ErrorInternet -> showErrorTryAgain(response.errorMessage)
                is MovieListViewState.ErrorServer -> showError(response.errorMessage)
                is MovieListViewState.ErrorGeneric -> showErrorTryAgain(response.errorMessage)
                is MovieListViewState.ErrorApp -> showError(response.errorMessage)
                is MovieListViewState.Success -> setDataToRecyclerView(response.movieList)
            }
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