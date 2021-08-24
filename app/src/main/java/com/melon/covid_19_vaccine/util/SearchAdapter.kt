package com.melon.covid_19_vaccine.util

import android.view.View
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentSearchBinding

object SearchAdapter {
    fun isFounded(query: String): Boolean {
        return DataManager.vaccinatedMap.containsKey(query)
    }

    fun initData(query: String, binding: FragmentSearchBinding) {
        val data = DataManager.vaccinatedMap[query]
        initPieChart(binding = binding, data = data!!)
        binding.pieChart.visibility = View.VISIBLE
    }
}