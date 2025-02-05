package com.example.smartcontrollerapp.repo

import com.example.smartcontrollerapp.api.ApiService

class DeviceRepository(private val apiService: ApiService) {
    suspend fun fetchDeviceStatus() = apiService.getDeviceStatus()
}