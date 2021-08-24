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
import java.util.*

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
            override fun onQueryTextSubmit(query: String): Boolean {
                val searchQuery = query.lowercase()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
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
                val searchQuery = query.lowercase()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
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