package com.melon.covid_19_vaccine.data.interfaces

import com.melon.covid_19_vaccine.data.domain.Vaccinated

interface VaccinatedInteractionListener {
    fun onClickItem(vaccinated: Vaccinated)
    fun onClickName(name: String)
}