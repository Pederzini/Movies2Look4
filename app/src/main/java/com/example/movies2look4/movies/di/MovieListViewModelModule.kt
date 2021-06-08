package com.example.movies2look4.movies.di

import com.example.movies2look4.movies.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieListViewModelModule = module {
    viewModel { MovieListViewModel() }
}