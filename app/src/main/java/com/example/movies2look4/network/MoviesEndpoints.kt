package com.example.movies2look4.network

import com.example.movies2look4.models.MoviesList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesEndpoints {

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String = API_KEY): Single<MoviesList>

}