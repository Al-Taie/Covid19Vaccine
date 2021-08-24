package com.melon.covid_19_vaccine.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.databinding.FragmentSearchBinding
import com.melon.covid_19_vaccine.ui.BaseFragment
import com.melon.covid_19_vaccine.util.SearchAdapter
import com.melon.covid_19_vaccine.util.SearchAdapter.initData
import com.melon.covid_19_vaccine.util.capitalize

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun setup() {}

    override fun callBack() {
        search()
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    private fun search() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String) = startSearch(query = query.capitalize())

            override fun onQueryTextChange(query: String) = startSearch(query = query.capitalize())
        })
    }

    private fun startSearch(query: String): Boolean {
        binding.apply {
            if (SearchAdapter.isFounded(query)) {
                initData(view = pieChart, query = query)
                pieChart.visibility = View.VISIBLE
                searchAnimation.visibility = View.GONE
                return true
            }
            pieChart.visibility = View.GONE
            searchAnimation.visibility = View.VISIBLE
            return false
        }
    }
}