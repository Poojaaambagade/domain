package com.example.smarthomecontroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.smarthomecontroller.MainActivity

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewStatus = findViewById<TextView>(R.id.textViewStatus)
        mainViewModel.deviceStatus.observe(this, Observer { status ->
            textViewStatus.text = status
        })

        mainViewModel.fetchDeviceStatus()
            mainViewModel.fetchDeviceStatus()
        }
    }

