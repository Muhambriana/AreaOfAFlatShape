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
            // If base or height not filled yet. Than show toast message
            if (triangleBinding.edBase.text.isNullOrBlank() || triangleBinding.edHeight.text.isNullOrBlank()) {
                // Show message as toast
                Toast.makeText(this, "Harap Isi Alas Dan Tinggi Terlebih Dahulu", Toast.LENGTH_LONG).show()
                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the base value
            val base: Double = triangleBinding.edBase.text?.toString()?.toDouble() ?: 0.0
            // Get the height value
            val height: Double = triangleBinding.edHeight.text?.toString()?.toDouble() ?: 0.0
            // Calculate base and height value with formula  (B X H) / 2
            val result: Double = (base * height) / 2

            // Make the TextView visible
            triangleBinding.tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            triangleBinding.tvResult.text = result.toString()
        }
    }
}