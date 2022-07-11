package com.example.fitness.profile

import android.annotation.SuppressLint
import android.content.Entity
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemProfileBinding

class ProfileInfoAdapter(
    private val bd : SharedPreferences?,
    private val list: ArrayList<ProfileInfo>,
    private val glide: RequestManager,
    private val onItemClick: (ProfileInfo) -> Unit,
) : RecyclerView.Adapter<ProfileInfoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileInfoHolder = ProfileInfoHolder(
        bd=bd,
        binding = ItemProfileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    fun updateItem(id: Int, item: Entity) {
        list.add(id,item as ProfileInfo)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: ProfileInfoHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}