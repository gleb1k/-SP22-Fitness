package com.example.fitness.profile

import android.net.Uri

//Ячейка в RecyclerView
data class ProfileInfo (
    val id : Int,
    val name: String,
    val icon : Int,
    var value : String,
    val url : String,
        )