package com.aniketjain.quizapp

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aniketjain.quizapp.databinding.ActivityQuizQuestionBinding
import com.aniketjain.quizapp.model.QuestionModel
import com.aniketjain.quizapp.utils.QuestionsData

class QuizQuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionBinding

    private val quesList = QuestionsData.getQues()
    private var currentPos = 1
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

            this.currentPos++
            if (quesList.size >= currentPos) {
                questionAsk(currentPos)
            }

            if (quesList.size == currentPos) {
                binding.submitBtn.text = "Finish"
            }
        }

        binding.option1Tv.setOnClickListener {
            selectedOptionsView(binding.option1Tv)
        }
        binding.option2Tv.setOnClickListener {
            selectedOptionsView(binding.option2Tv)
        }
        binding.option3Tv.setOnClickListener {
            selectedOptionsView(binding.option3Tv)
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

    }


    @SuppressLint("SetTextI18n")
    private fun questionAsk(currentPos: Int) {
        val ques: QuestionModel = quesList[currentPos - 1]
        binding.progressBar.progress = currentPos
        binding.progressBarTv.text = "$currentPos/${quesList.size}"
        binding.questionTv.text = ques.question
        binding.imageIv.setImageResource(ques.image)
        binding.option1Tv.text = ques.option1
        binding.option2Tv.text = ques.option2
        binding.option3Tv.text = ques.option3
        binding.option4Tv.text = ques.option4
    }
}