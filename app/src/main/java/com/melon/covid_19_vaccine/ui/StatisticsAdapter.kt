package com.melon.covid_19_vaccine.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.ui.viewHolders.StatisticsViewHolder

class StatisticsAdapter(val list:List<List<Vaccinated>>) : RecyclerView.Adapter<StatisticsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_statistics, parent, false)
        return StatisticsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        val currentCountry = list[position]

        holder.apply {
            countryNameOne.text = currentCountry.get(0).country
            totalCase.text=currentCountry.get(5).totalVaccinations.toString()
        }


    }

    override fun getItemCount() = list.size

}