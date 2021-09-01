package com.melon.covid_19_vaccine.ui.statstics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.databinding.ItemStatisticsBinding
import com.melon.covid_19_vaccine.util.getVaccinated

class StatisticsAdapter(private val list: List<List<Vaccinated>>) :
    RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val item = R.layout.item_statistics
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return StatisticsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        with(list.getVaccinated(position = position)) {
            holder.binding.apply {
                countryName.text = country
                totalCases.text = totalVaccinations.toString()
            }
        }
    }

    override fun getItemCount() = list.size

    class StatisticsViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemStatisticsBinding.bind(viewItem)
    }
}