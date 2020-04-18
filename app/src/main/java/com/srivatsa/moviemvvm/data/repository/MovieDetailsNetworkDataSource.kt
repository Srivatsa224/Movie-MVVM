package com.srivatsa.moviemvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srivatsa.moviemvvm.data.api.TheMovieDBInterface
import com.srivatsa.moviemvvm.data.vo.MovieDetails
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class MovieDetailsNetworkDataSource(private val apiService:TheMovieDBInterface,
                                    private val compositeDesposable:CompositeDisposable)
{
    private val _newtworkstate= MutableLiveData<NetworkState>()
    val newtworkstate:LiveData<NetworkState>
    get() = _newtworkstate

    private val _downloadedMovieDetailsResponse= MutableLiveData<MovieDetails>()
    val downloadedMovieDetailsResponse:LiveData<MovieDetails>
        get() = _downloadedMovieDetailsResponse

    fun fetchMovieDetails(movieId:Int)
    {
        _newtworkstate.postValue(NetworkState.LOADING)
        try {
            compositeDesposable.add(
            apiService.getMovieDetails(movieId))
                .subscribeOn(Schedulers.io())
                .subscribe(

                )

        }
        catch (e:Exception)
        {

        }


    }





}