package com.example.fitness.trainings

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentSecondBinding
import com.example.fitness.databinding.FragmentTrainingmanBinding

class SecondFragment() : Fragment(R.layout.fragment_second){

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)

        var id = arguments?.getInt(ID)
        var training = TrainingRepository.training.get(id!!)

        with(binding){
            textView2.text = training.name
        }
//        val text = findViewById<TextView>(R.id.textView2)
//        val picture = findViewById<ImageView>(R.id.imageView)

//        text.setText(
//            "${training.name}:" +
//                    "\n ${training.text}"
//        )
//
//        Glide.with(this)
//            .load(TrainingRepository.training.get(id).picture)
//            .placeholder(R.drawable.picture1090)
//            .error(R.drawable.picture1090)
//            .into(picture)
    }
    companion object{
        private const val ID = "id"
        fun createBundle(id: Int): Bundle{
            val bundle = Bundle()
            bundle.putInt(ID, id)
            return bundle
        }
    }
}