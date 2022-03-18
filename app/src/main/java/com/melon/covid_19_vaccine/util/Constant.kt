package com.melon.covid_19_vaccine.util

import android.graphics.Color


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

    object VaccineDetailsIndex {
        const val VACCINE_NAME = 0
        const val DOSE_TAKEN = 1
        const val EFFECTIVENESS = 2
        const val NAME = 3
        const val MANUFACTURER = 4
        const val TYPE_OF_VACCINE = 5
        const val NUMBER_OF_SHOT = 6
        const val BOOST_SHOT = 7
        const val HOW_GIVEN = 8
        const val IMAGE_SRC = 9
    }

    object Colors {
        val RED = Color.rgb(228, 108, 98)
        val BLUE = Color.rgb(76, 108, 181)
    }
}