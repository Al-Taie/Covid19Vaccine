package com.melon.covid_19_vaccine.data

import com.melon.covid_19_vaccine.data.domain.Vaccinated

// TODO (CREATE DATA MANAGER)
object DataManager {
    private val vaccinatedList = mutableListOf<Vaccinated>()
    val vaccinatedListSorted = mutableListOf<List<Vaccinated>>()
    val vaccinatedMap = mutableMapOf<String, List<Vaccinated>>()
    lateinit var vaccinatedTop5: List<List<Vaccinated>>
    private var vaccinatedIndex = 0


    fun initTopFive() {
        with(vaccinatedListSorted) {
            sortByDescending { it.last().totalVaccinations }
            vaccinatedTop5 =  slice(0..4)
        }
    }


    fun addVaccinated(vaccinated: Vaccinated) = vaccinatedList.add(vaccinated)

    fun groupByCountry() = vaccinatedList.groupBy { it.country }

    fun getCurrentVaccinated(): Vaccinated = vaccinatedList[vaccinatedIndex]

    fun getLastVaccinated(): Vaccinated = vaccinatedList.last()

    fun findNextVaccinated(): Vaccinated {
        return vaccinatedList[vaccinatedIndex]
    }

    fun findPreviousVaccinated(): Vaccinated {
        return vaccinatedList[vaccinatedIndex]
    }
}