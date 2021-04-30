package com.example.movies2look4.network

import android.util.Log
import com.example.movies2look4.network.MoviesApiConnection.moviesApiService
import org.intellij.lang.annotations.RegExp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesApiResponses {

    val moviesIdOnly = mutableListOf<String>()
    fun getMoviesIds() {

        moviesApiService().getMoviesIds().enqueue(object : Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                print("Error retrieving data")
            }

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                val pattern = "title|/".toRegex()

                response.body()?.forEach {
                    moviesIdOnly.add(it.replace(pattern, ""))
                }

                println(moviesIdOnly.toString())
            }
        })

    }

}