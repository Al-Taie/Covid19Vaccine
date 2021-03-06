package com.melon.covid_19_vaccine.ui.statistics

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.melon.covid_19_vaccine.ui.base.BaseFragment
import com.melon.covid_19_vaccine.util.monthName
import kotlinx.coroutines.flow.collect
import com.github.mikephil.charting.utils.ColorTemplate as Colors


/**
 * A simple [Fragment] subclass.
 * Use the [StatisticsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatisticsFragment : BaseFragment<FragmentStatisticsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStatisticsBinding
        get() = FragmentStatisticsBinding::inflate

    override fun setup() {
        lifecycleScope.launchWhenStarted {
            DataManager.isDataReady.collect {
                if (it) {
                    DataManager.initVaccinatedContinents()
                    showStatsBy(ChipType.TOTAL)
                    binding.recyclerCountry.adapter =
                        StatisticsAdapter(DataManager.getVaccinatedContinents)
                }
                binding.apply {
                    barChart.visibility = if (it) View.VISIBLE else View.INVISIBLE
                    loading.isVisible = !it
                }
            }
        }
    }

    override fun callBack() {
        binding.chipGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.chip_total -> showStatsBy(ChipType.TOTAL)
                R.id.chip_fully -> showStatsBy(ChipType.FULLY)
                R.id.chip_daily -> showStatsBy(ChipType.DAILY)
                R.id.chip_vaccinated -> showStatsBy(ChipType.VACCINATED)
            }
        }
    }

    private fun showStatsBy(chipType: ChipType) {
        val entries: MutableList<BarEntry> = ArrayList()
        val stackLabels = mutableSetOf<String>()

        DataManager.getVaccinatedContinents.forEachIndexed { index, list ->
            val array = list.map {
                when (chipType) {
                    ChipType.TOTAL -> it.totalVaccinations
                    ChipType.FULLY -> it.peopleFullyVaccinated
                    ChipType.DAILY -> it.dailyVaccinations
                    ChipType.VACCINATED -> it.peopleVaccinated
                }.toFloat()
            }

            val entry = BarEntry(index.toFloat(), array.toFloatArray())
            entries.add(entry)
            stackLabels.addAll(list.map { it.date.monthName() })
        }
        configureChartAppearance()
        initTop10(entries = entries, stackLabels = stackLabels)
    }

    private fun configureChartAppearance() {
        binding.barChart.apply {
            setDrawGridBackground(false)
            setDrawBarShadow(false)
            setDrawValueAboveBar(true)
            description.isEnabled = false
            xAxis.granularity = 1f
            axisLeft.setDrawGridLines(false)
            axisRight.setDrawGridLines(false)
            setMaxVisibleValueCount(5)
            setPinchZoom(false)
            isHighlightFullBarEnabled = false
            animateY(2000)
        }
    }

    private fun initTop10(entries: MutableList<BarEntry>, stackLabels: MutableSet<String>) {
        val set1 = BarDataSet(entries, "BarDataSet")
        val colors = Colors.MATERIAL_COLORS + Colors.VORDIPLOM_COLORS + Colors.JOYFUL_COLORS
        set1.colors = colors.toList()

        set1.stackLabels = stackLabels.toTypedArray()
        set1.setDrawIcons(false)

        val dataSets: ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(set1)

        val barData = BarData(dataSets)
        barData.barWidth = 0.9f // set custom bar width
        barData.setValueTextSize(9f)
        barData.setValueTextColor(Color.WHITE)

        binding.barChart.apply {
            data = barData
            invalidate() // refresh
        }
    }

}