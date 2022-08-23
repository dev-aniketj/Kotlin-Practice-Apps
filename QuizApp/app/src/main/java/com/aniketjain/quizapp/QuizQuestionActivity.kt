package com.aniketjain.quizapp

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aniketjain.quizapp.databinding.ActivityQuizQuestionBinding
import com.aniketjain.quizapp.utils.QuestionsData

class QuizQuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionBinding

    private val quesList = QuestionsData.getQues()
    private var currentPos = 1
    private var selectedAnswer = 0
    private var marks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup for binding
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // progress bar max value
        binding.progressBar.max = quesList.size

        // for 1st ques
        questionAsk(currentPos)

        listeners()
    }

    @SuppressLint("SetTextI18n")
    private fun listeners() {
        // when user click on submit
        binding.submitBtn.setOnClickListener {
            checkAnswer(currentPos)
            if (quesList.size > currentPos) {
                currentPos++
                questionAsk(currentPos)
            }
            checkLastQues(currentPos)

        }

        binding.option1Tv.setOnClickListener {
            selectedOptionsView(binding.option1Tv)
            selectedAnswer = 1
        }
        binding.option2Tv.setOnClickListener {
            selectedOptionsView(binding.option2Tv)
            selectedAnswer = 2
        }
        binding.option3Tv.setOnClickListener {
            selectedOptionsView(binding.option3Tv)
            selectedAnswer = 3
        }
        binding.option4Tv.setOnClickListener {
            selectedOptionsView(binding.option4Tv)
            selectedAnswer = 4
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(binding.option1Tv)
        options.add(binding.option2Tv)
        options.add(binding.option3Tv)
        options.add(binding.option4Tv)

        for (i in options) {
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(this, R.drawable.option_bg)
        }
    }

    private fun selectedOptionsView(textView: TextView) {
        defaultOptionsView()

        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)

    }

    @SuppressLint("SetTextI18n")
    private fun questionAsk(currentPos: Int) {
        val ques = quesList[currentPos - 1]
        binding.progressBar.progress = currentPos
        binding.progressBarTv.text = "$currentPos/${quesList.size}"
        binding.questionTv.text = ques.question
        binding.imageIv.setImageResource(ques.image)
        binding.option1Tv.text = ques.option1
        binding.option2Tv.text = ques.option2
        binding.option3Tv.text = ques.option3
        binding.option4Tv.text = ques.option4
    }

    private fun checkAnswer(currentPos: Int) {
        if (selectedAnswer == quesList[currentPos - 1].correctAns) {
            marks++
        }
        Toast.makeText(this, marks.toString(), Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun checkLastQues(currentPos: Int) {
        // set text for last question
        if (quesList.size == currentPos) {
            binding.submitBtn.text = "Finish"
        }
    }

}