package com.example.areaofaflatshape.ui.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.R
import com.example.areaofaflatshape.databinding.ActivityQuizResultBinding
import com.example.areaofaflatshape.ui.quiz.QuizActivity.Companion.IS_CORRECT_ANSWER

class QuizResultActivity : AppCompatActivity() {

    private lateinit var quizResultBinding: ActivityQuizResultBinding
    private var isCorrectAnswer: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Assign value for binding
        quizResultBinding = ActivityQuizResultBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        // SetContentView by calling binding.root
        setContentView(quizResultBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(quizResultBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    @SuppressLint("SetTextI18n")
    private fun initFunction() {
        isCorrectAnswer = intent.getBooleanExtra(IS_CORRECT_ANSWER, false)

        if (isCorrectAnswer == true) {
            quizResultBinding.ivReaction.setImageResource(R.drawable.correct)
            quizResultBinding.tvResult.text = "Benar"
        } else {
            quizResultBinding.ivReaction.setImageResource(R.drawable.wrong)
            quizResultBinding.tvResult.text = "Salah"
        }
    }
}