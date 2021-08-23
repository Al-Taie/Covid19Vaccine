package com.melon.covid_19_vaccine.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.databinding.FragmentHomeBinding
import com.melon.covid_19_vaccine.databinding.FragmentSearchBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
import com.melon.covid_19_vaccine.util.SearchAdapter
import com.melon.covid_19_vaccine.util.SearchAdapter.initData

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>()  {

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun setup() {
    }

    override fun callBack() {
        search()
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    private fun search() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val searchQuery = query.lowercase().capitalize()
                if (SearchAdapter.isFounded(searchQuery)) {
                    initData(binding = binding, query = searchQuery)
                    binding.searchAnimation.visibility = View.GONE
                    return true
                } else {
                    binding.pieChart.visibility = View.GONE
                    binding.searchAnimation.visibility = View.VISIBLE
                }
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                val searchQuery = query.lowercase().capitalize()
                if (SearchAdapter.isFounded(searchQuery)) {
                    initData(binding = binding, query = searchQuery)
                    binding.searchAnimation.visibility = View.GONE
                    return true
                } else {
                    binding.pieChart.visibility = View.GONE
                    binding.searchAnimation.visibility = View.VISIBLE

                }
                return false
            }
        })
    }
}