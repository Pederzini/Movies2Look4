package com.example.movies2look4.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://imdb8.p.rapidapi.com"

object MoviesApiConnection {

    private fun getRetrofitInstance(): Retrofit{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun moviesApiService(): MoviesEndpoints = getRetrofitInstance().create(MoviesEndpoints::class.java)

}