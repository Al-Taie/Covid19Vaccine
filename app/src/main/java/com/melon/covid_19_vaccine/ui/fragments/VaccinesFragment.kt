package com.melon.covid_19_vaccine.ui.fragments


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.databinding.FragmentVaccinesBinding
import com.melon.covid_19_vaccine.ui.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [VaccinesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccinesFragment : BaseFragment<FragmentVaccinesBinding>() {
    override fun setup() {
        binding.apply {
            showPfizerDetailsButton.setOnClickListener { doAction() }
            showAstrazenecaDetailsButton.setOnClickListener { doAction() }
            showModernaDetailsButton.setOnClickListener { doAction() }
            showJandjDetailsButton.setOnClickListener { doAction() }
            showSinopharmDetailsButton.setOnClickListener { doAction() }
        }
    }

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentVaccinesBinding
        get() = FragmentVaccinesBinding::inflate

    private fun doAction() {
        replaceFragment(VaccineDetailsFragment())
        binding.mainCon.visibility = View.INVISIBLE
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container_two, fragment)
            commit()
        }
    }
}