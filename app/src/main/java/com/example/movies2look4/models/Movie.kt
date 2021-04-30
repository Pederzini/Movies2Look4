package com.example.movies2look4.models

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
    val rating: Long? = null,
    val ratingCount: Long? = null,
    val topRank: Long? = null
)

data class Title(
    val id: String? = null,
    val image: Image,
    val runningTimeInMinutes: Long? = null,
    val title: String? = null,
    val titleType: String? = null,
    val year: Long? = null
)

data class Image(
    // val height: Long? = null,
    val id: String? = null,
    val url: String? = null
    // val width: Long
)