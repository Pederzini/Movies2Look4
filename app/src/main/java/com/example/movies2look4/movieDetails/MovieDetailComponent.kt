package com.example.movies2look4.movieDetails

import com.example.movies2look4.di.components.AppComponent
import com.example.movies2look4.di.scopes.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MovieDetailModule::class])
interface MovieDetailComponent {

    fun inject(movieDetailActivity: MovieDetailActivity)

}