package com.aniketjain.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aniketjain.quizapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup for binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hide the title bar
        supportActionBar!!.hide()

        // setup for listeners
        listeners()


    }

    private fun listeners() {
        binding.welcomeBtn.setOnClickListener {
            if (binding.nameEt.text == null || binding.nameEt.text!!.isEmpty()) {
                binding.nameEt.error = "Please enter the name"
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra("name", binding.nameEt.text.toString())
                startActivity(intent)
            }
        }
    }


}