package com.example.movies2look4.models

data class MovieFewInfo(
    val id: String,
    val title: TitleFew
)

data class TitleFew(
    val title: String,
    val image: ImageFew
)

data class ImageFew(
    val url: String
)

data class Movie(
    val id: String,
    val title: Title,
    val ratings: Ratings,
    val releaseDate: String,
    val plotOutline: PlotOutline
)

data class PlotOutline(
    val author: String,
    val id: String,
    val text: String
)

data class Ratings(
    val rating: Double,
    val ratingCount: Int
//    val topRank: Int
)

data class Title(
    val id: String,
    val image: Image,
    val runningTimeInMinutes: Int,
    val title: String,
    val titleType: String,
    val year: Int
)

data class Image(
    // val height: Int,
    val id: String,
    val url: String
    // val width: Int
)