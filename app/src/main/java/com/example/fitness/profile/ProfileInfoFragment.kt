package com.example.fitness.profile

import android.content.Context
import android.os.Bundle
import android.text.style.TtsSpan.ARG_TEXT
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitness.R
import com.example.fitness.databinding.FragmentProfileinfoBinding
import java.time.LocalDateTime

class ProfileInfoFragment : Fragment(R.layout.fragment_profileinfo) {


    private var _binding: FragmentProfileinfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileinfoBinding.bind(view)

        val weightSharedPref = activity!!.getSharedPreferences(
            getString(R.string.preference_weight),
            Context.MODE_PRIVATE
        )
        val editor = weightSharedPref.edit()

        val profilesettingsSharedPreferences = activity!!.getSharedPreferences(
            getString(R.string.preference_profilesettings),
            Context.MODE_PRIVATE
        )
        val profileeditor = profilesettingsSharedPreferences.edit()

        //Принимаю id от профиля
        val id = arguments?.getString(ARG_TEXT).orEmpty()


        if (id.isNotEmpty()) {
            // TODO: Тимуру нужно узнать как сделать перевод этого текста на англ
            binding.tvName.text =
                "Укажите свой ${ProfileInfoRepository.infoList[id.toInt()].name.lowercase()}"
        }
        with(binding) {
            iBtnBack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileInfoFragment_to_profileFragment
                )
            }
            // TODO: Сделать сохранение данных в бд (как напишут бд)
            val gender = arrayOf("Мужчина", "Женщина")
            btnSave.setOnClickListener {
                val bundle: Bundle = if (id.toInt() != 1) {
                    ProfileFragment.createBundle(numberPicker.value.toString(), id)
                } else {
                    ProfileFragment.createBundle(gender[numberPicker.value], id)
                }
                findNavController().navigate(
                    R.id.action_profileInfoFragment_to_profileFragment,
                    bundle
                )


                //Возраст
                if (id.toInt() == 0) {
                    numberPicker.minValue = 14
                    numberPicker.maxValue = 100
                    numberPicker.wrapSelectorWheel = false
                }
                //Пол
                if (id.toInt() == 1) {
                    val gender = arrayOf("Мужчина", "Женщина")
                    numberPicker.minValue = 0
                    numberPicker.maxValue = gender.size - 1
                    numberPicker.wrapSelectorWheel = false
                    numberPicker.displayedValues = gender
                }
                //Вес
                if (id.toInt() == 2) {
                    numberPicker.minValue = 20
                    numberPicker.maxValue = 250
                    numberPicker.wrapSelectorWheel = false
                }
                //Рост
                if (id.toInt() == 3) {
                    numberPicker.minValue = 50
                    numberPicker.maxValue = 250
                    numberPicker.wrapSelectorWheel = false
                }
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
