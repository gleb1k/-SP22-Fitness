package com.example.fitness.profile.moreprofile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.fitness.R
import com.example.fitness.databinding.FragmentMoreprofileBinding

class MoreProfileFragment:Fragment(R.layout.fragment_moreprofile) {
    private var _binding: FragmentMoreprofileBinding? = null
    private val binding get() = _binding!!

    private var adapter: MoreProfileInfoAdapter? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMoreprofileBinding.bind(view)

        //Файл хранения информации о пользователе по датам(кол-во воды, индекст массы тела)
        val profileSettingsSharedPreferences2 = activity?.getSharedPreferences(getString(R.string.preference_profilemoresettings),
            Context.MODE_PRIVATE)

        //Принимаю значение от инфыпрофиля и айди тоже надо бы
        val valueId = arguments?.getString(ARG_TEXT).orEmpty()


        if (valueId.isNotEmpty()) {
            val arr = valueId.split(" ")
            val value = arr[0]
            val id = arr[1]
            MoreProfileInfoRepository.infoList[id.toInt()].value = value
        }

        //recycler
        adapter = MoreProfileInfoAdapter(
            profileSettingsSharedPreferences2,
            MoreProfileInfoRepository.infoList,
            Glide.with(this),
        )
        {
            findNavController().navigate(
                R.id.action_moreProfileFragment_to_moreProfileInfoFragment,
                MoreProfileInfoFragment.createBundle(it.id.toString())
            )
        }


        binding.rvProfile2.adapter=adapter
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