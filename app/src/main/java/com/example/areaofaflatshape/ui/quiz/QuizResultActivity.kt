package com.example.areaofaflatshape.ui.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.R
import com.example.areaofaflatshape.ui.quiz.QuizActivity.Companion.IS_CORRECT_ANSWER

class QuizResultActivity : AppCompatActivity() {

    private var isCorrectAnswer: Boolean? = null
    private var ivReaction: ImageView? = null
    private var tvResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initFunction()
    }

    @SuppressLint("SetTextI18n")
    private fun initFunction() {
        ivReaction = findViewById(R.id.iv_reaction)
        tvResult = findViewById(R.id.tv_result)
        isCorrectAnswer = intent.getBooleanExtra(IS_CORRECT_ANSWER, false)

        if (isCorrectAnswer == true) {
            ivReaction?.setImageResource(R.drawable.correct)
            tvResult?.text = "Benar"
        } else {
            ivReaction?.setImageResource(R.drawable.wrong)
            tvResult?.text = "Salah"
        }
    }
}