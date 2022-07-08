package com.example.fitness

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.fitness.databinding.FragmentTrainingsBinding
import com.example.fitness.trainings.SecondActivity
import com.example.fitness.trainings.Training
import com.example.fitness.trainings.TrainingAdapter
import com.example.fitness.trainings.TrainingRepository

class TrainingsFragment : Fragment(R.layout.fragment_trainings){

    private var _binding: FragmentTrainingsBinding? = null
    private val binding get() = _binding!!

    private var adapter: TrainingAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTrainingsBinding.bind(view)
        initAdapter(view.context)
    }

    private fun initAdapter(
        context: Context
    ) {
        adapter = TrainingAdapter(
            TrainingRepository.training,
            Glide.with(this),
            context
        ) {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("id", it.id)
            }
            startActivity(intent)
        }
        binding.rvTraining.setOnClickListener {
            TrainingRepository.training.removeAt(0)
            adapter?.updateData(TrainingRepository.training)
        }
        binding.rvTraining.adapter = adapter
        binding.rvTraining.layoutManager = GridLayoutManager(requireContext(), 1)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}