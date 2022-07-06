package com.example.fitness.profile


//Хранение ячеек в RecyclerView
object ProfileInfoRepository {
    val infoList = arrayListOf<ProfileInfo>(
        ProfileInfo(
            id = 0,
            name = "Возраст",
            url = ""
        ),
        ProfileInfo(
            id = 1,
            name = "Пол",
            url = ""
        ),
        ProfileInfo(
            id = 2,
            name = "Вес",
            url = ""
        ),ProfileInfo(
            id = 3,
            name = "Рост",
            url = ""
        )
    )
}