package com.example.areaofaflatshape.ui.flatshape

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.databinding.ActivityCircleBinding

class CircleActivity : AppCompatActivity() {

    private lateinit var circleBinding: ActivityCircleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        circleBinding = ActivityCircleBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(circleBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(circleBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        // Set listener on button click
        circleBinding.btnResult.setOnClickListener {
            // If edRadius not filled yet. Than show toast message
            if (circleBinding.edRadius.text.isNullOrBlank()) {
                // Show message as toast
                Toast.makeText(this, "Harap Isi Jari-Jari Terlebih Dahulu", Toast.LENGTH_LONG).show()

                return@setOnClickListener // This will return value to setOnClickListener and stop the code (not execute all code below)
            }

            // Get the radius value
            val radius: Double = circleBinding.edRadius.text?.toString()?.toDouble() ?: 0.0
            // Calculate radius value with formula  (3.14 * (R*R))
            val result: Double = 3.14 * (radius * radius)

            // Make the TextView visible
            circleBinding.tvResult.visibility = View.VISIBLE
            // Set result value to TextView
            circleBinding.tvResult.text = result.toString()
        }
    }
}