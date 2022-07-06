package com.example.fitness.profile

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemProfileBinding

class ProfileInfoHolder(
    private val binding: ItemProfileBinding,
    private val glide: RequestManager,
    private val onItemClick: (ProfileInfo) -> Unit,
) :RecyclerView.ViewHolder(binding.root) {

    fun onBind(profileInfo: ProfileInfo){
        with(binding){
            tvName.text = profileInfo.name
            root.setOnClickListener{
                onItemClick(profileInfo)
            }
            glide
                .load(profileInfo.url)
                .into(ivCover)
        }
    }

}