package com.example.movies2look4.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"
const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val API_KEY = "bf29c0907a7efae474e0f225d3c03de8"

object MoviesApiConnection {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesEndpoints::class.java)

    fun buildMoviesApiService(): MoviesEndpoints = retrofit

}