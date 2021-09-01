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
        "How Given: Shot in the deltoid muscle",
        R.drawable.sinopharm.toString()
    )

}