package com.example.movies2look4.network

import com.example.movies2look4.models.Movie
import com.example.movies2look4.models.PopularMovies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesEndpoints {

    @GET("/title/get-most-popular-movies")
    @Headers("x-rapidapi-key: 8550a0c4c6msh2c98c0b51bdaaf7p1107fdjsn97d432ee8632")
    fun getMoviesIds(): Observable<List<String>>

    @GET("/title/get-overview-details")
    @Headers(
        "x-rapidapi-key: 8550a0c4c6msh2c98c0b51bdaaf7p1107fdjsn97d432ee8632",
        "x-rapidapi-host: imdb8.p.rapidapi.com"
    )
    fun getMoviesDetails(@Query("tconst") tconst: String): Observable<Movie>
}