package com.example.areaofaflatshape.ui.quiz

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.areaofaflatshape.databinding.ActivityQuizBinding
import com.example.areaofaflatshape.utils.Formula
import com.example.areaofaflatshape.utils.Helper.isValidEditTextForm
import com.example.areaofaflatshape.utils.Helper.showShortToast

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
            validateEditTextForm()
        }
    }

    private fun validateEditTextForm() {
        if (!isValidEditTextForm(quizBinding.edYourAnswer)) {
            showShortToast("Isi Jawaban Terlebih Dahulu")
            return
        }
        startIntentWithData()
    }

    private fun startIntentWithData() {
        val isCorrectAnswer = quizBinding.edYourAnswer.text.toString().toDouble() == Formula.getAreaOfRectangle(width, length)
        val intent = Intent(this, QuizResultActivity::class.java)
        intent.putExtra(IS_CORRECT_ANSWER, isCorrectAnswer)

        startActivity(intent)
    }

    companion object {
         const val IS_CORRECT_ANSWER = "is_correct_answer"
     }
}