package com.melon.covid_19_vaccine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.melon.covid_19_vaccine.R
import com.melon.covid_19_vaccine.ui.fragments.HomeFragment


abstract class BaseFragment <VB: ViewBinding> : Fragment() {
    abstract fun setup()
    abstract fun callBack()
    abstract val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> VB
    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = inflate(inflater, container, false)
        setup()
        callBack()
        return _binding.root
    }
}
