package com.melon.covid_19_vaccine.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.blongho.country_data.World
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.data.interfaces.VaccinatedInteractionListener
import com.melon.covid_19_vaccine.databinding.ItemVaccinatedBinding
import com.melon.covid_19_vaccine.util.Constant
import com.melon.covid_19_vaccine.util.getVaccinated
import com.razerdp.widget.animatedpieview.AnimatedPieView
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig
import com.razerdp.widget.animatedpieview.data.SimplePieInfo


class VaccinatedAdapter(
    private var list: List<List<Vaccinated>>,
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

        with(list.getVaccinated(position = position)) {
            holder.binding.apply {
                imageCountryFlag.setImageResource(World.getFlagOf(isoCode))
                textCountryName.text = country
                textTotalVaccination.text = totalVaccinations.toString()
                textFirstDoseVaccinated.text = peopleVaccinated.toString()
                textFullyVaccinated.text = peopleFullyVaccinated.toString()
                expanded = setExpandState(holder = holder, state = !expanded)

                textCountryName.setOnClickListener {
                    expanded = setExpandState(holder = holder, state = expanded)
                }
            }
        }
    }

    private fun setExpandState(holder: VaccinatedViewHolder, state: Boolean): Boolean {
        holder.binding.apply {
            return if (!state) {
                expandableLayout.visibility = View.VISIBLE
                imageExpandCollapse.setImageResource(R.drawable.ic_baseline_expand_less_24)
                true
            } else {
                expandableLayout.visibility = View.GONE
                imageExpandCollapse.setImageResource(R.drawable.ic_baseline_expand_more_24)
                false
            }
        }
    }

    fun setData(newList: List<List<Vaccinated>>) {
        val diffResult = DiffUtil.calculateDiff(VaccinatedDiffUtil(list, newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = list.size

    private fun initPieChart(chart: AnimatedPieView, position: Int) {
        val config = AnimatedPieViewConfig()
        with(DataManager.vaccineListSorted.getVaccinated(position = position)) {
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
                        Constant.Colors.BLUE, "Fully"
                    )
                )
                addData(
                    SimplePieInfo(
                        peopleVaccinated.toDouble(),
                        Constant.Colors.RED, "First Dose"
                    )
                )
            }
        }
        chart.applyConfig(config)
        chart.start()
    }
}