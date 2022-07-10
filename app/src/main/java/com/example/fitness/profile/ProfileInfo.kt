package com.example.fitness.profile

import android.content.res.Resources
import android.net.Uri
import android.provider.Settings.Global.getString
import com.example.fitness.R

//Ячейка в RecyclerView
data class ProfileInfo (
    val id : Int,
    val name: String,
    val icon : Int,
    var value : String,
    val url : String,
        )