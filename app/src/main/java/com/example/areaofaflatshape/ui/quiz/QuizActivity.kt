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
import com.example.areaofaflatshape.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var quizBinding: ActivityQuizBinding
    private var length: Double = 50.0
    private var width: Double = 30.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        quizBinding = ActivityQuizBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(quizBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(quizBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    private fun initFunction() {
        quizBinding.btnResult.setOnClickListener {
            if (quizBinding.edYourAnswer.text.isNullOrBlank()) {
                Toast.makeText(this, "Isi Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val isCorrectAnswer = quizBinding.edYourAnswer.text.toString().toDouble() == (length * width)
            val intent = Intent(this, QuizResultActivity::class.java)
            intent.putExtra(IS_CORRECT_ANSWER, isCorrectAnswer)

            startActivity(intent)
        }
    }

    companion object {
         const val IS_CORRECT_ANSWER = "is_correct_answer"
     }
}