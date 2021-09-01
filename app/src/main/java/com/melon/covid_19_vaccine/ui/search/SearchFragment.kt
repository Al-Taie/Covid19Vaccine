package com.melon.covid_19_vaccine.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.data.domain.Vaccinated
import com.melon.covid_19_vaccine.data.interfaces.VaccinatedInteractionListener
import com.melon.covid_19_vaccine.databinding.FragmentSearchBinding
import com.melon.covid_19_vaccine.ui.base.BaseFragment
import com.melon.covid_19_vaccine.util.capitalize


/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>(), VaccinatedInteractionListener {
    lateinit var adapter : VaccinatedAdapter
    override fun setup() {
        adapter = VaccinatedAdapter(DataManager.vaccineListSorted, this)
        binding.recyclerVaccinated.adapter = adapter
    }

    override fun callBack() {
        binding.searchBar.apply {
            onActionViewExpanded()
        }

        search()
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    private fun search() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String) = startSearch(query = query.capitalize(), onChanged = true)

            override fun onQueryTextChange(query: String) = startSearch(query = query.capitalize())
        })
    }

    private fun startSearch(query: String, onChanged: Boolean = false): Boolean {
        binding.apply {
            if (SearchAdapter.isFounded(query)) {
                val list = DataManager.vaccineMap[query]
                val newList = mutableListOf<List<Vaccinated>>()
                list?.let {
                    newList.add(it)
                }
                adapter.setData(newList)
                search404.visibility = View.INVISIBLE
                recyclerVaccinated.visibility = View.VISIBLE
                return true
            }

            if (onChanged) {
                search404.visibility = View.VISIBLE
                recyclerVaccinated.visibility = View.INVISIBLE
            }

            if(query.isEmpty()) {
                search404.visibility = View.INVISIBLE
                recyclerVaccinated.visibility = View.VISIBLE
                adapter.setData(DataManager.vaccineListSorted)
            }

            return false
        }
    }

    override fun onClickItem(vaccinated: Vaccinated) {}

    override fun onClickName(name: String) {}
}