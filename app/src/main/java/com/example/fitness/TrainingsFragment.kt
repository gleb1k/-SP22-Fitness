package com.example.fitness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.fitness.trainings.SampleFragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class TrainingsFragment : Fragment(R.layout.fragment_trainings){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var imageResId = intArrayOf(
            R.drawable.ic_man33, R.drawable.ic_woman3
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = SampleFragmentPagerAdapter(this)

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = ""
            tab.setIcon(imageResId[position])
        }.attach()
    }
}