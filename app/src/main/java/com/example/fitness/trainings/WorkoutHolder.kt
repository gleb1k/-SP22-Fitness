package com.example.fitness.trainings

import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemWorkoutBinding

class WorkoutHolder(
    private val binding: ItemWorkoutBinding,
    private val onItemClick: (Workout) -> Unit,
) : RecyclerView.ViewHolder(binding.root){

    fun onBind(workout: Workout){
        with(binding){
            tvTrainingName.text = workout.name
            tvCountOfTraining.text = workout.count
            root.setOnClickListener {
                onItemClick(workout)
            }
        }
    }
}