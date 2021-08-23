package com.melon.covid_19_vaccine.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.melon.covid_19_vaccine.R

import com.melon.covid_19_vaccine.databinding.FragmentVaccinesBinding

import androidx.fragment.app.FragmentTransaction


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VaccinesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VaccinesFragment : Fragment() {
    //    private var param1: String? = null
//    private var param2: String? = null

    lateinit var binding: FragmentVaccinesBinding

    val childFragment = VaccineDetailsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVaccinesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.showPfizerDetailsButton.setOnClickListener() {
            doAction()

        }
        binding.showAstrazenecaDetailsButton.setOnClickListener() {
            doAction()
        }
        binding.showModernaDetailsButton.setOnClickListener() {
            doAction()
        }
        binding.showJandjDetailsButton.setOnClickListener() {
            doAction()
        }
        binding.showSinopharmDetailsButton.setOnClickListener() {
            doAction()
        }

    }

    private fun doAction() {
        changeFragment(childFragment)
        binding.mainCon.visibility = View.INVISIBLE
    }


    private fun changeFragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(
            R.id.fragment_container_two,
            fragment
        ).commit()


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VaccinesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VaccinesFragment().apply {
                arguments = Bundle().apply {

//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}