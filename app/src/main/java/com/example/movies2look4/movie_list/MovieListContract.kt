package com.example.movies2look4.movie_list

import com.example.movies2look4.model.Movie

interface MovieListContract {

    interface View {
        fun setDataToRecyclerView(moviesList: List<Movie>)
        fun showError(resourceId: Int)
        fun showErrorTryAgain(resourceId: Int)
    }

    interface Presenter {
        fun onDestroy()
        fun requestDataFromServer()
        fun errorHandler(error: Throwable)
    }

}