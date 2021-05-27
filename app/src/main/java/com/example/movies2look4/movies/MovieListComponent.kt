package com.example.movies2look4.movies

import com.example.movies2look4.di.components.AppComponent
import com.example.movies2look4.di.scopes.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MovieListModule::class])
interface MovieListComponent {

    fun inject(movieListActivity: MovieListActivity)
}