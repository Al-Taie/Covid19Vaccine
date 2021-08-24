package com.melon.covid_19_vaccine.util

import android.view.View
import android.view.animation.DecelerateInterpolator
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


fun initPieChart(view: View, data: List<Vaccinated>?) {

    val config = AnimatedPieViewConfig()
    config.apply {
        startAngle(-90f)
        duration(1800)
        drawText(true)
        canTouch(true)
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

        data?.forEach {
            addData(
                SimplePieInfo(
                    it.dailyVaccinations.toDouble(),
                    randomColor, it.date.monthName()
                )
            )
        }
    }

    (view as AnimatedPieView).apply {
        applyConfig(config)
        start()
    }
}
