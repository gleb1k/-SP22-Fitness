package com.example.fitness.trainings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentTrainingmanBinding
import com.example.fitness.databinding.FragmentTrainingsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TrainingmanFragment : Fragment(R.layout.fragment_trainingman) {
    private var _binding: FragmentTrainingmanBinding? = null
    private val binding get() = _binding!!

    private var adapter: TrainingAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTrainingmanBinding.bind(view)
        initAdapter(view.context)
    }

    private fun initAdapter(
        context: Context
    ) {
        adapter = TrainingAdapter(
            TrainingRepository.training,
            context
        ) {
            findNavController().navigate(
                R.id.action_trainingsFragment_to_secondFragment,
                SecondFragment.createBundle(it.id)
            )
        }

        binding.rvTrainingman.setOnClickListener {
            TrainingRepository.training.removeAt(0)
            adapter?.updateData(TrainingRepository.training)
        }
        binding.rvTrainingman.adapter = adapter
        binding.rvTrainingman.layoutManager = GridLayoutManager(requireContext(), 1)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}