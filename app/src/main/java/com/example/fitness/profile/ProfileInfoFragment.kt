package com.example.fitness.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentProfileBinding
import com.example.fitness.databinding.FragmentProfileinfoBinding

class ProfileInfoFragment : Fragment(R.layout.fragment_profileinfo) {
    private var _binding :  FragmentProfileinfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileinfoBinding.bind(view)

        //Принимаю id от профиля
        val id = arguments?.getString(ARG_TEXT).orEmpty()

        if (id.isNotEmpty()){
            // TODO: Тимуру нужно узнать как сделать перевод этого текста на англ
            binding.tvName.text = "Укажите свой ${ProfileInfoRepository.infoList[id.toInt()].name.lowercase()}"

        }
        with(binding){
            iBtnBack.setOnClickListener{
                findNavController().navigate(
                    R.id.action_profileInfoFragment_to_profileFragment
                )
            }
            // TODO: Сделать сохранение данных в бд (как напишут бд)
            btnSave.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileInfoFragment_to_profileFragment
                )
            }
        }

    }

    companion object {

        private const val ARG_TEXT = "id"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}