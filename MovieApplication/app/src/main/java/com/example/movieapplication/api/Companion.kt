package com.example.movieapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Companion {

    private const val BASE_URL = ""

    val instance: MovieApiService by lazy {

        Retrofit.Builder() //builder
            .baseUrl(BASE_URL)//baseUrl
            .addConverterFactory(GsonConverterFactory.create()) //handle response
            .build() // build the Service
            .create(MovieApiService::class.java)  // for which interface ApiService
    }
}