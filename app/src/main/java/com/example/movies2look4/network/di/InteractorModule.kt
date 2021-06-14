package com.example.movies2look4.network.di

import com.example.movies2look4.movies.MoviesInteractor
import org.koin.dsl.module

val interactorModule = module {
    factory { MoviesInteractor(get()) }
}