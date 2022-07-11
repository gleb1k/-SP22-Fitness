package com.example.fitness.profile.moreprofile

import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.fitness.databinding.ItemMoreprofileBinding


class MoreProfileInfoHolder(
    private val bd: SharedPreferences?,
    private val binding: ItemMoreprofileBinding,
    private val glide: RequestManager,
    private val onItemClick: (MoreProfileInfo) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(moreProfileInfo: MoreProfileInfo) {
        with(binding) {
            tvName2.text = moreProfileInfo.name
            tvValue2.text = bd?.getString(moreProfileInfo.id.toString(),null)
            ivIcon2.setImageResource(moreProfileInfo.icon)
            root.setOnClickListener {
                onItemClick(moreProfileInfo)
            }
            glide
                .load(moreProfileInfo.url)
                .into(ivCover2)
        }
    }
}
