package com.aniketjain.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aniketjain.quizapp.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup binding
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usernameTv.text = intent.getStringExtra("name")
        binding.scoreTv.text = "You score is ${intent.getIntExtra("marks", 0)} out of ${
            intent.getIntExtra(
                "outOf",
                0
            )
        }"
        binding.finishBtn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}