package com.example.chamasmart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.chamasmart.databinding.ActivityReportsBinding
import com.example.chamasmart.viewmodel.ContributionViewModel

class ReportsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReportsBinding
    private val contributionViewModel: ContributionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contributionViewModel.getTotalSavings().observe(this, Observer { total ->
            binding.totalSavingsText.text = "Total Savings: ${total ?: 0.0}"
        })
    }
}