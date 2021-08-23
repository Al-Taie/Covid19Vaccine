package com.melon.covid_19_vaccine.util

import android.graphics.Color
import android.text.TextUtils
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import java.util.*


fun initData() {
    DataManager.groupByCountry().forEach { (key, value) ->
        val list = mutableListOf<Vaccinated>()
        value.groupBy { it.date.month }.forEach { (_, v) -> list.add(v.last()) }
        DataManager.vaccinatedMap[key] = list
        DataManager.vaccinatedListSorted.add(list)
    }
}

fun getColor(colorStr: String): Int {
    var colorString = colorStr
    if (TextUtils.isEmpty(colorString)) return Color.BLACK
    if (!colorString.startsWith("#")) colorString = "#$colorString"
    return Color.parseColor(colorString)
}

fun randomColor() = Color.argb(255,
                        Random().nextInt(256),
                        Random().nextInt(256),
                        Random().nextInt(256))