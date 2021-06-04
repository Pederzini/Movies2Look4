package com.example.movies2look4.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class MovieListViewModel : ViewModel() {

    private val movieListModel = MovieListModel()
    private val compositeDisposable = CompositeDisposable()

    private val stateApiResponse = MutableLiveData<List<Movie>>()
    val viewStateApiResponse: LiveData<List<Movie>>
        get() = stateApiResponse

    private val stateApiError = MutableLiveData<Throwable>()
    val viewStateApiError: LiveData<Throwable>
        get() = stateApiError

    fun requestDataFromServer() {
        compositeDisposable.add(movieListModel.getMovieList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                if (!response.results.isNullOrEmpty()) {
                    stateApiResponse.value = response.results
                }
            },
                { error -> handleError(error) }
            ))
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is IOException -> stateApiError.value = error
            is HttpException -> {
                if (error.code() == 500) {
                    stateApiError.value = error
                } else {
                    stateApiError.value = error
                }
            }
            else -> stateApiError.value = error
        }
    }

}