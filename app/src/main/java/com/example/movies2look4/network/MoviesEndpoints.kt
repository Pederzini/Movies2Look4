package com.example.movies2look4.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesEndpoints {

    @GET("/title/get-most-popular-movies")
    @Headers("x-rapidapi-key: 8550a0c4c6msh2c98c0b51bdaaf7p1107fdjsn97d432ee8632")
    fun getMoviesIds(): Observable<List<String>>

}