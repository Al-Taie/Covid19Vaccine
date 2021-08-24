package com.melon.covid_19_vaccine.util

import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.util.Constant.Index
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*


fun String.toDate(): LocalDate = LocalDate.parse(this)

fun String.toLong() = (this.toDoubleOrNull() ?: 0).toLong()

fun String.toDouble() = (this.toDoubleOrNull() ?: 0.0)

fun String.capitalize() = this.lowercase().replaceFirstChar { it.titlecase() }

fun LocalDate.monthName(): String = this.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)

fun List<List<Vaccinated>>.firstCountry() = this.first().last()

fun List<List<Vaccinated>>.secondCountry() = this[Index.ONE].last()

fun List<List<Vaccinated>>.thirdCountry() = this[Index.TWO].last()

fun List<List<Vaccinated>>.fourthCountry() = this[Index.THREE].last()

fun List<List<Vaccinated>>.lastCountry() = this.last().last()
