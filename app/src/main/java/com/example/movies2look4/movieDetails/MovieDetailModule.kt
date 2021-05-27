package com.example.movies2look4.movieDetails

import com.example.movies2look4.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule(private val view: MovieDetailContract.View) {

    @ActivityScope
    @Provides
    fun provideMovieDetailView() = view

    @ActivityScope
    @Provides
    fun provideMovieDetailPresenter(presenter: MovieDetailPresenter): MovieDetailContract.Presenter =
        presenter

}