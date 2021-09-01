package com.melon.covid_19_vaccine.ui.statstics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.melon.covid_19_vaccine.ui.base.BaseFragment


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
//        initTopFiveBinding(binding = binding)
//        initPieChart(binding = binding)

        binding.recyclerCountry.adapter = StatisticsAdapter(DataManager.getVaccinatedTop10)

    }

    override fun callBack() {


    }


}