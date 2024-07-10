package com.example.areaofaflatshape.ui.flatshape

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.databinding.ActivitySquareBinding
import com.example.areaofaflatshape.utils.Formula.getAreaOfSquare
import com.example.areaofaflatshape.utils.Helper.isValidEditTextForm
import com.example.areaofaflatshape.utils.Helper.showShortToast

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
            validateEditTextForm()
        }
    }

    private fun validateEditTextForm() {
        // If edSide not filled yet. Than show toast message
        if (!isValidEditTextForm(squareBinding.edSide)) {
            // Show message as toast
            showShortToast("Harap Isi Sisi Terlebih Dahulu")
            return
        }

        calculate()
    }

    private fun calculate() {
        // Get the side value
        val side: Double = squareBinding.edSide.text?.toString()?.toDouble() ?: 0.0
        // Calculate side value with formula  (S X S)
        val result: Double = getAreaOfSquare(side)

        // Make the TextView visible
        squareBinding.tvResult.visibility = View.VISIBLE
        // Set result value to TextView
        squareBinding.tvResult.text = result.toString()
    }
}