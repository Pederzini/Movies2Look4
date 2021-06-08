package com.example.movies2look4

import android.app.Application
import com.example.movies2look4.movieDetails.di.movieDetailViewModelModule
import com.example.movies2look4.movies.di.movieListViewModelModule
import com.example.movies2look4.network.di.interactorModule
import com.example.movies2look4.network.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                listOf(
                    movieListViewModelModule,
                    movieDetailViewModelModule,
                    netModule,
                    interactorModule
                )
            )
        }
    }

}