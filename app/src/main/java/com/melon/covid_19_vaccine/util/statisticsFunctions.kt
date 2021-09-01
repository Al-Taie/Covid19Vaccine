package com.melon.covid_19_vaccine.util

import android.view.animation.DecelerateInterpolator
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


fun initPieChart(binding: FragmentStatisticsBinding) {
//    val config = AnimatedPieViewConfig()
//    with(DataManager.getVaccinatedTop10) {
//        config.apply {
//            startAngle(-40f)
//            duration(1800)
//            drawText(true)
//            canTouch(true)
////            strokeMode(true)
////            strokeWidth(8)
//            textSize(36F)
//            textMargin(3)
//            splitAngle(1.5F)
//            interpolator(DecelerateInterpolator())
//            autoSize(false)
//            pieRadiusRatio(1F)
//            animOnTouch(true)
//            focusAlphaType(AnimatedPieViewConfig.FOCUS_WITH_ALPHA_REV)
//            focusAlpha(100)
//            floatShadowRadius(4F)
//            floatExpandSize(4F)
//
//            addData(
//                SimplePieInfo(
//                    firstCountry().totalVaccinations.toDouble(),
//                   randomColor, firstCountry().country
//                )
//            )
//
//            addData(
//                SimplePieInfo(
//                    secondCountry().totalVaccinations.toDouble(),
//                    randomColor, secondCountry().country
//                )
//            )
//
//            addData(
//                SimplePieInfo(
//                    thirdCountry().totalVaccinations.toDouble(),
//                    randomColor, thirdCountry().country
//                )
//            )
//
//            addData(
//                SimplePieInfo(
//                    fourthCountry().totalVaccinations.toDouble(),
//                    randomColor, fourthCountry().country
//                )
//            )
//
//            addData(
//                SimplePieInfo(
//                    lastCountry().totalVaccinations.toDouble(),
//                    randomColor, lastCountry().country
//                )
//            )
//
//        }
//    }
//    binding.pieChart.applyConfig(config)
//    binding.pieChart.start()
}
