package com.example.movies2look4.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies2look4.model.Movie
import com.example.movies2look4.model.MoviesList
import com.example.movies2look4.movieDetails.MovieDetailsViewModel
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*

class MoviesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val moviesViewModel = MoviesViewModel()

    val movie = Movie(
        "/jdsaj1k.jpg",
        1875,
        "en",
        "Original Movie Title",
        "Overview",
        17.08,
        "/kd454j1k.jpg",
        "1995-12-20",
        "Title",
        false,
        9.2,
        164705L
    )

    @Test
    fun whenDataIsRequestedFromServer_thenReturnASuccessState() {
        // Given
        val moviesListExample = MoviesList(listOf(movie, movie, movie))


        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then

    }


}