package com.melon.covid_19_vaccine.util

object Constant {
    const val DATA_FILE: String = "country_vaccinations.csv"

    object ColumnIndex {
        const val COUNTRY = 0
        const val ISO_CODE = Index.ONE
        const val DATE = Index.TWO
        const val TOTAL_VACCINATIONS = Index.THREE
        const val PEOPLE_VACCINATED = 4
        const val PEOPLE_FULLY_VACCINATED = 5
        const val DAILY_VACCINATIONS_RAW = 6
        const val DAILY_VACCINATIONS = 7
        const val TOTAL_VACCINATIONS_PER_HUNDRED = 8
        const val PEOPLE_VACCINATED_PER_HUNDRED = 9
        const val PEOPLE_FULLY_VACCINATED_PER_HUNDRED = 10
        const val DAILY_VACCINATIONS_PER_MILLION = 11

    }

    object Index {
        const val ONE = 1
        const val TWO = 2
        const val THREE = 3
    }

    object VaccineName {
        const val PFIZER = "Pfizer Vaccine"
        const val ASTRAZENECA = "Astrazeneca Vaccine"
        const val MODERNA = "Moderna Vaccine"
        const val JOHNSEN_AND_JOHNSEN = "Johnsen & Johnsen Vaccine"
        const val SINOPHARM = "Sinopharm Vaccine"
        const val SINOVAC = "Sinovac Vaccine"
        const val SPUTNIK_V = "Sputnik-V Vaccine"
        const val NOVAVAX = "Novavax Vaccine"
    }
}