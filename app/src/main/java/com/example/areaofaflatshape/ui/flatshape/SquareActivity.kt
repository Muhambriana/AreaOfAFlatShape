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
        // Init EditText that will be side one form
        val edSideOne: EditText = findViewById(R.id.ed_side_one)
        // Init EditText that will be side two form
        val edSideTwo: EditText = findViewById(R.id.ed_side_two)
        // Init Button to calculate
        val btnResult: Button = findViewById(R.id.btn_result)
        // Init TextView for showing the result
        val tvResult: TextView = findViewById(R.id.tv_result)


        btnResult.setOnClickListener {
            // If edSideOne or edSideTwo not filled yet. Than show toast message
            if (edSideOne.text.isNullOrBlank() || edSideTwo.text.isNullOrBlank()) {
                Toast.makeText(this, "Harap Isi Kedua Sisi Terlebih Dahulu", Toast.LENGTH_LONG).show()

                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the side one value
            val sideOne: Double = edSideOne.text?.toString()?.toDouble() ?: 0.0
            // Get the side one value
            val sideTwo: Double = edSideTwo.text?.toString()?.toDouble() ?: 0.0
            // Calculate side one and side two value with formula  (S X S)
            val result: Double = sideOne * sideTwo

            // Make the TextView visible
            tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            tvResult.text = result.toString()
        }
    }
}