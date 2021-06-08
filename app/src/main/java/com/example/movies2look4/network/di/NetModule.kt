package com.example.movies2look4.network.di

import com.example.movies2look4.network.createMoviesApiConnection
import org.koin.dsl.module

val netModule = module {
    single { createMoviesApiConnection() }
}