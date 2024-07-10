package com.example.areaofaflatshape.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.R

class QuizActivity : AppCompatActivity() {
    private var length: Double = 50.0
    private var width: Double = 30.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        val edAnswer: EditText = findViewById(R.id.ed_your_answer)
        val btnResult: Button = findViewById(R.id.btn_result)
        val answer= edAnswer.text

        btnResult.setOnClickListener {
            if (answer.isNullOrBlank()) {
                Toast.makeText(this, "Isi Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val isCorrectAnswer = answer.toString().toDouble() == (length * width)
            val intent = Intent(this, QuizResultActivity::class.java)
            intent.putExtra(IS_CORRECT_ANSWER, isCorrectAnswer)

            startActivity(intent)
        }
    }

    companion object {
         const val IS_CORRECT_ANSWER = "is_correct_answer"
     }
}