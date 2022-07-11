package com.example.fitness.profile

import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemProfileBinding

class ProfileInfoHolder(
    private val bd: SharedPreferences?,
    private val binding: ItemProfileBinding,
    private val glide: RequestManager,
    private val onItemClick: (ProfileInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(profileInfo: ProfileInfo) {
        with(binding) {
            tvName.text = profileInfo.name
            tvValue.text = bd?.getString(profileInfo.id.toString(),null)
            ivIcon.setImageResource(profileInfo.icon)
            root.setOnClickListener {
                onItemClick(profileInfo)
            }
            glide
                .load(profileInfo.url)
                .into(ivCover)
        }
    }
}
