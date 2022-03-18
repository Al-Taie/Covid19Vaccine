package com.melon.covid_19_vaccine.ui

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.blongho.country_data.World
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.ActivityHomeBinding
import com.melon.covid_19_vaccine.ui.about.AboutFragment
import com.melon.covid_19_vaccine.ui.base.BaseActivity
import com.melon.covid_19_vaccine.ui.home.HomeFragment
import com.melon.covid_19_vaccine.ui.search.SearchFragment
import com.melon.covid_19_vaccine.ui.statistics.StatisticsFragment
import com.melon.covid_19_vaccine.ui.vaccines.VaccinesFragment
import com.melon.covid_19_vaccine.util.Constant
import com.melon.covid_19_vaccine.util.CsvParser
import com.melon.covid_19_vaccine.util.initData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun setup() {
        callBack()
    }

    override fun callBack() {
        CoroutineScope(Dispatchers.IO).launch {
            val inputStream = assets.open(Constant.DATA_FILE)
            CoroutineScope(Dispatchers.IO).launch {
                CsvParser.parseFileData(inputStream)
            }.invokeOnCompletion {
                CoroutineScope(Dispatchers.IO).launch { initData() }.invokeOnCompletion {
                    CoroutineScope(Dispatchers.Main).launch {
                        DataManager.isDataReady.emit(true)
                    }
                }
            }
        }
        addNavigationListener()
        World.init(applicationContext)
    }

    override val theme = R.style.Theme_Covid19Vaccine

    override val inflate: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate

    private fun addNavigationListener() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.vaccines -> {
                    replaceFragment(VaccinesFragment())
                    true
                }
                R.id.search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.statistics -> {
                    replaceFragment(StatisticsFragment())
                    true
                }
                R.id.about -> {
                    replaceFragment(AboutFragment())
                    true
                }
                else -> false
            }

        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}
