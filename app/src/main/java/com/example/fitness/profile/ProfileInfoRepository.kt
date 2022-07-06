package com.example.fitness.profile


//Хранение ячеек в RecyclerView
object ProfileInfoRepository {
    val infoList = arrayListOf<ProfileInfo>(
        ProfileInfo(
            id = 0,
            name = "Возраст",
            value = "",
            url = ""
        ),
        ProfileInfo(
            id = 1,
            name = "Пол",
            value = "",
            url = ""
        ),
        ProfileInfo(
            id = 2,
            name = "Вес",
            value = "",
            url = ""
        ),ProfileInfo(
            id = 3,
            name = "Рост",
            value = "",
            url = ""
        )
    )
}