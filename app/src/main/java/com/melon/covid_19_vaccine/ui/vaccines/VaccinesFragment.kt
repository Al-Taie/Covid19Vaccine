package com.melon.covid_19_vaccine.ui.vaccines


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Details
import com.melon.covid_19_vaccine.data.domain.VaccineInfo
import com.melon.covid_19_vaccine.databinding.FragmentVaccinesBinding
import com.melon.covid_19_vaccine.ui.base.BaseFragment
import com.melon.covid_19_vaccine.ui.fragments.VaccineDetailsFragment


/**
 * A simple [Fragment] subclass.
 * Use the [VaccinesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccinesFragment : BaseFragment<FragmentVaccinesBinding>() {
    override fun setup() { }

    override fun callBack() {
        binding.apply {
            showPfizerDetailsButton.setOnClickListener { doAction(Details(VaccineInfo.PFIZER)) }
            showAstrazenecaDetailsButton.setOnClickListener { doAction(Details(VaccineInfo.ASTRAZENECA)) }
            showModernaDetailsButton.setOnClickListener { doAction(Details(VaccineInfo.MODERNA)) }
            showJandjDetailsButton.setOnClickListener { doAction(Details(VaccineInfo.JOHNSEN_AND_JOHNSEN)) }
            showSinopharmDetailsButton.setOnClickListener { doAction(Details(VaccineInfo.SINOPHARM)) }
        }
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentVaccinesBinding
        get() = FragmentVaccinesBinding::inflate

    private fun doAction(data: Details) {
        val detailsFragment = VaccineDetailsFragment.newInstance(data)
        addFragment(detailsFragment)
        binding.mainCon.visibility = View.INVISIBLE
    }

    private fun addFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container_two, fragment)
            commit()
        }
    }
}