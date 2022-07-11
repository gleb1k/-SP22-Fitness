package com.example.fitness.profile.moreprofile

import android.content.Entity
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemMoreprofileBinding
import com.example.fitness.databinding.ItemProfileBinding

class MoreProfileInfoAdapter(
    private val bd : SharedPreferences?,
    private val list: ArrayList<MoreProfileInfo>,
    private val glide: RequestManager,
    private val onItemClick: (MoreProfileInfo) -> Unit,
) : RecyclerView.Adapter<MoreProfileInfoHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoreProfileInfoHolder = MoreProfileInfoHolder(
        bd=bd,
        binding = ItemMoreprofileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    fun updateItem(id: Int, item: Entity) {
        list.add(id,item as MoreProfileInfo)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: MoreProfileInfoHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}