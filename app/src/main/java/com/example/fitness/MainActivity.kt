package com.example.fitness

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var controller : NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        // TODO: УБРАЛ ВЕРХНЮЮ СТРАШНУЮ ШТУКУ
        supportActionBar!!.hide();


        val weightSharedPref = getSharedPreferences(
            getString(R.string.preference_weight),
            Context.MODE_PRIVATE
        )
        val editor = weightSharedPref?.edit()
        editor?.putString("WeightDate",null)


        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_view)
        bottomView.setupWithNavController(controller)
    }
}