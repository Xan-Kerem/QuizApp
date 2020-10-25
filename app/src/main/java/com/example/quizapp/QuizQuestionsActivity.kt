package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.quizapp.data.Question
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding

    private var currentPosition = 1
    private lateinit var questionList: ArrayList<Question>
    private var selectedOptionPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_questions)

        questionList = Constants.getQuestions()

        setQuestions()

        setOnclickListener()
    }

    private fun setOnclickListener() {

        binding.apply {

            optionOneTv.setOnClickListener(this@QuizQuestionsActivity)
            optionTwoTv.setOnClickListener(this@QuizQuestionsActivity)
            optionThreeTv.setOnClickListener(this@QuizQuestionsActivity)
            optionFourTv.setOnClickListener(this@QuizQuestionsActivity)

        }
    }

    private fun setQuestions() {

        val question = questionList[currentPosition - 1]
        currentPosition = 1

        defaultOptionsView()

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

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()

        binding.apply {

            options.add(0, optionOneTv)
            options.add(1, optionTwoTv)
            options.add(2, optionThreeTv)
            options.add(3, optionFourTv)

            for (option in options) {

                option.setTextColor(Color.parseColor("#7A8089"))
                // sets the bolds to def value
                option.typeface = Typeface.DEFAULT

                option.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    R.drawable.default_option_border_bg
                )
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.optionOneTv.id -> {
                selectedOptionView(binding.optionOneTv, 1)
            }

            binding.optionTwoTv.id -> {
                selectedOptionView(binding.optionTwoTv, 2)
            }

            binding.optionThreeTv.id -> {
                selectedOptionView(binding.optionThreeTv, 3)
            }

            binding.optionFourTv.id -> {
                selectedOptionView(binding.optionFourTv, 4)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        // reset everything to default
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        // sets the typeface to bold
        tv.setTypeface(tv.typeface, Typeface.BOLD)

        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )

    }
}