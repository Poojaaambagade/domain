package com.example.movieapplication.api

import com.example.movieapplication.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService {

    @GET("movie")
    fun getMovie(): Call<List<Movie>>

}