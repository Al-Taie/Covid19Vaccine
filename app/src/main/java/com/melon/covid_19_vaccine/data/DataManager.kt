package com.melon.covid_19_vaccine.data

import com.melon.covid_19_vaccine.data.domain.Vaccinated
import kotlinx.coroutines.flow.MutableStateFlow


object DataManager {
    private val vaccinatedList = mutableListOf<Vaccinated>()
    private val vaccinatedMap = mutableMapOf<String, List<Vaccinated>>()
    private lateinit var vaccinatedContinents: List<List<Vaccinated>>

    val isDataReady = MutableStateFlow(false)
    val getVaccinatedMap: Map<String, List<Vaccinated>> get() = vaccinatedMap
    val vaccineListSorted get() = vaccinatedMap.values.toList()
    val getVaccinatedContinents get() = vaccinatedContinents

    fun initVaccinatedContinents() {
        vaccinatedContinents = vaccinatedMap.values.filter {
            it.last().isoCode.startsWith("OWID")
        }.sortedByDescending { it.last().totalVaccinations }
    }

    /**
     * this function is to check if a certain key is exist in the vaccinatedMap
     * @param query the key that you want to check if it's exist
     * @return true if the key exist in the map
     * @author Karrar Mohammed
     */
    fun checkVaccinatedMap(query: String) = vaccinatedMap.containsKey(query)

    /**
     * add key and value of type list
     * @param list list of Vaccinated objects
     * @param key key represent the country name
     * @author Karrar Mohammed
     */
    fun addToVaccinatedMap(key: String, list: List<Vaccinated>) {
        vaccinatedMap[key] = list
    }

    fun addVaccinated(vaccinated: Vaccinated) = vaccinatedList.add(vaccinated)

    fun groupByCountry() = vaccinatedList.groupBy { it.country }
}