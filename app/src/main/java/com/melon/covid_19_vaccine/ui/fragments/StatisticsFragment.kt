package com.melon.covid_19_vaccine.ui.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
import com.melon.covid_19_vaccine.ui.StatisticsAdapter
import com.melon.covid_19_vaccine.util.initPieChart
import com.melon.covid_19_vaccine.util.initTopFiveBinding


/**
 * A simple [Fragment] subclass.
 * Use the [StatisticsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatisticsFragment : BaseFragment<FragmentStatisticsBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStatisticsBinding
        get() = FragmentStatisticsBinding::inflate


    override fun setup() {
        DataManager.initTop10()
        initTopFiveBinding(binding = binding)
        initPieChart(binding = binding)

        // Log.v("DataManager=====",DataManager.getVaccinatedTop5.toString())
        //  val adapter = StatisticsAdapter(DataManager.getVaccineListCountry())


        val adapter = StatisticsAdapter(DataManager.getVaccinatedTop5)
        binding.recyclerCountry.adapter = adapter

    }

    override fun callBack() {


    }


}