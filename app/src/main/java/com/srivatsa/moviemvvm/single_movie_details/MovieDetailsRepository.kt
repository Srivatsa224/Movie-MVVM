package com.srivatsa.moviemvvm.single_movie_details

import androidx.lifecycle.LiveData
import com.srivatsa.moviemvvm.data.api.TheMovieDBInterface
import com.srivatsa.moviemvvm.data.repository.MovieDetailsNetworkDataSource
import com.srivatsa.moviemvvm.data.repository.NetworkState
import com.srivatsa.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

// this class is to cache the data in the local

class MovieDetailsRepository(private val apiService:TheMovieDBInterface)
{
    lateinit var movieDetailsNetworkDataSource:MovieDetailsNetworkDataSource
    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable,movieId:Int):
            LiveData<MovieDetails>{

        movieDetailsNetworkDataSource= MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }
    //to get network state live data
    fun getMovieDetailsNetworkState():LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }





}