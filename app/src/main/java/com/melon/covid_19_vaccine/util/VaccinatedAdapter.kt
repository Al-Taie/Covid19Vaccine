package com.melon.covid_19_vaccine.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.data.interfaces.VaccinatedInteractionListener


class VaccinatedAdapter(
    private val list: List<Vaccinated>,
    private val listener: VaccinatedInteractionListener
) :
    RecyclerView.Adapter<VaccinatedAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // TODO("ViewHolder Not implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // FIXME: 8/29/2021 CHANGE ITEM VALUE
        val item: Int = 0 // R.layout.vaccinated_item
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO("onBindViewHolder Not implemented")
    }

    override fun getItemCount() = list.size
}