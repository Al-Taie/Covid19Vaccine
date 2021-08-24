package com.melon.covid_19_vaccine.util

import com.melon.covid_19_vaccine.data.domain.Vaccinated
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*


fun String.toDate(): LocalDate {
    return LocalDate.parse(this)
}

fun String.toLong(): Long {
    return (this.toDoubleOrNull() ?: 0).toLong()
}

fun String.toDouble(): Double {
    return (this.toDoubleOrNull() ?: 0.0)
}

fun LocalDate.monthName(): String {
    return this.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
}

fun List<List<Vaccinated>>.firstCountry(): Vaccinated {
    return this.first().last()
}

fun List<List<Vaccinated>>.secondCountry(): Vaccinated {
    return this[Constant.Index.ONE].last()
}

fun List<List<Vaccinated>>.thirdCountry(): Vaccinated {
    return this[Constant.Index.TWO].last()
}

fun List<List<Vaccinated>>.fourthCountry(): Vaccinated {
    return this[Constant.Index.THREE].last()
}

fun List<List<Vaccinated>>.lastCountry(): Vaccinated {
    return this.last().last()
}