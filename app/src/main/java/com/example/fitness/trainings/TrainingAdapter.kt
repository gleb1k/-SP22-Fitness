package com.example.fitness.trainings

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemTrainingBinding
import kotlin.coroutines.coroutineContext

class TrainingAdapter(
    private var list: List<Training>,
    private val glide: RequestManager,
    private val context: Context,
    private val onItemClick: (Training) -> Unit
): RecyclerView.Adapter<TrainingHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainingHolder = TrainingHolder(
        binding = ItemTrainingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick,
        context = context
    )

    override fun onBindViewHolder(
        holder: TrainingHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Training>) {
        list = newList
        notifyDataSetChanged()
    }
}