package com.example.chamasmart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chamasmart.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (binding.pinInput.text.toString() == "1234") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                binding.pinInput.error = "Invalid PIN"
            }
        }
    }
}