package com.example.movies2look4.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies2look4.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

class MoviesViewModel(private val moviesInteractor: MoviesInteractor) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val stateApiResponse = MutableLiveData<MoviesViewState>()
    val viewStateApiResponse: LiveData<MoviesViewState>
        get() = stateApiResponse

    init {
        requestDataFromServer()
    }

    fun requestDataFromServer() {
        compositeDisposable.add(moviesInteractor.getMovieList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                if (!response.results.isNullOrEmpty()) {
                    stateApiResponse.value = MoviesViewState.Success(response.results)
                }
            },
                { error -> handleError(error) }
            ))
    }

    private fun handleError(error: Throwable) {
        stateApiResponse.value = when (error) {
            is IOException -> MoviesViewState.ErrorInternet(R.string.error_internet)
            is HttpException -> {
                if (error.code() == 500) {
                    MoviesViewState.ErrorServer(R.string.error_server)
                } else {
                    MoviesViewState.ErrorGeneric(R.string.error_generic)
                }
            }
            else -> MoviesViewState.ErrorApp(R.string.error_app)
        }
    }

}