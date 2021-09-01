package com.melon.covid_19_vaccine.ui.statistics

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.databinding.ItemStatisticsBinding
import com.melon.covid_19_vaccine.util.getVaccinated


class StatisticsAdapter(private val list: List<List<Vaccinated>>) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val item = R.layout.item_statistics
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return StatisticsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        with(list.getVaccinated(position = position)) {
            holder.binding.apply {
                countryName.text = country
                totalCases.text = totalVaccinations.toString()
            }
        }

        val chart = holder.binding.cubicChart
        chart.apply {
            setViewPortOffsets(0F, 0F, 0F, 0F)
            val transparent = context.getColor(android.R.color.transparent)
            setBackgroundColor(transparent)
            description.isEnabled = false
            setTouchEnabled(true)
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(false)
            setDrawGridBackground(false)
            maxHighlightDistance = 300F
            xAxis.isEnabled = false

            axisLeft.apply {
                setLabelCount(9, false)
                textColor = transparent // Color.WHITE
                setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)
                setDrawGridLines(false)
                axisLineColor = Color.WHITE
            }

            axisRight.isEnabled = false
            legend.isEnabled = false
            animateY(2000)
            invalidate()

        }
        initCubicData(chart = chart, position = position)
    }

    private fun initCubicData(chart: LineChart, position: Int) {
        val entries = ArrayList<Entry>()

        list[position].forEachIndexed { index, it ->
            val entry = Entry(index.toFloat(), it.totalVaccinations.toFloat())
            entries.add(entry)
        }

        initCubicChart(chart = chart, entries = entries)
    }

    private fun initCubicChart(chart: LineChart, entries: ArrayList<Entry>) {
        val set1 = LineDataSet(entries, "")
        set1.mode = LineDataSet.Mode.CUBIC_BEZIER
        set1.cubicIntensity = 0.2f
        set1.setDrawFilled(true)
        set1.setDrawCircles(false)
        set1.lineWidth = 1.8f
        set1.circleRadius = 4f
        set1.setCircleColor(Color.WHITE)
        set1.highLightColor = Color.rgb(244, 117, 117)
        set1.color = Color.WHITE
        set1.fillColor = Color.WHITE
        set1.fillAlpha = 100
        set1.setDrawHorizontalHighlightIndicator(false)
        set1.setDrawVerticalHighlightIndicator(false)
        set1.setFillFormatter { _, _ -> chart.axisLeft.axisMinimum }

        val data = LineData(set1)
        data.setValueTextSize(9f)
        data.setDrawValues(false)
        chart.data = data
    }

    override fun getItemCount() = list.size

    class StatisticsViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemStatisticsBinding.bind(viewItem)
    }
}