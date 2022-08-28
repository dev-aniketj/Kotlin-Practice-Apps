package com.aniketjain.kidsdrawingapp

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.aniketjain.kidsdrawingapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.drawingView.setSizeForBrush(5.toFloat())
        binding.brushIb.setOnClickListener { showBrushSizeChooserDialog() }

        mImageButtonCurrentPaint = binding.paletteLl[1] as ImageButton  // set black as default
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.palette_selected)
        )


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

    fun paintClicked(view: View) {
        if (view !== mImageButtonCurrentPaint) {
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()
            binding.drawingView.setColor(colorTag)
            imageButton.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palette_selected)
            )
            mImageButtonCurrentPaint!!.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palette_normal)
            )
            mImageButtonCurrentPaint = view
        }
    }
}