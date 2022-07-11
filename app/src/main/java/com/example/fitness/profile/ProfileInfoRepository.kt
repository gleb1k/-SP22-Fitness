package com.example.fitness.profile

import com.example.fitness.R


//Хранение ячеек в RecyclerView
object ProfileInfoRepository {

    val infoList = arrayListOf<ProfileInfo>(
        ProfileInfo(
            id = 0,
            name = "Возраст",
            value ="",
            icon = R.drawable.ic_sentiment_neutral,
            url = ""
        ),
        ProfileInfo(
            id = 1,
            name = "Пол",
            value = "",
            icon = R.drawable.ic_manwoman,
            url = ""
        ),
        ProfileInfo(
            id = 2,
            name = "Вес",
            value = "",
            icon = R.drawable.ic_weight,
            url = ""
        ), ProfileInfo(
            id = 3,
            name = "Рост",
            value = "",
            icon = R.drawable.ic_humanheight,
            url = ""
        )
    )
}