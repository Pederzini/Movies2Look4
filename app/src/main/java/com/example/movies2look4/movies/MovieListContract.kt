package com.example.movies2look4.movies

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
    }

}