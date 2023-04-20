package com.example.networks7

import com.example.networks7.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface Data {

    suspend fun applyUi(binding: ActivityMainBinding)

    data class Base(
        private val id: String,
        private val title: String,
        private val body: String
    ) : Data {
        override suspend fun applyUi(binding: ActivityMainBinding) = withContext(Dispatchers.Main) {
            binding.numberTextView.text = id
            binding.titleTextView.text = title
            binding.bodyTextView.text = body
        }
    }
}

