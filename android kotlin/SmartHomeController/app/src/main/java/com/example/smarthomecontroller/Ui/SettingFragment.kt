package com.example.smarthomecontroller.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.smarthomecontroller.databinding.FragmentSettingBinding
import java.util.concurrent.TimeUnit

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.btnSync.setOnClickListener {
            scheduleSyncTask()
        }

        return binding.root
    }

    private fun scheduleSyncTask() {
        val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(requireContext()).enqueue(syncRequest)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class SyncWorker(context: android.content.Context, params: WorkerParameters) : Worker(context, params) {
        override fun doWork(): Result {
            // Simulate syncing task
            return Result.success()
        }
    }
}