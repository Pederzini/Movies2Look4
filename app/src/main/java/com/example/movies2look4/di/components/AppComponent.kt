package com.example.movies2look4.di.components

import com.example.movies2look4.di.modules.AppModule
import com.example.movies2look4.di.modules.NetModule
import com.example.movies2look4.network.MoviesEndpoints
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {

    fun moviesEndpoints(): MoviesEndpoints

}