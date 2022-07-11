package com.example.fitness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var button = getView()?.findViewById<Button>(R.id.button2)
        button?.setOnClickListener { view ->
            val bundle = bundleOf("Error" to this::class.toString())
            view.findNavController().navigate(R.id.action_mainFragment_to_trainingsFragment, bundle)
        }
        button = getView()?.findViewById(R.id.button3)
        button?.setOnClickListener { view ->
            val bundle = bundleOf("Error" to this::class.toString())
            view.findNavController().navigate(R.id.action_mainFragment_to_profileFragment, bundle)
        }
    }
}