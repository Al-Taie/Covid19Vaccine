package com.melon.covid_19_vaccine.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
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
        DataManager.initTopFive()
        initTopFiveBinding(binding = binding)
        initPieChart(binding = binding)
    }

    override fun callBack() {}
}