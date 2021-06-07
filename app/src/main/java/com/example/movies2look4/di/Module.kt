package com.example.movies2look4.di

import com.example.movies2look4.movies.MovieListViewModel
import com.example.movies2look4.network.BASE_URL
import com.example.movies2look4.network.MoviesEndpoints
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val movieListViewModelModule = module {
    single { MovieListViewModel() }
}

val netModule = module {

    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideMoviesEndpoint(retrofit: Retrofit): MoviesEndpoints =
        retrofit.create(MoviesEndpoints::class.java)

    single { provideRetrofitInstance() }
    single { provideMoviesEndpoint(get()) }

}