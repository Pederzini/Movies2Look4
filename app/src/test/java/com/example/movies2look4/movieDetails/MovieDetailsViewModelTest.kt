package com.example.movies2look4.movieDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies2look4.model.Movie
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class MovieDetailsViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun givenNullMovie_whenCheckingMovie_thenHideMovieInfo() {
        // Given
        val movie = null

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.HideMovieInfo)
    }

    @Test
    fun givenNullTitle_whenCheckingMovie_thenShowDefaultTitle() {
        // Given
        val movie = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "Overview",
            17.08,
            "/kd454j1k.jpg",
            "1995-12-20",
            null,
            false,
            9.2,
            164705L
        )

        val movieResult = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "Overview",
            17.08,
            "/kd454j1k.jpg",
            "1995-12-20",
            "-",
            false,
            9.2,
            164705L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

//    @Test
//    fun givenEmptyTitle_whenCheckingMovie_thenShowDefaultTitle() {
//        // Given
//        val movie = Movie(
//            "/jdsaj1k.jpg",
//            1875,
//            "en",
//            "Original Movie Title",
//            "Overview",
//            17.08,
//            "/kd454j1k.jpg",
//            "1995-12-20",
//            "",
//            false,
//            9.2,
//            164705L
//        )
//
//        val movieResult = Movie(
//            "/jdsaj1k.jpg",
//            1875,
//            "en",
//            "Original Movie Title",
//            "Overview",
//            17.08,
//            "/kd454j1k.jpg",
//            "1995-12-20",
//            "-",
//            false,
//            9.2,
//            164705L
//        )
//
//        // When
//        val viewModel = MovieDetailsViewModel(movie)
//
//        // Then
//        // Then
//        assertThat(
//            viewModel.viewStateMovie.value
//        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
//    }

    @Test
    fun givenNullOriginalTitle_whenCheckingMovie_thenShowDefaultOriginalTitle() {
        // Given
        val movie = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            null,
            "Overview",
            17.08,
            "/kd454j1k.jpg",
            "1995-12-20",
            "Title",
            false,
            9.2,
            164705L
        )

        val movieResult = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "-",
            "Overview",
            17.08,
            "/kd454j1k.jpg",
            "1995-12-20",
            "Title",
            false,
            9.2,
            164705L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

    @Test
    fun givenNullReleaseDate_whenCheckingMovie_thenShowDefaultReleaseDate() {
        // Given
        val movie = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "Overview",
            17.08,
            "/kd454j1k.jpg",
            null,
            "Title",
            false,
            9.2,
            164705L
        )

        val movieResult = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "Overview",
            17.08,
            "/kd454j1k.jpg",
            "-",
            "Title",
            false,
            9.2,
            164705L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

    @Test
    fun givenNullVoteAverage_whenCheckingMovie_thenShowDefaultVoteAverage() {
        // Given
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
            null,
            164705L
        )

        val movieResult = Movie(
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
            0.0,
            164705L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

    @Test
    fun givenNullVoteCount_whenCheckingMovie_thenShowDefaultVoteCount() {
        // Given
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
            null
        )

        val movieResult = Movie(
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
            0L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

    @Test
    fun givenNullOverview_whenCheckingMovie_thenShowDefaultOverview() {
        // Given
        val movie = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            null,
            17.08,
            "/kd454j1k.jpg",
            "1995-12-20",
            "Title",
            false,
            9.2,
            164705L
        )

        val movieResult = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "-",
            17.08,
            "/kd454j1k.jpg",
            "1995-12-20",
            "Title",
            false,
            9.2,
            164705L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

    @Test
    fun givenNullPosterPath_whenCheckingMovie_thenShowDefaultPosterPath() {
        // Given
        val movie = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "Overview",
            17.08,
            null,
            "1995-12-20",
            "Title",
            false,
            9.2,
            164705L
        )

        val movieResult = Movie(
            "/jdsaj1k.jpg",
            1875,
            "en",
            "Original Movie Title",
            "Overview",
            17.08,
            "-",
            "1995-12-20",
            "Title",
            false,
            9.2,
            164705L
        )

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

    @Test
    fun givenNullBackdropPath_whenCheckingMovie_thenShowDefaultBackdropPath() {
        // Given
        val movie = Movie(
            null,
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

        val movieResult = Movie(
            "-",
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

        // When
        val viewModel = MovieDetailsViewModel(movie)

        // Then
        assertThat(
            viewModel.viewStateMovie.value
        ).isEqualTo(MovieDetailsViewState.ShowMovieInfo(movieResult))
    }

//    if (movie.title.isNullOrEmpty()) movie.title = "-"
//    if (movie.originalTitle.isNullOrEmpty()) movie.originalTitle = "-"
//    if (movie.releaseDate.isNullOrEmpty()) movie.releaseDate = "-"
//    if (movie.voteAverage == null) movie.voteAverage = 0.0
//    if (movie.voteCount == null) movie.voteCount = 0L
//    if (movie.overview.isNullOrEmpty()) movie.overview = "-"
//    if (movie.posterPath.isNullOrEmpty()) movie.posterPath = "-"
//    if (movie.backdropPath.isNullOrEmpty()) movie.backdropPath = "-"
}