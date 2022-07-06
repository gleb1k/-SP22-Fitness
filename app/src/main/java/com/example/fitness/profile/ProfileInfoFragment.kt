package com.example.fitness.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitness.R
import com.example.fitness.databinding.FragmentProfileBinding
import com.example.fitness.databinding.FragmentProfileinfoBinding

class ProfileInfoFragment : Fragment(R.layout.fragment_profileinfo) {
    private var _binding :  FragmentProfileinfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileinfoBinding.bind(view)

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}