package com.melon.covid_19_vaccine.ui.search

import com.melon.covid_19_vaccine.data.DataManager


object SearchAdapter {
    fun isFounded(query: String): Boolean {
        return DataManager.checkVaccinatedMap(query)
    }
}