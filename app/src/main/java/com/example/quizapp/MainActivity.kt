package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.startBtn.setOnClickListener {

            if (binding.nameEt.text.isNullOrBlank()) {
                Toast.makeText(this, "Plz enter ur name", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, QuizQuestionsActivity::class.java))
                finish()
            }
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }
}