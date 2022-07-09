package com.example.fitness.trainings

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class SampleFragmentPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TrainingmanFragment()
            else -> TrainingwomanFragment()
        }
    }
}