package com.example.chamasmart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.chamasmart.databinding.ActivityReportsBinding
import com.example.chamasmart.viewmodel.ContributionViewModel
import kotlinx.coroutines.launch


class ReportsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReportsBinding
    private val contributionViewModel: ContributionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Collect the Flow in a lifecycle-aware manner
        lifecycleScope.launch {
            contributionViewModel.getTotalSavings().collect { total ->
                binding.totalSavingsText.text = "Total Savings: ${total ?: 0.0}"
            }
        }
    }
}