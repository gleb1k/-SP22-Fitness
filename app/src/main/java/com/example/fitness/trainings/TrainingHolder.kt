package com.example.fitness.trainings

import android.R.attr.name
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.fitness.databinding.ItemTrainingBinding


class TrainingHolder(
    private val binding: ItemTrainingBinding,
    private val glide: RequestManager,
    private val onItemClick: (Training) -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)

    fun onBind(training: Training) {
        with(binding) {
            tvName.text = training.name
            root.setOnClickListener {
                onItemClick(training)
            }

            val resourceId: Int = context.getResources().getIdentifier(
                training.picture, "drawable",
                context.getPackageName()
            )
            ivCover.setImageResource(resourceId);
        }
    }
}