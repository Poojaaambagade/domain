package com.example.navigationprastice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.navigationprastice.R

class MainFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // fetch id from mainFragment

        val setFragBtn = view.findViewById<Button>(R.id.settingfrag)
        val dashBtn = view.findViewById<Button>(R.id.dashFrag)

        setFragBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_settingFragment)
        }

        dashBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_dashboardFragment2)
        }
        return  view

    }
}