package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        val questionList = Constants.getQuestions()

        val currentPosition = 1
        val question = questionList[currentPosition - 1]

        binding.apply {

            progressBar.progress = currentPosition
            val progressText = "$currentPosition / ${progressBar.max}"
            progressTv.text = progressText

            questionTv.text = question.question
            imageIv.setImageResource(question.image)
            optionOneTv.text = question.optionOne
            optionTwoTv.text = question.optionTwo
            optionThreeTv.text = question.optionThree
            optionFourTv.text = question.optionFour

        }
    }
}