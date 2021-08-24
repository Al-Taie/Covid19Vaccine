package com.melon.covid_19_vaccine.util

import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


object CsvParser {
    fun parseFileData(inputStream: InputStream) {
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine { DataManager.addVaccinated(parse(it)) }
    }

    private fun parse(line: String): Vaccinated {
        val tokens = line.split(",")
        return Vaccinated(
            country = tokens[Constant.ColumnIndex.COUNTRY],
            isoCode = tokens[Constant.ColumnIndex.ISO_CODE],
            date = tokens[Constant.ColumnIndex.DATE].toDate(),
            totalVaccinations = tokens[Constant.ColumnIndex.TOTAL_VACCINATIONS].toLong(),
            peopleVaccinated = tokens[Constant.ColumnIndex.PEOPLE_VACCINATED].toLong(),
            peopleFullyVaccinated = tokens[Constant.ColumnIndex.PEOPLE_FULLY_VACCINATED].toLong(),
            dailyVaccinationsRaw = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS_RAW].toLong(),
            dailyVaccinations = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS].toLong(),
            totalVaccinationsPerHundred = tokens[Constant.ColumnIndex.TOTAL_VACCINATIONS_PER_HUNDRED].toDouble(),
            peopleVaccinatedPerHundred = tokens[Constant.ColumnIndex.PEOPLE_VACCINATED_PER_HUNDRED].toDouble(),
            peopleFullyVaccinatedPerHundred = tokens[Constant.ColumnIndex.PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDouble(),
            dailyVaccinationsPerMillion = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS_PER_MILLION].toDouble()
        )
    }
}