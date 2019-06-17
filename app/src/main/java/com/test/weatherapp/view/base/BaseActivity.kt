package com.test.weatherapp.view.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBeforeView()
        setContentView(getContentViewId())
        initViews()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }

    protected abstract fun initBeforeView()

    protected abstract fun getContentViewId(): Int

    protected abstract fun initViews()
}