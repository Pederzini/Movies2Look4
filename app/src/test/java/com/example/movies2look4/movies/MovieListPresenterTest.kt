package com.example.movies2look4.movies

import com.example.movies2look4.R
import com.example.movies2look4.model.Movie
import com.example.movies2look4.model.MoviesList
import com.example.movies2look4.rules.RxImmediateSchedulerRule
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*
import retrofit2.HttpException
import java.io.IOException
import java.lang.IllegalArgumentException

class MovieListPresenterTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()
    private var movieListView: MovieListContract.View = mock()
    private var movieListModel: MovieListModel = mock()
    private val movieListPresenter = MovieListPresenter(movieListView, movieListModel)
    private val movie = Movie(
        "/jdsaj1k.jpg",
        1875,
        "en",
        "Original Movie Title",
        "Overview",
        17.08,
        "/kd454j1k.jpg",
        "1995-12-20",
        "Movie Title",
        false,
        9.2,
        164705L
    )

    @Test
    fun whenDataIsRequestedFromServer_thenReturnASingleAndSetDataToRecyclerView() {
        // Given
        val moviesListExample = MoviesList(listOf(movie, movie, movie))
        whenever(movieListModel.getMovieList()).thenReturn(Single.just(moviesListExample))

        // When
        movieListPresenter.requestDataFromServer()

        // Then
        verify(movieListView).setDataToRecyclerView(moviesListExample.results)
    }

    @Test
    fun givenIOExceptionReturned_whenRequestingFromServer_thenHandleIOException() {
        // Given
        whenever(movieListModel.getMovieList()).thenReturn(Single.error(IOException()))

        // When
        movieListPresenter.requestDataFromServer()

        // Then
        verify(movieListView).showErrorTryAgain(R.string.error_internet)
    }

    @Test
    fun givenHttpException500Returned_whenRequestingFromServer_thenHandleHttpException500() {
        // Given
        val httpException: HttpException = mock()
        whenever(httpException.code()).thenReturn(500)
        whenever(movieListModel.getMovieList()).thenReturn(Single.error(httpException))

        // When
        movieListPresenter.requestDataFromServer()

        // Then
        verify(movieListView).showError(R.string.error_server)
    }

    @Test
    fun givenHttpExceptionOtherThan500Returned_whenRequestingFromServer_thenHandleHttpExceptionOtherThan500() {
        // Given
        val httpException: HttpException = mock()
        whenever(httpException.code()).thenReturn(400)
        whenever(movieListModel.getMovieList()).thenReturn(Single.error(httpException))

        // When
        movieListPresenter.requestDataFromServer()

        // Then
        verify(movieListView).showErrorTryAgain(R.string.error_generic)
    }

    @Test
    fun givenGenericExceptionReturned_whenRequestingFromServer_thenHandleGenericException() {
        // Given
        whenever(movieListModel.getMovieList()).thenReturn(Single.error(IllegalArgumentException()))

        // When
        movieListPresenter.requestDataFromServer()

        // Then
        verify(movieListView).showError(R.string.error_app)
    }

    @Test
    fun givenNullView_whenRequestingDataFromServer_thenNeverSetDataToRecyclerView() {
        // Given
        whenever(movieListModel.getMovieList()).thenReturn(Single.just(MoviesList(listOf(movie, movie, movie))))

        // When
        movieListPresenter.onDestroy()
        movieListPresenter.requestDataFromServer()

        // Then
        verify(movieListView, never()).setDataToRecyclerView(any())
    }
}