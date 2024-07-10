package com.example.areaofaflatshape.ui.flatshape

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.databinding.ActivitySquareBinding

class SquareActivity : AppCompatActivity() {

    private lateinit var squareBinding: ActivitySquareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        squareBinding = ActivitySquareBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(squareBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(squareBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Set listener on button click
        squareBinding.btnResult.setOnClickListener {
            // If edSide not filled yet. Than show toast message
            if (squareBinding.edSide.text.isNullOrBlank()) {
                // Show message as toast
                Toast.makeText(this, "Harap Isi Sisi Terlebih Dahulu", Toast.LENGTH_LONG).show()

                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the side value
            val side: Double = squareBinding.edSide.text?.toString()?.toDouble() ?: 0.0
            // Calculate side value with formula  (S X S)
            val result: Double = side * side

            // Make the TextView visible
            squareBinding.tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            squareBinding.tvResult.text = result.toString()
        }
    }
}