package com.example.movies2look4.movie_list

import com.example.movies2look4.model.Movie

interface MovieListContract {

    interface View {

        fun setDataToRecyclerView(moviesList: List<Movie>)

        fun onResponseFailure(t: Throwable)

    }

    interface Presenter {

        fun onDestroy()

        fun requestDataFromServer()

    }

}