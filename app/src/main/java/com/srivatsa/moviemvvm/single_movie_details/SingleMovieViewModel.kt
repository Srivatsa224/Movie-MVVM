package com.srivatsa.moviemvvm.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.srivatsa.moviemvvm.data.repository.NetworkState
import com.srivatsa.moviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository:MovieDetailsRepository,movieId:Int):ViewModel()
{
    private val compositeDisposable= CompositeDisposable()

    val movieDetails:LiveData<MovieDetails> by lazy{
    movieRepository.fetchSingleMovieDetails(compositeDisposable,movieId)
}

    val networkState:LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    //when activity or fragment is destroyed, to avoid memory leaks
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}