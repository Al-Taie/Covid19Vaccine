package com.melon.covid_19_vaccine.ui.search

import androidx.recyclerview.widget.DiffUtil
import com.melon.covid_19_vaccine.data.domain.Vaccinated

class VaccinatedDiffUtil(private val oldList: List<List<Vaccinated>>, private val newList: List<List<Vaccinated>>): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}