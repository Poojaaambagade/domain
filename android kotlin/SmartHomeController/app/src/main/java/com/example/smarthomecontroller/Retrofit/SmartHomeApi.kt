package com.example.smarthomecontroller.Retrofit

import com.example.smarthomecontroller.Model.DeviceStatus
import retrofit2.http.GET

interface SmartHomeApi {
    @GET("devices/statuses")
    suspend fun getDeviceStatuses(): List<DeviceStatus>

}