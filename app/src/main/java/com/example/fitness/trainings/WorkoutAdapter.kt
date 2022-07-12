package com.example.fitness.trainings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemWorkoutBinding

class WorkoutAdapter(
    private val list: List<Workout>,
    private val onItemClick: (Workout) -> Unit,
): RecyclerView.Adapter<WorkoutHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkoutHolder = WorkoutHolder(
        ItemWorkoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onItemClick
    )

    override fun onBindViewHolder(
        holder: WorkoutHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =list.size

}