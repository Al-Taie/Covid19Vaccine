package com.melon.covid_19_vaccine.ui.search

import androidx.recyclerview.widget.DiffUtil
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.util.Constant

class VaccinatedDiffUtil(val mOldList: List<List<Vaccinated>>, val mNewList: List<List<Vaccinated>>): DiffUtil.Callback() {
    override fun getOldListSize() = mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                mOldList[oldItemPosition] == mNewList[newItemPosition]
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}