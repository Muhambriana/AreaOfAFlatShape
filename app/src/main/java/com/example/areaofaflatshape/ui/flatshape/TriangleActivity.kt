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

class TriangleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triangle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Init EditText that will be form base of triangle
        val edBase: EditText = findViewById(R.id.ed_base)
        // Init EditText that will be form height of triangle
        val edHeight: EditText = findViewById(R.id.ed_height)
        // Init Button to calculate
        val btnResult: Button = findViewById(R.id.btn_result)
        // Init TextView for showing the result
        val tvResult: TextView = findViewById(R.id.tv_result)

        // Set listener on button click
        btnResult.setOnClickListener {
            // If base or height not filled yet. Than show toast message
            if (edBase.text.isNullOrBlank() || edHeight.text.isNullOrBlank()) {
                // Show message as toast
                Toast.makeText(this, "Harap Isi Alas Dan Tinggi Terlebih Dahulu", Toast.LENGTH_LONG).show()
                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the base value
            val base: Double = edBase.text?.toString()?.toDouble() ?: 0.0
            // Get the height value
            val height: Double = edHeight.text?.toString()?.toDouble() ?: 0.0
            // Calculate base and height value with formula  (B X H) / 2
            val result: Double = (base * height) / 2

            // Make the TextView visible
            tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            tvResult.text = result.toString()
        }
    }
}