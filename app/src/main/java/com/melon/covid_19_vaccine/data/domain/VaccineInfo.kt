package com.melon.covid_19_vaccine.data.domain

import com.melon.covid_19_vaccine.R

object VaccineInfo {
    const val VACCINE_DETAILS = "Vaccine Details"

    val PFIZER = listOf(
        "Pfizer Vaccine",
        "2",
        "95%",
        "Name: BNT162b2",
        "Manufacturer: Pfizer, Inc., and BioNTech",
        "Type of Vaccine: mRNA",
        "Number of Shots: 2 shots, 21 days apart",
        "Booster Shot: Everyone ages 12 years and older is recommended  to get a booster shot at least 5 months after completing their Pfizer-BioNTech primary series. Teens 12-17 years old can only get a Pfizer-BioNTech COVID-19 vaccine booster. For adults 18 years and older, a booster dose of either Pfizer-BioNTech or Moderna (mRNA COVID-19 vaccines) is preferred in most situations.",
        "How Given: Shot in the muscle of the upper arm",
        R.drawable.pfizer.toString()
    )

    val ASTRAZENECA = listOf(
        "Astrazeneca Vaccine",
        "2",
        "76%",
        "Name: AZD1222",
        "Manufacturer: AstraZeneca, University of Oxford",
        "Type of Vaccine: Non-reproducible viral vector",
        "Number of Shots: 2 shots, with an interval of 4 to 12 weeks between doses.",
        "Booster Shot: No info.",
        "How Given: Shot in the muscle of the upper arm.",
        R.drawable.astrazeneca.toString()
    )

    val MODERNA = listOf(
        "Moderna Vaccine",
        "2",
        "94.1%",
        "Name: mRNA-1273",
        "Manufacturer: ModernaTX, Inc.",
        "Type of Vaccine: mRNA",
        "Number of Shots: 2 shots, 28 days apart",
        "Booster Shot: People ages 18 years and older who received a Moderna primary series should get a booster shot at least 5 months after completing their primary series. CDC recommends getting a booster dose of either Pfizer-BioNTech or Moderna (mRNA COVID-19 vaccines) in most situations.",
        "How Given: Shot in the muscle of the upper arm",
        R.drawable.moderna.toString()
    )

    val JOHNSEN_AND_JOHNSEN = listOf(
        "Johnsen & Johnsen Vaccine",
        "1",
        "66.3%",
        "Name: JNJ-78436735",
        "Manufacturer: Janssen Pharmaceuticals Companies of Johnson & Johnson",
        "Type of Vaccine: Viral Vector",
        "Number of Shots: 1 shot",
        "Booster Shot: Everyone ages 18 years and older should get a booster dose of either Pfizer-BioNTech or Moderna (mRNA COVID-19 vaccines) at least 2 months after receiving the Johnson & Johnson’s Janssen (J&J/Janssen) vaccine in most situations.",
        "How Given: Shot in the muscle of the upper arm.",
        R.drawable.j_and_j.toString()
    )

    val SINOPHARM = listOf(
        "Sinopharm Vaccine",
        "2",
        "90%",
        "Name: BBIBP-CorV",
        "Manufacturer: Beijing Institute of Biological Products.",
        "Type of Vaccine: Not activated",
        "Number of Shots: 2 shots, 3 to 4 weeks apart",
        "Booster Shot: No info.",
        "How Given: Shot in the deltoid muscle",
        R.drawable.sinopharm.toString()
    )

}