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

class CircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_circle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Init EditText that will be form radius of Circle
        val edRadius: EditText = findViewById(R.id.ed_radius)
        // Init Button to calculate
        val btnResult: Button = findViewById(R.id.btn_result)
        // Init TextView for showing the result
        val tvResult: TextView = findViewById(R.id.tv_result)


        // Set listener on button click
        btnResult.setOnClickListener {
            // If edRadius not filled yet. Than show toast message
            if (edRadius.text.isNullOrBlank()) {
                // Show message as toast
                Toast.makeText(this, "Harap Isi Jari-Jari Terlebih Dahulu", Toast.LENGTH_LONG).show()

                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the radius value
            val radius: Double = edRadius.text?.toString()?.toDouble() ?: 0.0
            // Calculate radius value with formula  (3.14 * (R*R))
            val result: Double = 3.14 * (radius * radius)

            // Make the TextView visible
            tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            tvResult.text = result.toString()
        }
    }
}