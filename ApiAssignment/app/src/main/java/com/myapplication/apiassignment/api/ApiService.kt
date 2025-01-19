package com.myapplication.apiassignment.api

import android.telecom.Call
import com.myapplication.apiassignment.model.Photo
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    fun getUsers(): retrofit2.Call<List<Photo>>

}
