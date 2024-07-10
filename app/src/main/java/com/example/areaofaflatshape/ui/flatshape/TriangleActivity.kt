package com.example.areaofaflatshape.ui.flatshape

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.R
import com.example.areaofaflatshape.databinding.ActivityTriangleBinding
import com.example.areaofaflatshape.utils.Formula
import com.example.areaofaflatshape.utils.Helper
import com.example.areaofaflatshape.utils.Helper.isValidEditTextForm
import com.example.areaofaflatshape.utils.Helper.showShortToast

class TriangleActivity : AppCompatActivity() {

    private lateinit var triangleBinding: ActivityTriangleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        triangleBinding = ActivityTriangleBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(triangleBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(triangleBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Set listener on button click
        triangleBinding.btnResult.setOnClickListener {
            validateEditTextForm()
        }
    }

    private fun validateEditTextForm() {
        // If base or height not filled yet. Than show toast message
        if (!isValidEditTextForm(triangleBinding.edBase)) {
            // Show message as toast
            showShortToast("Harap Isi Alas Terlebih Dahulu")
            return
        }
        if (!isValidEditTextForm(triangleBinding.edHeight)) {
            // Show message as toast
            showShortToast("Harap Isi Tinggi Terlebih Dahulu")
            return
        }

        calculate()
    }


    private fun calculate() {
        // Get the base value
        val base: Double = triangleBinding.edBase.text?.toString()?.toDouble() ?: 0.0
        // Get the height value
        val height: Double = triangleBinding.edHeight.text?.toString()?.toDouble() ?: 0.0
        // Calculate base and height value with formula  (B X H) / 2
        val result: Double = Formula.getAreaOfTriangle(base, height)

        // Make the TextView visible
        triangleBinding.tvResult.visibility = View.VISIBLE
        // Set result value to TextView
        triangleBinding.tvResult.text = result.toString()
    }
}