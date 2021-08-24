package com.melon.covid_19_vaccine.util

import android.graphics.Color
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import java.util.Random


fun initData() {
    DataManager.groupByCountry().forEach { (key, value) ->
        val list = mutableListOf<Vaccinated>()
        value.groupBy { it.date.month }.forEach { (_, v) -> list.add(v.last()) }
        DataManager.vaccinatedMap[key] = list
        DataManager.vaccinatedListSorted.add(list)
    }
}

/** GET RANDOM COLOR **/
val randomColor
    get() = Color.argb(
        255, Random().nextInt(256),
        Random().nextInt(256), Random().nextInt(256)
    )