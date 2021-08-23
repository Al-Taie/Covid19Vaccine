package com.melon.covid_19_vaccine.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.data.DataManager
import com.melon.covid_19_vaccine.databinding.ActivityHomeBinding
import com.melon.covid_19_vaccine.ui.fragments.*
import com.melon.covid_19_vaccine.util.Constant
import com.melon.covid_19_vaccine.util.CsvParser
import com.melon.covid_19_vaccine.util.SearchAdapter
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

    private fun addNavigationListener(){
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    changeFragment(HomeFragment())
                    true
                }
                R.id.vaccines ->{
                    changeFragment(VaccinesFragment())
                    true
                }
                R.id.search -> {
                    changeFragment(SearchFragment())
                    true
                }
                R.id.statistics -> {
                    changeFragment(StatisticsFragment())
                    true
                }
                R.id.about -> {
                    changeFragment(AboutFragment())
                    true
                }
                else -> false
            }

        }

    }

    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }

}
