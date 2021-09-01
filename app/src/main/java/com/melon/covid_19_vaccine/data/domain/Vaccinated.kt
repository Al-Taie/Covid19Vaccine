package com.melon.covid_19_vaccine.data.domain

import java.time.LocalDate

data class Vaccinated(
    val country: String,
    val isoCode: String,
    val date: LocalDate,
    val totalVaccinations: Long,
    val peopleVaccinated: Long,
    val peopleFullyVaccinated: Long,
    val dailyVaccinationsRaw: Long,
    val dailyVaccinations: Long,
    val totalVaccinationsPerHundred: Double,
    val peopleVaccinatedPerHundred: Double,
    val peopleFullyVaccinatedPerHundred: Double,
    val dailyVaccinationsPerMillion: Double,
    var expanded: Boolean = false
)