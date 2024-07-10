package com.example.areaofaflatshape.ui.flatshape

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.databinding.ActivityCircleBinding
import com.example.areaofaflatshape.utils.Formula.getAreaOfCircle
import com.example.areaofaflatshape.utils.Helper.isValidEditTextForm
import com.example.areaofaflatshape.utils.Helper.showShortToast

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
            validateEditTextForm()
        }
    }

    private fun validateEditTextForm() {
        if (!isValidEditTextForm(circleBinding.edRadius)) {
            showShortToast("Harap Isi Jari-Jari Terlebih Dahulu")
            return
        }

        calculate()
    }

    private fun calculate() {
        // Get the radius value
        val radius: Double? = circleBinding.edRadius.text?.toString()?.toDouble()
        // Calculate radius value with formula
        val result = getAreaOfCircle(radius)

        // Make the TextView visible
        circleBinding.tvResult.visibility = View.VISIBLE
        // Set result value to TextView
        circleBinding.tvResult.text = result.toString()
    }

}