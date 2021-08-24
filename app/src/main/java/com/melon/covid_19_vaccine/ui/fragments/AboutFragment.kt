package com.melon.covid_19_vaccine.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.databinding.FragmentAboutBinding
import com.melon.covid_19_vaccine.ui.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : BaseFragment<FragmentAboutBinding>() {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAboutBinding
        get() = FragmentAboutBinding::inflate
}