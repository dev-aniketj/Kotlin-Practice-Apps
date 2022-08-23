package com.aniketjain.quizapp.utils

import com.aniketjain.quizapp.R
import com.aniketjain.quizapp.model.QuestionModel

object QuestionsData {
    private var arrayList = ArrayList<QuestionModel>()

    private fun setQues(list: ArrayList<QuestionModel>) {

        // when ques call back the activity
        list.clear()

        // ques 1
        list.add(
            QuestionModel(
                1,
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_argentina,
                "Argentina",
                "Australia",
                "Armenia",
                "America",
                1
            )
        )
        // ques 2
        list.add(
            QuestionModel(
                2,
                "What country does this flag belong to ? 2",
                R.drawable.ic_flag_of_australia,
                "Argentina",
                "Australia",
                "Armenia",
                "America",
                2
            )
        )
    }

    fun getQues(): ArrayList<QuestionModel> {
        setQues(arrayList)
        return arrayList
    }

}