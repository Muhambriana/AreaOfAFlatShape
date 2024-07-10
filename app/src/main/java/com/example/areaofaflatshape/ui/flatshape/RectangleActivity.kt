package com.example.areaofaflatshape.ui.flatshape

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.databinding.ActivityRectangleBinding
import com.example.areaofaflatshape.utils.Helper.isValidEditTextForm
import com.example.areaofaflatshape.utils.Helper.showShortToast

class RectangleActivity : AppCompatActivity() {

    private lateinit var rectangleBinding: ActivityRectangleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        rectangleBinding = ActivityRectangleBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(rectangleBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(rectangleBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Set listener on button click
        rectangleBinding.btnResult.setOnClickListener {
            validateEditTextForm()
        }
    }

    private fun validateEditTextForm() {
        // If long or width not filled yet. Than show toast message
        if (!isValidEditTextForm(rectangleBinding.edLong)) {
            // Show message as toast
            showShortToast("Harap Isi Panjang Terlebih Dahulu")
            return
        }
        if (!isValidEditTextForm(rectangleBinding.edWidth)) {
            // Show message as toast
            showShortToast("Harap Isi Lebar Terlebih Dahulu")
            return
        }

        calculate()
    }

    private fun calculate() {
        // Get the long value
        val long: Double = rectangleBinding.edLong.text?.toString()?.toDouble() ?: 0.0
        // Get the width value
        val width: Double = rectangleBinding.edWidth.text?.toString()?.toDouble() ?: 0.0
        // Calculate long and width value with formula  (L X W)
        val result: Double = long * width

        // Make the TextView visible
        rectangleBinding.tvResult.visibility = View.VISIBLE
        // Set result value to TextView
        rectangleBinding.tvResult.text = result.toString()
    }
}