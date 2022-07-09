package com.example.fitness.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemProfileBinding

class ProfileInfoAdapter(
    private val list: List<ProfileInfo>,
    private val glide: RequestManager,
    private val onItemClick: (ProfileInfo) -> Unit,
) : RecyclerView.Adapter<ProfileInfoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileInfoHolder = ProfileInfoHolder(
        binding = ItemProfileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick
    )


    override fun onBindViewHolder(
        holder: ProfileInfoHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size




}