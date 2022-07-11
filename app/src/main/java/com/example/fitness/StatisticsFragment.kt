package com.example.fitness

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitness.databinding.FragmentStatisticsBinding
import com.example.fitness.profile.ProfileInfoFragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.gson.*
import com.google.gson.internal.bind.util.ISO8601Utils.format
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*
import kotlin.collections.ArrayList


class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStatisticsBinding.bind(view)

        val weightSharedPref =
            activity!!.getSharedPreferences(
                getString(R.string.preference_weight),
                Context.MODE_PRIVATE
            )
        val entries = ArrayList<Entry>()
        val gson = GsonBuilder()
            .registerTypeAdapter(
                LocalDateTime::class.java,
                ProfileInfoFragment.LocalDateTimeSerializer(),
            ).registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer())
            .create()

        val json = weightSharedPref?.getString("WeightDate", null)
        var arr: ArrayList<WeightDate> = ArrayList<WeightDate>()

        if (json != null) {
            val myobj = object : TypeToken<ArrayList<WeightDate>>() {}.type
            arr = gson.fromJson<ArrayList<WeightDate>>(json, myobj)
        }

        for (i in 0 until arr.size) {
            entries.add(Entry(
                arr[i].Date.toEpochSecond(ZoneOffset.UTC).toFloat(),
                arr[i].Weight.toFloat())
            )
        }
        val vl = LineDataSet(entries,"Ваш вес")

        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = R.color.black
        vl.fillAlpha = R.color.red

        //привязка информации к графику
        binding.lineChart.data = LineData(vl)
        //настройка отображения графика
        with(binding) {
            //угол поворота по ОХ
            lineChart.xAxis.labelRotationAngle = 0f
            //удаление правой оси
            lineChart.axisRight.isEnabled = false
            lineChart.xAxis.isEnabled = false
            //Позволяет зумить график
            lineChart.setTouchEnabled(false)
            lineChart.setPinchZoom(false)
            //Легенда графика и надпись при ошибке выборки данных
            lineChart.description.isEnabled = false
            lineChart.setNoDataText("No forex yet!")
        }
    }
}




class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDateTime {
        val time = json?.asJsonPrimitive?.asString
            ?: throw IllegalArgumentException("Неверный формат даты")
        return LocalDateTime.parse(time)
    }
}