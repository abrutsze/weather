package com.test.weatherapp.view.activities

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.test.weatherapp.App
import com.test.weatherapp.R
import com.test.weatherapp.view.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun initBeforeView() {
        with(application as App) {
            di.inject(this@MainActivity)
        }
    }

    override fun getContentViewId(): Int = R.layout.activity_main

    override fun initViews() {

        navController = findNavController(R.id.mainNav)

    }


}
