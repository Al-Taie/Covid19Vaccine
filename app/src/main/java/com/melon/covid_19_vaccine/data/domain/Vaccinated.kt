package com.melon.covid_19_vaccine.data.domain

import java.time.LocalDate

data class Vaccinated(
    val country: String = "",
    val isoCode: String = "",
    val date: LocalDate,
    val totalVaccinations: Long = 0,
    val peopleVaccinated: Long = 0,
    val peopleFullyVaccinated: Long = 0,
    val dailyVaccinations: Long = 0,
    var expanded: Boolean = false
//    val dailyVaccinationsRaw: Long = 0,
//    val totalVaccinationsPerHundred: Double = 0.0,
//    val peopleVaccinatedPerHundred: Double = 0.0,
//    val peopleFullyVaccinatedPerHundred: Double = 0.0,
//    val dailyVaccinationsPerMillion: Double = 0.0,
)