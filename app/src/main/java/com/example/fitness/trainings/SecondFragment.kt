package com.example.fitness.trainings

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentSecondBinding
import com.example.fitness.databinding.FragmentTrainingmanBinding
import com.google.android.material.snackbar.Snackbar

class SecondFragment() : Fragment(R.layout.fragment_second){

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var adapter:WorkoutAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)

        var id = arguments?.getInt(ID)
        var training = TrainingRepository.training.get(id!!)

        with(binding){
            textView2.text = training.name
        }


        if(id.toInt()==0){
            adapter = WorkoutAdapter(WorkoutRepository.workouts_abs) {
            }
        }
        if(id.toInt()==1){
            adapter = WorkoutAdapter(WorkoutRepository.workouts_complexMan) {
            }
        }
        if(id.toInt()==2){
            adapter = WorkoutAdapter(WorkoutRepository.workouts_upperMan) {
            }
        }

        if(id.toInt() == 3){
            adapter = WorkoutAdapter(WorkoutRepository.workouts_leggsWoman){
            }
        }



        binding.rvWorkout.adapter = adapter

        with(binding){
            btBack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_secondFragment_to_trainingsFragment
                )
            }
        }
    }
    companion object{
        private const val ID = "id"
        fun createBundle(id: Int): Bundle{
            val bundle = Bundle()
            bundle.putInt(ID, id)
            return bundle
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}