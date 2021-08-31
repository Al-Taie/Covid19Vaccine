package com.melon.covid_19_vaccine.data

import com.melon.covid_19_vaccine.data.domain.Vaccinated


object DataManager {
    private val vaccinatedList = mutableListOf<Vaccinated>()
    private val vaccinatedListSorted = mutableListOf<List<Vaccinated>>()
    private val vaccinatedMap = mutableMapOf<String, List<Vaccinated>>()
    private lateinit var vaccinatedTop10: List<List<Vaccinated>>

    val vaccineMap : MutableMap<String,List<Vaccinated>>
        get() = vaccinatedMap

    val vaccineList : MutableList<List<Vaccinated>>
        get() = vaccinatedListSorted

    val getVaccinatedTop10 : List<List<Vaccinated>>
        get() = vaccinatedTop10

    fun initTop10() {
        with(vaccinatedListSorted) {
            sortByDescending { it.last().totalVaccinations }
            vaccinatedTop10 = slice(0..9)
        }
    }

    /**
     * this function is to check if a certain key is exist in the vaccinatedMap
     * @param query the key that you want to check if it's exist
     * @return true if the key exist in the map
     * @author Karrar Mohammed
     */
    fun checkVaccinatedMap(query: String) = vaccinatedMap.containsKey(query)

    /**
     * add list to the vaccinatedListSorted
     * @param list list of Vaccinated objects
     * @author Karrar Mohammed
     */
    fun addToVaccinatedListSorted(list : List<Vaccinated>) = vaccinatedListSorted.add(list)
    /**
     * add key and value of type list
     * @param list list of Vaccinated objects
     * @param key key represent the country name
     * @author Karrar Mohammed
     */
    fun addToVaccinatedMap(key: String, list: List<Vaccinated>) { vaccinatedMap[key] = list }

    fun addVaccinated(vaccinated: Vaccinated) = vaccinatedList.add(vaccinated)

    fun groupByCountry() = vaccinatedList.groupBy { it.country }
}