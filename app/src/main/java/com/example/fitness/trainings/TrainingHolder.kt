package com.example.fitness.trainings

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.fitness.databinding.ItemTrainingBinding

class TrainingHolder(
    private val binding: ItemTrainingBinding,
    private val onItemClick: (Training) -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(training: Training) {
        with(binding) {
            tvName.text = training.name
            root.setOnClickListener {
                onItemClick(training)
            }

            val resourceId: Int = context.resources.getIdentifier(
                training.picture, "drawable",
                context.packageName
            )
            ivCover.setImageResource(resourceId);
        }
    }
}