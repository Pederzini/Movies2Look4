package com.example.movies2look4.models

data class PopularMovies(
    val movies: List<Movie>
)

data class Movie(
    val id: String? = null,
    val title: Title,
    val ratings: Ratings,
    val releaseDate: String? = null,
    val plotOutline: PlotOutline
)

data class PlotOutline(
    val author: String? = null,
    val id: String? = null,
    val text: String? = null
)

data class Ratings(
    val rating: Double? = null,
    val ratingCount: Int? = null
//    val topRank: Int? = null
)

data class Title(
    val id: String? = null,
    val image: Image,
    val runningTimeInMinutes: Int? = null,
    val title: String? = null,
    val titleType: String? = null,
    val year: Int? = null
)

data class Image(
    // val height: Int? = null,
    val id: String? = null,
    val url: String? = null
    // val width: Int
)