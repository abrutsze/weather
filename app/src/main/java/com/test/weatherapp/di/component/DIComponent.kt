package com.test.weatherapp.di.component

import androidx.annotation.Keep
import com.test.weatherapp.di.modules.ApiModule
import com.test.weatherapp.di.modules.AppModule
import com.test.weatherapp.view.activities.MainActivity
import com.test.weatherapp.viewModel.WeatherViewModel
import dagger.Component
import javax.inject.Singleton

@Keep
@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface DIComponent {

    interface Injectable {
        fun inject(diComponent: DIComponent)
    }

    fun inject(mainActivity: MainActivity)
    fun inject(weatherViewModel: WeatherViewModel)
}