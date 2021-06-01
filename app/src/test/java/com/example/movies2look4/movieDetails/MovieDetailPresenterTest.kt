package com.example.movies2look4.movieDetails

import com.example.movies2look4.model.Movie
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify

class MovieDetailPresenterTest {

//    private val movieDetailView: MovieDetailContract.View = mock()
//    private val movieDetailPresenter = MovieDetailViewModel(movieDetailView)

//    @Test
//    fun givenNoMovie_whenCheckingMovie_thenHideMovieInfo() {
//        // Given
//
//        // When
//        movieDetailPresenter.checkMovie(null)
//
//        // Then
//        verify(movieDetailView).hideMovieInfo()
//    }
//
//    @Test
//    fun givenNoMovieTitle_whenCheckingMovie_thenHideMovieTitle() {
//        // Given movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                "Original Movie Title",
//                "Overview",
//                17.08,
//                "/kd454j1k.jpg",
//                "1995-12-20",
//                null,
//                false,
//                9.2,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).hideMovieTitle()
//    }
//
//    @Test
//    fun givenNoMovieOriginalTitle_whenCheckingMovie_thenHideMovieOriginalTitle() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                null,
//                "Overview",
//                17.08,
//                "/kd454j1k.jpg",
//                "1995-12-20",
//                "Movie Title",
//                false,
//                9.2,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).hideMovieOriginalTitle()
//    }
//
//    @Test
//    fun givenNoMovieReleaseDate_whenCheckingMovie_thenHideMovieReleaseDate() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                "Original Movie Title",
//                "Overview",
//                17.08,
//                "/kd454j1k.jpg",
//                null,
//                "Movie Title",
//                false,
//                9.2,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).hideMovieReleaseDate()
//    }
//
//    @Test
//    fun givenNoMovieVoteAverage_whenCheckingMovie_thenHideMovieRating() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                "Original Movie Title",
//                "Overview",
//                17.08,
//                "/kd454j1k.jpg",
//                "1995-12-20",
//                "Movie Title",
//                false,
//                0.0,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).hideMovieRating()
//    }
//
//    @Test
//    fun givenNoMovieVoteCount_whenCheckingMovie_thenHideMovieVoteCount() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                "Original Movie Title",
//                "Overview",
//                17.08,
//                "/kd454j1k.jpg",
//                "1995-12-20",
//                "Movie Title",
//                false,
//                9.2,
//                0L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).hideMovieVoteCount()
//    }
//
//    @Test
//    fun givenNoMovieOverview_whenCheckingMovie_thenHideMovieOverview() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                "Original Movie Title",
//                null,
//                17.08,
//                "/kd454j1k.jpg",
//                "1995-12-20",
//                "Movie Title",
//                false,
//                9.2,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).hideMovieOverview()
//    }
//
//    @Test
//    fun givenEmptyMoviePosterPath_whenCheckingMovie_thenShowMoviePosterPlaceholder() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "/jdsaj1k.jpg",
//                1875,
//                "en",
//                "Original Movie Title",
//                "Overview",
//                17.08,
//                "",
//                "1995-12-20",
//                "Movie Title",
//                false,
//                9.2,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).showMoviePosterPlaceholder()
//    }
//
//    @Test
//    fun givenEmptyMovieBackdropPath_whenCheckingMovie_thenShowMovieCoverPlaceholder() {
//        // Give movie when
//        movieDetailPresenter.checkMovie(
//            Movie(
//                "",
//                1875,
//                "en",
//                "Original Movie Title",
//                "Overview",
//                17.08,
//                "/kd454j1k.jpg",
//                "1995-12-20",
//                "Movie Title",
//                false,
//                9.2,
//                164705L
//            )
//        )
//
//        // Then
//        verify(movieDetailView).showMovieCoverPlaceholder()
//    }
//
//    @Test
//    fun givenMovie_whenCheckingMovie_thenShowMovieInfo() {
//        // Given
//        val exampleMovie = Movie(
//            "/jdsaj1k.jpg",
//            1875,
//            "en",
//            "Original Movie Title",
//            "Overview",
//            17.08,
//            "/kd454j1k.jpg",
//            "1995-12-20",
//            "Movie Title",
//            false,
//            9.2,
//            164705L
//        )
//
//        // When
//        movieDetailPresenter.checkMovie(exampleMovie)
//
//        // Then
//        verify(movieDetailView).showMovieInfo(exampleMovie)
//    }
//
//    @Test
//    fun givenNullView_whenCheckingMovie_thenNeverShowMovieInfo() {
//        // Given
//        val exampleMovie = Movie(
//            "/jdsaj1k.jpg",
//            1875,
//            "en",
//            "Original Movie Title",
//            "Overview",
//            17.08,
//            "/kd454j1k.jpg",
//            "1995-12-20",
//            "Movie Title",
//            false,
//            9.2,
//            164705L
//        )
//
//        // When
//        movieDetailPresenter.onDestroy()
//        movieDetailPresenter.checkMovie(exampleMovie)
//
//        // Then
//        verify(movieDetailView, never()).showMovieInfo(exampleMovie)
//    }
}