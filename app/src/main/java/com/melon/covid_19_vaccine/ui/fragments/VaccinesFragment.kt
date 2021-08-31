package com.melon.covid_19_vaccine.ui.fragments


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Details
import com.melon.covid_19_vaccine.databinding.FragmentVaccinesBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
import com.melon.covid_19_vaccine.util.Constant


/**
 * A simple [Fragment] subclass.
 * Use the [VaccinesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccinesFragment : BaseFragment<FragmentVaccinesBinding>() {
    override fun setup() {
        binding.apply {
            showPfizerDetailsButton.setOnClickListener {
                val data = Details(Constant.VaccineName.PFIZER)
                doAction(data) }
            showAstrazenecaDetailsButton.setOnClickListener {
                val data = Details(Constant.VaccineName.ASTRAZENECA)
                doAction(data) }
            showModernaDetailsButton.setOnClickListener {
                val data = Details(Constant.VaccineName.MODERNA)
                doAction(data) }
            showJandjDetailsButton.setOnClickListener {
                val data = Details(Constant.VaccineName.JOHNSEN_AND_JOHNSEN)
                doAction(data) }
            showSinopharmDetailsButton.setOnClickListener {
                val data = Details(Constant.VaccineName.SINOPHARM)
                doAction(data) }
        }
    }

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentVaccinesBinding
        get() = FragmentVaccinesBinding::inflate

    private fun doAction(data: Details) {
        val detailsFragment = VaccineDetailsFragment.newInstance(data)
        replaceFragment(detailsFragment)
        binding.mainCon.visibility = View.INVISIBLE
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container_two, fragment)
            commit()
        }
    }
}