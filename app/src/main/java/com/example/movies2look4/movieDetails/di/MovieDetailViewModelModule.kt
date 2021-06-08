package com.example.movies2look4.movieDetails.di

import com.example.movies2look4.model.Movie
import com.example.movies2look4.movieDetails.MovieDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailViewModelModule = module {
    viewModel { (movie: Movie?) -> MovieDetailViewModel(movie) }
}