package com.aniketjain.quizapp.model

data class QuestionModel(
    val question: String,
    val image: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAns: Int
)