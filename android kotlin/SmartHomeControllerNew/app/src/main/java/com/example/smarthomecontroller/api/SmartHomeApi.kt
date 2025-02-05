package com.example.smarthomecontroller.api

import com.example.smarthomecontroller.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SmartHomeApi {

    // API call to turn on the light
    @GET("controlLight")
    fun controlLight(@Query("status") status: String): Call<ApiResponse>

    // API call to set the thermostat
    @GET("setThermostat")
    fun setThermostat(@Query("temperature") temperature: Int): Call<ApiResponse>
}
