package com.melon.covid_19_vaccine.ui.search

import android.view.View
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.util.initPieChart

object SearchAdapter {
    fun isFounded(query: String): Boolean {
        return DataManager.checkVaccinatedMap(query)
    }

    fun initData(query: String, view: View) {
        val data = DataManager.vaccineMap[query]
        initPieChart(view = view, data = data)
    }
}