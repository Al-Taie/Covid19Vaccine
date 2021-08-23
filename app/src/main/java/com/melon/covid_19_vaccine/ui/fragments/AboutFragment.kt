package com.melon.covid_19_vaccine.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.databinding.FragmentAboutBinding
import com.melon.covid_19_vaccine.ui.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : BaseFragment<FragmentAboutBinding>() {

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun setup() {
    }

    override fun callBack() {
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutBinding
        get() = FragmentAboutBinding::inflate
}