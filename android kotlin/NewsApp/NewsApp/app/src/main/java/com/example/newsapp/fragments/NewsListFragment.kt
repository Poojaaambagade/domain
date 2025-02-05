package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import androidx.lifecycle.lifecycleScope

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.api.RetrofitInstance
import kotlinx.coroutines.launch


class NewsListFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        newsAdapter = NewsAdapter(::onSourceClick)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = newsAdapter

        // Load the sources (example API key, replace with actual key)
        lifecycleScope.launch {
            val response = RetrofitInstance.api.getSources("df5a35f38da84a4cb643c4b6d45ad543")
            if (response.isSuccessful) {
                val sources = response.body()?.sources ?: emptyList()
                newsAdapter.submitList(sources)
            }
        }
    }

    private fun onSourceClick(sourceId: String) {
        val action = NewsListFragmentDirections.actionNewsListFragmentToSourceDetailFragment(sourceId)
        findNavController().navigate(action)
    }
}