package com.example.chamasmart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.chamasmart.data.Member
import com.example.chamasmart.databinding.ActivityAddMemberBinding
import com.example.chamasmart.viewmodel.MemberViewModel

class AddMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMemberBinding
    private val memberViewModel: MemberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveMemberButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val contact = binding.contactInput.text.toString()
            if (name.isNotEmpty() && contact.isNotEmpty()) {
                memberViewModel.insert(Member(name = name, contact = contact))
                finish()
            }
        }
    }
}