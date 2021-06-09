package com.example.movies2look4.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MoviesList(
    val results: List<Movie>
)

@Parcelize
data class Movie(
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    var id: Long?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("original_title")
    var originalTitle: String?,
    var overview: String?,
    var popularity: Double?,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    var title: String?,
    var video: Boolean?,
    @SerializedName("vote_average")
    var voteAverage: Double?,
    @SerializedName("vote_count")
    var voteCount: Long?
) : Parcelable

