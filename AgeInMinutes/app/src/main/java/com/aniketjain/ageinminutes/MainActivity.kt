package com.aniketjain.ageinminutes

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aniketjain.ageinminutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // listeners
        listeners()

    }

    @SuppressLint("SetTextI18n")
    private fun listeners() {
        binding.datePickBtn.setOnClickListener {
//            Log.i("btn", "clicked")
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(
                this,
                { _, _, _, _ ->

                    // 1st tv setUp
                    val selectedDate = "$day/${month + 1}/$year"
                    binding.dateTv.text = selectedDate

                    // 2nd tv setUp
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    val date = sdf.parse(selectedDate)
                    val selectedDateInMin = date!!.time / (1000 * 60)

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val currentDateInMin = currentDate!!.time / (1000 * 60)

                    binding.minTv.text = (currentDateInMin - selectedDateInMin).toString()

                }, year, month, day
            )
            dpd.datePicker.maxDate = (Date().time - 86400000)   // not select the future date
            dpd.show()
        }
    }
}