package com.melon.covid_19_vaccine.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.data.interfaces.VaccinatedInteractionListener
import com.melon.covid_19_vaccine.databinding.ItemVaccinatedBinding
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


class VaccinatedAdapter(
    private val list: List<List<Vaccinated>>,
    private val listener: VaccinatedInteractionListener
) : RecyclerView.Adapter<VaccinatedAdapter.VaccinatedViewHolder>() {

    class VaccinatedViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemVaccinatedBinding.bind(viewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccinatedViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_vaccinated, parent, false)
        return VaccinatedViewHolder(view)
    }

    override fun onBindViewHolder(holder: VaccinatedViewHolder, position: Int) {
        val chart = holder.binding.searchCardPieChart
        initPieChart(chart = chart, position = position)
        holder.binding.expandableLayout.visibility = View.GONE
        with(list.getVaccinatedFully(position = position)) {
            holder.binding.apply {
                imageCountryFlag.setImageResource(R.drawable.circle)
                textCountryName.text = country
                textTotalVaccination.text = totalVaccinations.toString()
                textFirstDoseVaccinated.text = peopleVaccinated.toString()
                textFullyVaccinated.text = peopleFullyVaccinated.toString()
                textCountryName.setOnClickListener {
                    when (expandableLayout.visibility) {
                        View.GONE -> {
                            expandableLayout.visibility = View.VISIBLE
                            textCountryName.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                0,
                                0,
                                0,
                                R.drawable.ic_baseline_expand_less_24
                            )
                        }
                        else -> {
                            expandableLayout.visibility = View.GONE
                            textCountryName.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                0,
                                0,
                                0,
                                R.drawable.ic_baseline_expand_more_24
                            )
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount() = list.size

    private fun initPieChart(chart: AnimatedPieView, position: Int) {
        val config = AnimatedPieViewConfig()
        with(DataManager.vaccineListSorted.getVaccinatedFully(position = position)) {
            config.apply {
                startAngle(-40f)
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

                addData(
                    SimplePieInfo(
                        peopleFullyVaccinated.toDouble(),
                        randomColor, "Fully"
                    )
                )
                addData(
                    SimplePieInfo(
                        peopleVaccinated.toDouble(),
                        randomColor, "First Dose"
                    )
                )
            }
        }
        chart.applyConfig(config)
        chart.start()
    }
}