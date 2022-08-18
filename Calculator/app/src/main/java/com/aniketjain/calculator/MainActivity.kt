package com.aniketjain.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aniketjain.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

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

    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(binding.inputTv.text.toString())) {
            binding.inputTv.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var value = binding.inputTv.text.toString()
            var prefix = ""
            try {
                // checking minus sign is added in starting or not!!
                if (value.startsWith("-")) {
                    prefix = "-"
                    value = value.substring(1)
                }
                when {
                    // subtraction
                    value.contains("-") -> {
                        val splitValue = value.split("-")
                        var one = splitValue[0]
                        val two = splitValue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        binding.inputTv.text =
                            removeZeroAfterDot("${one.toDouble() - two.toDouble()}")
                    }
                    // addition
                    value.contains("+") -> {
                        val splitValue = value.split("+")
                        var one = splitValue[0]
                        val two = splitValue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        binding.inputTv.text =
                            removeZeroAfterDot("${one.toDouble() + two.toDouble()}")
                    }
                    // multiple
                    value.contains("*") -> {
                        val splitValue = value.split("*")
                        var one = splitValue[0]
                        val two = splitValue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        binding.inputTv.text =
                            removeZeroAfterDot("%.2f".format(one.toDouble() * two.toDouble()))
                    }
                    // divide
                    value.contains("/") -> {
                        val splitValue = value.split("/")
                        var one = splitValue[0]
                        val two = splitValue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        binding.inputTv.text =
                            removeZeroAfterDot("${one.toDouble() / two.toDouble()}")
                    }
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if (result.contains(".0")) {
            value = result.substring(0, result.length - 2)
        }
        return value
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*")
                    || value.contains("+") || value.contains("-")
        }
    }
}