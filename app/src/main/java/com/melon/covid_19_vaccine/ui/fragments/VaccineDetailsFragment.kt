package com.melon.covid_19_vaccine.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.databinding.FragmentVaccineDetailsBinding
import com.melon.covid_19_vaccine.ui.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [VaccineDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccineDetailsFragment : BaseFragment<FragmentVaccineDetailsBinding>() {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentVaccineDetailsBinding
        get() = FragmentVaccineDetailsBinding::inflate
}