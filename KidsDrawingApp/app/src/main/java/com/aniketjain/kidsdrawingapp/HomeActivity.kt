package com.aniketjain.kidsdrawingapp

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.aniketjain.kidsdrawingapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(5.toFloat())
        binding.brushIb.setOnClickListener { showBrushSizeChooserDialog() }

    }

    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size : ")
        val brush1 = brushDialog.findViewById<ImageButton>(R.id.brush_size1)
        val brush2 = brushDialog.findViewById<ImageButton>(R.id.brush_size2)
        val brush3 = brushDialog.findViewById<ImageButton>(R.id.brush_size3)
        val brush4 = brushDialog.findViewById<ImageButton>(R.id.brush_size4)
        val brush5 = brushDialog.findViewById<ImageButton>(R.id.brush_size5)
        brush1.setOnClickListener {
            binding.drawingView.setSizeForBrush(2.5.toFloat())
            brushDialog.dismiss()
        }
        brush2.setOnClickListener {
            binding.drawingView.setSizeForBrush(5.toFloat())
            brushDialog.dismiss()
        }
        brush3.setOnClickListener {
            binding.drawingView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        brush4.setOnClickListener {
            binding.drawingView.setSizeForBrush(15.toFloat())
            brushDialog.dismiss()
        }
        brush5.setOnClickListener {
            binding.drawingView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }
}