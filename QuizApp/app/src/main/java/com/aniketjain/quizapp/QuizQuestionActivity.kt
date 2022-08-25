package com.aniketjain.quizapp

import android.annotation.SuppressLint
import android.content.Intent
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
    private var userName: String = ""
    private val quesList = QuestionsData.getQues()
    private lateinit var ques: QuestionModel
    private var currentPos = 1
    private var selectedAnswer = 0
    private var marks = 0

    private var nextQuesFlag = false
    private var finishFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup for binding
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set username
        userName = intent.getStringExtra("name").toString()

        // progress bar max value
        binding.progressBar.max = quesList.size

        // for 1st ques
        questionAsk(currentPos)

        listeners()
    }

    /**
     * LISTENER
     */

    @SuppressLint("SetTextI18n")
    private fun listeners() {
        // when user click on submit
        binding.submitBtn.setOnClickListener {
            checkFinish()
            btnText()

            if (nextQuesFlag) {
                if (quesList.size > currentPos) {
                    currentPos++
                    questionAsk(currentPos)
                }
            }
            if (!nextQuesFlag && selectedAnswer != 0) {
                // when answer is wrong
                if (ques.correctAns != selectedAnswer) {
                    answerView(selectedAnswer, R.drawable.wrong_option_bg)
                }
                // drawable overload background on it, so we are just applying
                // correct answer background on it.
                answerView(ques.correctAns, R.drawable.correct_option_bg)
                checkAnswer()
            }
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

    /**
     * OPTIONS
     */

    // set all text as normal or default when user select another option
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

    // when user select the option
    private fun selectedOptionsView(textView: TextView) {
        defaultOptionsView()
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                binding.option1Tv.background = ContextCompat.getDrawable(this, drawable)
            }
            2 -> {
                binding.option2Tv.background = ContextCompat.getDrawable(this, drawable)
            }
            3 -> {
                binding.option3Tv.background = ContextCompat.getDrawable(this, drawable)
            }
            4 -> {
                binding.option4Tv.background = ContextCompat.getDrawable(this, drawable)
            }
        }
    }

    /**
     * QUESTION
     * ANSWER
     */

    @SuppressLint("SetTextI18n")
    private fun questionAsk(currentPos: Int) {
        ques = quesList[currentPos - 1]
        binding.progressBar.progress = currentPos
        binding.progressBarTv.text = "$currentPos/${quesList.size}"
        binding.questionTv.text = ques.question
        binding.imageIv.setImageResource(ques.image)
        binding.option1Tv.text = ques.option1
        binding.option2Tv.text = ques.option2
        binding.option3Tv.text = ques.option3
        binding.option4Tv.text = ques.option4

        // when user start new question, the flag is FALSE
        nextQuesFlag = false
        selectedAnswer = 0
        defaultOptionsView()

    }

    private fun checkAnswer() {
        if (selectedAnswer == ques.correctAns) {
            marks++
        }
        nextQuesFlag = true
    }

    /**
     * CHANGE BUTTON TEXT
     */

    private fun btnText() {
        // set text for last question, otherwise go ahead
        if (!nextQuesFlag) {
            binding.submitBtn.text = "Go To Next"
        } else {
            binding.submitBtn.text = "Submit"
        }

        if (quesList.size == currentPos) {
            binding.submitBtn.text = "Finish"
            finishFlag = true
        }
    }

    /**
     * CHECK LAST QUESTION
     */

    private fun checkFinish() {
        if (finishFlag) {
            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("name", userName)
            intent.putExtra("marks", marks)
            startActivity(intent)
        }
    }

}