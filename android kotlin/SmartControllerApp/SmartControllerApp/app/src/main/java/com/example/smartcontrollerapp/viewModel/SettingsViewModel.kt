package com.example.smartcontrollerapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    // Manage light control preference
    val isLightControlEnabled = MutableLiveData(true)

    // Manage thermostat temperature preference
    val preferredTemperature = MutableLiveData(22) // Default to 22°C
}