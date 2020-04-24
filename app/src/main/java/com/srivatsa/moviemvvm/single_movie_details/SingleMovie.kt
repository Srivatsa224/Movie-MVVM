package com.srivatsa.moviemvvm.single_movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.srivatsa.moviemvvm.R
import com.srivatsa.moviemvvm.data.vo.MovieDetails

class SingleMovie : AppCompatActivity() {

    private lateinit var viewModel:SingleMovieViewModel
    private lateinit var movieRepository:MovieDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)
    }
}
