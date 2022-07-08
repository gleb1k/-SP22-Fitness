package com.example.fitness.trainings

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fitness.R

class SecondActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var id = intent.getIntExtra("id", 0)
        var training = TrainingRepository.training.get(id)
        val text = findViewById<TextView>(R.id.textView2)
        val picture = findViewById<ImageView>(R.id.imageView)

        text.setText(
            "${training.name}:" +
                    "\n ${training.text}"
        )

        Glide.with(this)
            .load(TrainingRepository.training.get(id).picture)
            .placeholder(R.drawable.picture1090)
            .error(R.drawable.picture1090)
            .into(picture)
    }
}