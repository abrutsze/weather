package com.test.weatherapp

import android.app.Application
import com.test.weatherapp.di.component.DIComponent
import com.test.weatherapp.di.modules.ApiModule
import com.test.weatherapp.di.modules.AppModule

class App : Application() {

    lateinit var di: DIComponent

    override fun onCreate() {
        super.onCreate()

        di = DaggerDIComponent
            .builder()
            .apiModule(ApiModule())
            .appModule(AppModule(this))
            .build()

    }
}