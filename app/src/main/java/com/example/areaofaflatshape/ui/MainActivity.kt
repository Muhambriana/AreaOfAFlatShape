package com.example.areaofaflatshape.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.R
import com.example.areaofaflatshape.ui.flatshape.CircleActivity
import com.example.areaofaflatshape.ui.flatshape.RectangleActivity
import com.example.areaofaflatshape.ui.flatshape.SquareActivity
import com.example.areaofaflatshape.ui.flatshape.TriangleActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initButton()
    }

    private fun initButton() {
        // Init button that will move intent to SquareActivity
        val btnSquare: Button = findViewById(R.id.btn_square)
        // Init button that will move intent to RectangleActivity
        val btnRectangle: Button = findViewById(R.id.btn_rectangle)
        // Init button that will move intent to TriangleActivity
        val btnTriangle: Button = findViewById(R.id.btn_triangle)
        // Init button that will move intent to CircleActivity
        val btnCircle: Button = findViewById(R.id.btn_circle)

        /*
            Set Button Listener. The button will execute all code inside { } when clicked
         */
        btnSquare.setOnClickListener {
            startIntent(SquareActivity::class.java)
        }
        btnRectangle.setOnClickListener {
            startIntent(RectangleActivity::class.java)
        }
        btnTriangle.setOnClickListener {
            startIntent(TriangleActivity::class.java)
        }
        btnCircle.setOnClickListener {
            startIntent(CircleActivity::class.java)
        }
    }

    // This function have task to move intent to another activity, as parameter requested
    private fun startIntent(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}