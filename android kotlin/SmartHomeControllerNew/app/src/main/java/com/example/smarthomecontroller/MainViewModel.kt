package com.example.smarthomecontroller
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smarthomecontroller.api.RetrofitClient
import com.example.smarthomecontroller.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _deviceStatus = MutableLiveData<String>()
    val deviceStatus: LiveData<String> = _deviceStatus

    private val apiKey = "YOUR_API_KEY_HERE"  // Replace with actual API key

    fun fetchDeviceStatus() {
        RetrofitClient.api.getDeviceStatus(apiKey).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    _deviceStatus.value = response.body()?.message ?: "Unknown"
                } else {
                    _deviceStatus.value = "Error fetching status"
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                _deviceStatus.value = "Network error"
            }
        })
    }
}
