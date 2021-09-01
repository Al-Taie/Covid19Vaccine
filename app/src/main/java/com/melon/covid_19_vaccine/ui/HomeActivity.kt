package com.melon.covid_19_vaccine.ui

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.databinding.ActivityHomeBinding
import com.melon.covid_19_vaccine.ui.about.AboutFragment
import com.melon.covid_19_vaccine.ui.base.BaseActivity
import com.melon.covid_19_vaccine.ui.home.*
import com.melon.covid_19_vaccine.ui.search.SearchFragment
import com.melon.covid_19_vaccine.ui.statistics.StatisticsFragment
import com.melon.covid_19_vaccine.ui.vaccines.VaccinesFragment
import com.melon.covid_19_vaccine.util.Constant
import com.melon.covid_19_vaccine.util.CsvParser
import com.melon.covid_19_vaccine.util.initData

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun setup() {
        callBack()
    }

    override fun callBack() {
        val inputStream = assets.open(Constant.DATA_FILE)
        CsvParser.parseFileData(inputStream)
        initData()
        addNavigationListener()


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
