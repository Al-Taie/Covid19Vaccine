package com.melon.covid_19_vaccine.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.databinding.ActivityHomeBinding
import com.melon.covid_19_vaccine.ui.fragments.*
import com.melon.covid_19_vaccine.util.Constant
import com.melon.covid_19_vaccine.util.CsvParser
import com.melon.covid_19_vaccine.util.initData

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callBack()
    }

    private fun callBack() {
        val inputStream = assets.open(Constant.DATA_FILE)
        CsvParser.parseFileData(inputStream)
        initData()
        addNavigationListener()
    }

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
