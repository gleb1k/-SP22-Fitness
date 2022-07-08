package com.example.fitness.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var adapter: ProfileInfoAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        //Принимаю значение от инфыпрофиля и айди тоже надо бы
        val valueId = arguments?.getString(ARG_TEXT).orEmpty()


        if (valueId.isNotEmpty()) {
            val arr = valueId.split(" ")
            val value = arr[0]
            val id = arr[1]
            ProfileInfoRepository.infoList[id.toInt()].value = value
        }

        adapter = ProfileInfoAdapter(
            ProfileInfoRepository.infoList,
            Glide.with(this)
        )
        {
            findNavController().navigate(
                R.id.action_profileFragment_to_profileInfoFragment,
                ProfileInfoFragment.createBundle(it.id.toString())
            )
        }


        binding.rvProfile.adapter = adapter
    }

    companion object {
        private const val ARG_TEXT = "value"

        fun createBundle(value: String, id: String): Bundle {
            val bundle = Bundle()
            val valueId = "$value $id"
            bundle.putString(
                ARG_TEXT,
                valueId
            )
            return bundle
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}