package com.example.movies2look4.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://imdb8.p.rapidapi.com"

object MoviesApiConnection {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MoviesEndpoints::class.java)

    fun buildMoviesApiService(): MoviesEndpoints = retrofit

}