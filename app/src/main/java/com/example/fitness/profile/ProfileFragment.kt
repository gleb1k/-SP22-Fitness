package com.example.fitness.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitness.R
import com.example.fitness.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding :  FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var adapter : ProfileInfoAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)


        adapter = ProfileInfoAdapter(
            ProfileInfoRepository.infoList,{}
        )

        binding.rvProfile.adapter = adapter
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}