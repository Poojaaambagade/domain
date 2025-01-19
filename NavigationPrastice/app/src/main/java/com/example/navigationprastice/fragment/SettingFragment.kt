package com.example.navigationprastice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.navigationprastice.R

class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        val textDesc = view.findViewById<TextView>(R.id.textSetId)
        val saveBtn = view.findViewById<Button>(R.id.saveBtn)

        saveBtn.setOnClickListener {

            findNavController().navigate(R.id.action_settingFragment_to_dashboardFragment2)
        }

        return view
    }
}