package com.aniketjain.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aniketjain.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun onDigit(view: View) {
        binding.inputTv.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View) {
        binding.inputTv.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimal(view: View) {
        if (lastNumeric && !lastDot) {
            binding.inputTv.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
}