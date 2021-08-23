package com.melon.covid_19_vaccine.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.FragmentStatisticsBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
import com.melon.covid_19_vaccine.util.initPieChart
import com.melon.covid_19_vaccine.util.initTopFiveBinding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StatisticsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatisticsFragment : BaseFragment<FragmentStatisticsBinding>() {


//    private var param1: String? = null
//    private var param2: String? = null

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatisticsFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatisticsFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun setup() {
        DataManager.initTopFive()
        initTopFiveBinding(binding = binding)
        initPieChart(binding = binding)
    }

    override fun callBack() {
//        binding.gradientChart.chartValues = arrayOf(
//            10f, 30f, 25f, 32f, 13f, 5f, 18f, 36f, 20f, 30f, 28f, 27f, 29f
//        )
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentStatisticsBinding
        get() = FragmentStatisticsBinding::inflate
}