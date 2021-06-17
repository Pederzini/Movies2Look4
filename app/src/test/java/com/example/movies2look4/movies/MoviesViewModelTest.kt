package com.example.movies2look4.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies2look4.R
import com.example.movies2look4.model.Movie
import com.example.movies2look4.model.MoviesList
import com.example.movies2look4.rules.RxImmediateSchedulerRule
import com.google.common.truth.Truth.assertThat
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import java.io.IOException
import java.lang.NullPointerException

class MoviesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testSchedulerRule = RxImmediateSchedulerRule()

    private val moviesInteractor: MoviesInteractor = mock()
    private val moviesViewModel by lazy {
        MoviesViewModel(moviesInteractor)
    }

    private val movie = Movie(
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
    fun givenMoviesList_whenDataIsRequestedFromServer_thenReturnASuccessState() {
        // Given
        val moviesListExample = MoviesList(listOf(movie, movie, movie))
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.just(moviesListExample))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isEqualTo(MoviesViewState.Success(moviesListExample.results))
    }

    @Test
    fun givenNullReturn_whenDataIsRequestedFromServer_thenDoNotReturnASuccessState() {
        // Given
        val moviesListExample = MoviesList(listOf(movie, movie, movie))
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.error(NullPointerException()))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isNotEqualTo(MoviesViewState.Success(moviesListExample.results))
    }

    @Test
    fun givenEmptyReturn_whenDataIsRequestedFromServer_thenDoNotReturnASuccessState() {
        // Given
        val moviesListExample = MoviesList(listOf())
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.just(moviesListExample))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isNotEqualTo(MoviesViewState.Success(moviesListExample.results))
    }

    @Test
    fun givenIOExceptionReturned_whenRequestingFromServer_thenReturnIOExceptionState() {
        // Given
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.error(IOException()))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isEqualTo(MoviesViewState.ErrorInternet(R.string.error_internet))
    }

    @Test
    fun givenHttpException500Returned_whenRequestingFromServer_thenReturnHttpException500State() {
        // Given
        val httpException: HttpException = mock()
        whenever(httpException.code()).thenReturn(500)
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.error(httpException))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isEqualTo(MoviesViewState.ErrorServer(R.string.error_server))
    }

    @Test
    fun givenHttpExceptionOtherThan500Returned_whenRequestingFromServer_thenReturnHttpExceptionOtherThan500State() {
        // Given
        val httpException: HttpException = mock()
        whenever(httpException.code()).thenReturn(400)
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.error(httpException))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isEqualTo(MoviesViewState.ErrorGeneric(R.string.error_generic))
    }

    @Test
    fun givenGenericExceptionReturned_whenRequestingFromServer_thenReturnGenericExceptionState() {
        // Given
        whenever(moviesInteractor.getMovieList()).thenReturn(Single.error(IllegalArgumentException()))

        // Then
        assertThat(
            moviesViewModel.viewStateApiResponse.value
        ).isEqualTo(MoviesViewState.ErrorApp(R.string.error_app))
    }

}