package com.melon.covid_19_vaccine.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.domain.Details
import com.melon.covid_19_vaccine.databinding.FragmentVaccineDetailsBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
import com.melon.covid_19_vaccine.util.Constant

/**
 * A simple [Fragment] subclass.
 * Use the [VaccineDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccineDetailsFragment : BaseFragment<FragmentVaccineDetailsBinding>() {
    override fun setup() {}

    override fun callBack() {

        binding.goBackButton.setOnClickListener {
            view?.findViewById<View>(R.id.fragment_container_two)?.visibility = View.INVISIBLE
            view?.findViewById<View>(R.id.scroll_view)?.visibility = View.VISIBLE
        }
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentVaccineDetailsBinding
        get() = FragmentVaccineDetailsBinding::inflate

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val data = it.getSerializable(Constant.VaccineName.VACCINE_DETAILS) as Details
            bindData(data)
        }
    }

    private fun bindData(details: Details) {
        binding.apply {
            with(details) {
                name.text = data[Constant.VaccineDetailsIndex.VACCINE_NAME]
                dosesPercent.text = data[Constant.VaccineDetailsIndex.DOSE_TAKEN]
                efficacyPercent.text = data[Constant.VaccineDetailsIndex.EFFECTIVENESS]
                nameText.text = data[Constant.VaccineDetailsIndex.NAME]
                manufacturer.text = data[Constant.VaccineDetailsIndex.MANUFACTURER]
                typeText.text = data[Constant.VaccineDetailsIndex.TYPE_OF_VACCINE]
                numberText.text = data[Constant.VaccineDetailsIndex.NUMBER_OF_SHOT]
                howGivenText.text = data[Constant.VaccineDetailsIndex.HOW_GIVEN]
                vaccineImage.setImageResource(data[Constant.VaccineDetailsIndex.IMAGE_SRC].toInt())
            }
        }
    }

    companion object {

        fun newInstance(data: Details) = VaccineDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(Constant.VaccineName.VACCINE_DETAILS, data)
            }
        }
    }
}