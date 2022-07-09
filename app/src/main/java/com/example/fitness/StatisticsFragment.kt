package com.example.fitness

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitness.databinding.FragmentStatisticsBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.util.*


class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStatisticsBinding.bind(view)

        val entries = ArrayList<Entry>()

        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))

        val vl = LineDataSet(entries, "My Type")

        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = R.color.gray
        vl.fillAlpha = R.color.red

        //привязка информации к графику
        binding.lineChart.data = LineData(vl)
        //настройка отображения графика
        with(binding) {
            //угол поворота по ОХ
            lineChart.xAxis.labelRotationAngle = 0f
            //удаление правой оси
            lineChart.axisRight.isEnabled = false
            lineChart.xAxis.axisMaximum =0.1f
            //Позволяет зумить график
            lineChart.setTouchEnabled(true)
            lineChart.setPinchZoom(true)
            //Легенда графика и надпись при ошибке выборки данных
            lineChart.description.text = "Days"
            lineChart.setNoDataText("No forex yet!")
            //анимация добавления данных
            lineChart.animateX(1800, Easing.EaseInExpo)
        }
    }

}