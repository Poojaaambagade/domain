package com.example.smarthomecontroller.Ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.smarthomecontroller.Retrofit.RetrofitClient
import com.example.smarthomecontroller.Retrofit.SmartHomeApi
import com.example.smarthomecontroller.databinding.FragmentDashboardBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        fetchDeviceStatuses()
        return binding.root
    }

    private fun fetchDeviceStatuses() {
        val api = RetrofitClient.instance.create(SmartHomeApi::class.java)

        lifecycleScope.launch {
            try {
                val statuses = withContext(Dispatchers.IO) { api.getDeviceStatuses() }
                binding.tvDashboard.text = statuses.toString()
            } catch (e: Exception) {
                Log.e("DashboardFragment", "Error fetching statuses", e)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
