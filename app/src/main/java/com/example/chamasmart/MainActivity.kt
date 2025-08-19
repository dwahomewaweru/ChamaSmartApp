package com.example.chamasmart

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chamasmart.databinding.ActivityMainBinding
import com.example.chamasmart.viewmodel.MemberViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val memberViewModel: MemberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView layout manager
        binding.membersList.layoutManager = LinearLayoutManager(this)

        // Collect the Flow from MemberViewModel
        lifecycleScope.launch {
            memberViewModel.allMembers.collect { members ->
                binding.membersList.adapter = MemberAdapter(members ?: emptyList())
            }
        }

        // Set up button click listeners
        binding.addMemberButton.setOnClickListener {
            startActivity(Intent(this, AddMemberActivity::class.java))
        }

        binding.addContributionButton.setOnClickListener {
            startActivity(Intent(this, AddContributionActivity::class.java))
        }

        binding.viewReportsButton.setOnClickListener {
            startActivity(Intent(this, ReportsActivity::class.java))
        }
    }
}