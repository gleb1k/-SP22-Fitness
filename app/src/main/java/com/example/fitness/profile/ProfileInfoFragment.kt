package com.example.fitness.profile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fitness.LocalDateTimeDeserializer
import com.example.fitness.R
import com.example.fitness.WeightDate
import com.example.fitness.databinding.FragmentProfileinfoBinding
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList

class ProfileInfoFragment : Fragment(R.layout.fragment_profileinfo) {

    private var _binding: FragmentProfileinfoBinding? = null
    private val binding get() = _binding!!
    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeSerializer())
        .registerTypeAdapter(LocalDateTime::class.java,LocalDateTimeDeserializer())
        .create()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileinfoBinding.bind(view)

        //Файл для хранения данных об изменении веса пользователя по датам
        val weightSharedPref = activity!!.getSharedPreferences(
            getString(R.string.preference_weight),
            Context.MODE_PRIVATE
        )
        val editor = weightSharedPref?.edit()


        //Файл хранения информации о пользователе(рост, возраст, пол)
        val profileSettingsSharedPreferences = activity?.getSharedPreferences(
            getString(R.string.preference_profilesettings),
            Context.MODE_PRIVATE
        )
        val profileEditor = profileSettingsSharedPreferences?.edit()

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
            val gender = arrayOf("Мужчина", "Женщина")
            btnSave.setOnClickListener {
                if (id.toInt() != 2) {
                    profileEditor?.putString(id, "${numberPicker.value}")
                    profileEditor?.apply()
                }
                //Только попробуйте это потрогать я вас лично
                if (id.toInt() == 2) {
                    var arr: ArrayList<WeightDate> = ArrayList<WeightDate>()
                    val json = weightSharedPref?.getString("WeightDate", null)
                    if (json != null) {
                        val myobj = object : TypeToken<ArrayList<WeightDate>>() {}.type
                        arr = gson.fromJson<ArrayList<WeightDate>>(json, myobj)
                    }
                    val obj = WeightDate(LocalDateTime.now(), numberPicker.value)
                    arr.add(obj)
                    val str: String = gson.toJson(arr)
                    editor?.putString("WeightDate", str)
                    editor?.apply()
                }
                val bundle: Bundle = if (id.toInt() != 1) {
                    ProfileFragment.createBundle(numberPicker.value.toString(), id)
                } else {
                    ProfileFragment.createBundle(gender[numberPicker.value], id)
                }
                findNavController().navigate(
                    R.id.action_profileInfoFragment_to_profileFragment,
                    bundle
                )

            }
            //Возраст
            if (id.toInt() == 0) {
                numberPicker.minValue = 14
                numberPicker.maxValue = 100
                numberPicker.wrapSelectorWheel = false
            }
            //Пол
            if (id.toInt() == 1) {
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
            if (id.isNotEmpty()) {
                binding.tvName.text =
                    "${resources.getString(R.string.text1)} ${ProfileInfoRepository.infoList[id.toInt()].name.lowercase()}"
            }
            with(binding) {
                iBtnBack.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_profileInfoFragment_to_profileFragment
                    )
                }
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
                }
                //Возраст
                if (id.toInt() == 0) {
                    numberPicker.minValue = 14
                    numberPicker.maxValue = 100
                    numberPicker.wrapSelectorWheel = false
                }
                //Пол
                if (id.toInt() == 1) {
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
