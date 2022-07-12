package com.example.fitness.profile.moreprofile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitness.LocalDateTimeDeserializer
import com.example.fitness.R
import com.example.fitness.WeightDate
import com.example.fitness.databinding.FragmentProfileinfoBinding
import com.example.fitness.profile.ProfileFragment
import com.example.fitness.profile.ProfileInfoRepository
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MoreProfileInfoFragment:Fragment(R.layout.fragment_moreprofileinfo) {
    private var _binding: FragmentProfileinfoBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileinfoBinding.bind(view)

        //Файл хранения информации о пользователе
        val profileSettingsSharedPreferences = activity?.getSharedPreferences(
            getString(R.string.preference_profilemoresettings),
            Context.MODE_PRIVATE
        )
        val profileEditor = profileSettingsSharedPreferences?.edit()

        //Принимаю id от профиля
        val id = arguments?.getString(ARG_TEXT).orEmpty()


        if (id.isNotEmpty()) {
            binding.tvName.text =
                "${resources.getString(R.string.text3)} ${MoreProfileInfoRepository.infoList[id.toInt()].name.lowercase()}"
        }
        with(binding) {
            iBtnBack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_moreProfileInfoFragment_to_moreProfileFragment
                )
            }

            btnSave.setOnClickListener {

                if (id.toInt() == 0) {
                    profileEditor?.putString(id, "${numberPicker.value}")
                    profileEditor?.apply()
                }

                if (id.toInt() == 1) {
                    profileEditor?.putString(id, "${numberPicker.value}")
                    profileEditor?.apply()
                }


                if (id.toInt() == 2) {
                    profileEditor?.putString(id, "${numberPicker.value}")
                    profileEditor?.apply()
                }
                val bundle: Bundle =
                    ProfileFragment.createBundle(numberPicker.value.toString(), id)
                findNavController().navigate(
                    R.id.action_moreProfileInfoFragment_to_moreProfileFragment,
                    bundle
                )

            }
            //Сколько сигарет в день вы выкуриваете?
            if (id.toInt() == 0) {
                numberPicker.minValue = 0
                numberPicker.maxValue = 100
                numberPicker.wrapSelectorWheel = false
            }
            //Сколько литров алкоголя в месяц вы употребляете вы употребляете?
            if (id.toInt() == 1) {
                numberPicker.minValue = 0
                numberPicker.maxValue = 100
                numberPicker.wrapSelectorWheel = false
            }
            //Сколько стаканов воды в день вы употребляете?
            if (id.toInt() == 2) {
                numberPicker.minValue = 1
                numberPicker.maxValue = 37
                numberPicker.wrapSelectorWheel = false
            }

        }
    }

    class LocalDateTimeSerializer : JsonSerializer<LocalDateTime> {
        override fun serialize(
            src: LocalDateTime?,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive(src?.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
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