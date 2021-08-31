package com.melon.covid_19_vaccine.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
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

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val data = it.getSerializable(Constant.VaccineName.VACCINE_DETAILS) as Details
            bindData(data)
        }
    }

    private fun bindData(data: Details) {
        binding.apply {
            name.text = data.data[Constant.VaccineDetailsIndex.VACCINE_NAME].toString()
            dosesPercent.text = data.data[Constant.VaccineDetailsIndex.DOSE_TAKEN].toString()
            efficacyPercent.text = data.data[Constant.VaccineDetailsIndex.EFFECTIVENESS].toString()
            nameText.text = data.data[Constant.VaccineDetailsIndex.NAME].toString()
            manufacturer.text = data.data[Constant.VaccineDetailsIndex.MANUFACTURER].toString()
            typeText.text = data.data[Constant.VaccineDetailsIndex.TYPE_OF_VACCINE].toString()
            numberText.text = data.data[Constant.VaccineDetailsIndex.NUMBER_OF_SHOT].toString()
            howGivenText.text = data.data[Constant.VaccineDetailsIndex.HOW_GIVEN].toString()
            vaccineImage.setImageResource(data.data[Constant.VaccineDetailsIndex.IMAGE_SRC].toString().toInt())
        }

    }

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentVaccineDetailsBinding
        get() = FragmentVaccineDetailsBinding::inflate

    companion object {

        fun newInstance(data: Details) = VaccineDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(Constant.VaccineName.VACCINE_DETAILS, data)
                }
        }
    }
}