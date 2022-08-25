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
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_australia,
                "Argentina",
                "Australia",
                "Armenia",
                "America",
                2
            )
        )
        // ques 3
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_belgium,
                "Brazil",
                "Belgium",
                "Barbados",
                "Belize",
                2
            )
        )
        // ques 4
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_brazil,
                "Bangladesh",
                "Bahamas",
                "Brazil",
                "Belgium",
                3
            )
        )
        // ques 5
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_denmark,
                "Duchy of Parma",
                "Djibouti",
                "Dominica",
                "Denmark",
                4
            )
        )
        // ques 6
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_fiji,
                "Fiji",
                "France",
                "Finland",
                "French Polynesia",
                1
            )
        )
        // ques 7
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_germany,
                "Gabon",
                "Georgia",
                "Germany",
                "Greenland",
                3
            )
        )
        // ques 8
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_india,
                "Iceland",
                "India",
                "Italy",
                "Ireland",
                2
            )
        )
        // ques 9
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_kuwait,
                "Kyrgyzstan",
                "Korea",
                "Kuwait",
                "Kenya",
                3
            )
        )
        // ques 10
        list.add(
            QuestionModel(
                "What country does this flag belong to ?",
                R.drawable.ic_flag_of_new_zealand,
                "Nigeria",
                "Netherlands",
                "Nepal",
                "New Zealand",
                4
            )
        )

    }

    fun getQues(): ArrayList<QuestionModel> {
        setQues(arrayList)
        arrayList.shuffle()
        return arrayList
    }

}