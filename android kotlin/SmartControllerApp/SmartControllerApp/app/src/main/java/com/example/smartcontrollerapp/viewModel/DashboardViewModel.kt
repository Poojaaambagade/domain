package com.example.smartcontrollerapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
    val isLightOn = MutableLiveData(false)
    val thermostatTemperature = MutableLiveData(22)
}