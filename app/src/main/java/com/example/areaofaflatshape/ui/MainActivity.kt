package com.example.areaofaflatshape.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.R
import com.example.areaofaflatshape.databinding.ActivityMainBinding
import com.example.areaofaflatshape.ui.flatshape.CircleActivity
import com.example.areaofaflatshape.ui.flatshape.RectangleActivity
import com.example.areaofaflatshape.ui.flatshape.SquareActivity
import com.example.areaofaflatshape.ui.flatshape.TriangleActivity
import com.example.areaofaflatshape.ui.quiz.QuizActivity

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(activityMainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(activityMainBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initButton()
    }

    private fun initButton() {
        /*
            Set Button Listener. The button will execute all code inside { } when clicked
         */
        activityMainBinding.btnSquare.setOnClickListener {
            startIntent(SquareActivity::class.java)
        }
        activityMainBinding.btnRectangle.setOnClickListener {
            startIntent(RectangleActivity::class.java)
        }
        activityMainBinding.btnTriangle.setOnClickListener {
            startIntent(TriangleActivity::class.java)
        }
        activityMainBinding.btnCircle.setOnClickListener {
            startIntent(CircleActivity::class.java)
        }
        activityMainBinding.btnQuiz.setOnClickListener {
            startIntent(QuizActivity::class.java)
        }
    }

    // This function have task to move intent to another activity, as parameter requested
    private fun startIntent(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}