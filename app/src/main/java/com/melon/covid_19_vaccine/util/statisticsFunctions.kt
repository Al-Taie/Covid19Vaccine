package com.melon.covid_19_vaccine.util

import android.view.animation.DecelerateInterpolator
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


fun initPieChart(binding: FragmentStatisticsBinding) {

    val config = AnimatedPieViewConfig()
    with(DataManager.vaccinatedTop5) {
        config.apply {
            startAngle(-40f)
            duration(1800)
            drawText(true)
            canTouch(true)
//            strokeMode(true)
//            strokeWidth(8)
            textSize(36F)
            textMargin(3)
            splitAngle(1.5F)
            interpolator(DecelerateInterpolator())
            autoSize(false)
            pieRadiusRatio(1F)
            animOnTouch(true)
            focusAlphaType(AnimatedPieViewConfig.FOCUS_WITH_ALPHA_REV)
            focusAlpha(100)
            floatShadowRadius(4F)
            floatExpandSize(4F)

            addData(
                SimplePieInfo(
                    firstCountry().totalVaccinations.toDouble(),
                    getColor("FF446767"), firstCountry().country
                )
            )

            addData(
                SimplePieInfo(
                    secondCountry().totalVaccinations.toDouble(),
                    getColor("FFFFD28C"), secondCountry().country
                )
            )

            addData(
                SimplePieInfo(
                    thirdCountry().totalVaccinations.toDouble(),
                    getColor("FF2BBC80"), thirdCountry().country
                )
            )

            addData(
                SimplePieInfo(
                    fourthCountry().totalVaccinations.toDouble(),
                    getColor("FF8BE8FF"), fourthCountry().country
                )
            )

            addData(
                SimplePieInfo(
                    lastCountry().totalVaccinations.toDouble(),
                    getColor("FFFA734D"), lastCountry().country
                )
            )

        }
    }
    binding.pieChart.applyConfig(config)
    binding.pieChart.start()
}


fun initTopFiveBinding(binding: FragmentStatisticsBinding) {
    DataManager.vaccinatedListSorted.sortByDescending { it.last().totalVaccinations }
    with(DataManager.vaccinatedTop5) {
        binding.apply {
            countryNameOne.text = firstCountry().country
            countryNameTwo.text = secondCountry().country
            countryNameThird.text = thirdCountry().country
            countryNameFourth.text = fourthCountry().country
            countryNameFifth.text = lastCountry().country

            totalCasesOne.text = firstCountry().totalVaccinations.toString()
            totalCasesTwo.text = secondCountry().totalVaccinations.toString()
            totalCasesThird.text = thirdCountry().totalVaccinations.toString()
            totalCasesFourth.text = fourthCountry().totalVaccinations.toString()
            totalCasesFifth.text = lastCountry().totalVaccinations.toString()
        }
    }
}
