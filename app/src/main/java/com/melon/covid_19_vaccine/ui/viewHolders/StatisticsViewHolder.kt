package com.melon.covid_19_vaccine.ui.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melon.covid_19_vaccine.R

class StatisticsViewHolder(ViewItem: View) : RecyclerView.ViewHolder(ViewItem) {
    val countryNameOne: TextView = ViewItem.findViewById(R.id.country_name_one)
    val totalCase:TextView=ViewItem.findViewById(R.id.total_cases_one)
}