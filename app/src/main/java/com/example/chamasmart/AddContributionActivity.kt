package com.example.chamasmart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.chamasmart.data.Contribution
import com.example.chamasmart.databinding.ActivityAddContributionBinding
import com.example.chamasmart.viewmodel.ContributionViewModel

class AddContributionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddContributionBinding
    private val contributionViewModel: ContributionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContributionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveContributionButton.setOnClickListener {
            val memberId = binding.memberIdInput.text.toString().toIntOrNull() ?: return@setOnClickListener
            val amount = binding.amountInput.text.toString().toDoubleOrNull() ?: return@setOnClickListener
            val date = binding.dateInput.text.toString()
            val notes = binding.notesInput.text.toString()
            if (date.isNotEmpty()) {
                contributionViewModel.insert(Contribution(memberId = memberId, amount = amount, date = date, notes = notes))
                finish()
            }
        }
    }
}