package com.test.weatherapp.data.repository

import android.content.Context
import com.test.weatherapp.data.database.AppDatabase
import com.test.weatherapp.data.models.WeatherResult
import com.test.weatherapp.data.network.Api
import com.test.weatherapp.utils.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val context: Context,
    private val dataBase: AppDatabase,
    private val api: Api
) : WeatherRepo {

    override fun getWeather(name: String): Observable<WeatherResult> {
        return api.getWeather(name, AppConstants.API_KEY)
    }
}