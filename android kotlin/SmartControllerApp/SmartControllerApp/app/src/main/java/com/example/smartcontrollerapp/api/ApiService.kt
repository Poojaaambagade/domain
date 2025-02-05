package com.example.smartcontrollerapp.api

import retrofit2.http.GET

interface ApiService {
    @GET("devices/status")
    suspend fun getDeviceStatus(): DeviceStatus
}

data class DeviceStatus(val lightsOn: Boolean, val thermostatTemp: Int)