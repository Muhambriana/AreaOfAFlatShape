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

class SquareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_square)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Init EditText that will be form side one of Square
        val edSide: EditText = findViewById(R.id.ed_side)
        // Init Button to calculate
        val btnResult: Button = findViewById(R.id.btn_result)
        // Init TextView for showing the result
        val tvResult: TextView = findViewById(R.id.tv_result)


        // Set listener on button click
        btnResult.setOnClickListener {
            // If edSide not filled yet. Than show toast message
            if (edSide.text.isNullOrBlank()) {
                // Show message as toast
                Toast.makeText(this, "Harap Isi Sisi Terlebih Dahulu", Toast.LENGTH_LONG).show()

                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the side value
            val side: Double = edSide.text?.toString()?.toDouble() ?: 0.0
            // Calculate side value with formula  (S X S)
            val result: Double = side * side

            // Make the TextView visible
            tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            tvResult.text = result.toString()
        }
    }
}