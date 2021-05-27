package com.example.movies2look4.movies

import com.example.movies2look4.di.scopes.ActivityScope
import com.example.movies2look4.movies.MovieListContract
import com.example.movies2look4.movies.MovieListModel
import com.example.movies2look4.movies.MovieListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieListModule(private val view: MovieListContract.View) {

    @Provides
    @ActivityScope
    fun provideMovieListView() = view

    @Provides
    @ActivityScope
    fun provideMovieListPresenter(presenter: MovieListPresenter): MovieListContract.Presenter = presenter

}