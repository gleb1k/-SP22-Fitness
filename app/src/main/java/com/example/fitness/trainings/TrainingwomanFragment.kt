package com.example.fitness.trainings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentTrainingmanBinding
import com.example.fitness.databinding.FragmentTrainingsBinding
import com.example.fitness.databinding.FragmentTrainingwomanBinding

class TrainingwomanFragment : Fragment(R.layout.fragment_trainingwoman) {
    private var _binding: FragmentTrainingwomanBinding? = null
    private val binding get() = _binding!!

    private var adapter: TrainingAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTrainingwomanBinding.bind(view)
        initAdapter(view.context)
    }

    private fun initAdapter(
        context: Context
    ) {
        adapter = TrainingAdapter(
            TrainingRepository.training2,
            context
        ) {
            findNavController().navigate(
                R.id.action_trainingsFragment_to_secondFragment,
                SecondFragment.createBundle(it.id)
            )
        }

        binding.rvTrainingwoman.setOnClickListener {
            TrainingRepository.training2.removeAt(0)
            adapter?.updateData(TrainingRepository.training2)
        }
        binding.rvTrainingwoman.adapter = adapter
        binding.rvTrainingwoman.layoutManager = GridLayoutManager(requireContext(), 1)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}