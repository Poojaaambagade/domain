package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.R
import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.model.Source
import kotlinx.coroutines.launch

class SourceDetailFragment : Fragment(R.layout.fragment_source_detail) {

    private lateinit var sourceId: String
    private lateinit var source: Source

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the source ID passed as argument
        sourceId = arguments?.getString("sourceId") ?: return

        // Fetch source details using Retrofit (you can replace this with an actual API call for details)
        lifecycleScope.launch {
            // Example: Replace with an API call to get more information about the source
            // val response = RetrofitInstance.api.getSourceDetails(sourceId)
            val response = RetrofitInstance.api.getSources("YOUR_API_KEY")
            if (response.isSuccessful) {
                val source = response.body()?.sources?.firstOrNull { it.id == sourceId }
                if (source != null) {
                    displaySourceDetails(source)
                }
            }
        }
    }

    private fun displaySourceDetails(source: Source) {
        // Display the source details in the views
        val titleTextView: TextView = view?.findViewById(R.id.titleTextView) ?: return
        val descriptionTextView: TextView = view?.findViewById(R.id.descriptionTextView) ?: return
        val urlTextView: TextView = view?.findViewById(R.id.urlTextView) ?: return

        titleTextView.text = source.name
        descriptionTextView.text = source.description
        urlTextView.text = source.url
    }
}