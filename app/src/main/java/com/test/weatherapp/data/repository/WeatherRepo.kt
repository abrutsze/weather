package com.test.weatherapp.data.repository

import com.test.weatherapp.data.models.WeatherResult
import io.reactivex.Observable

interface WeatherRepo {

    fun getWeather(name: String): Observable<WeatherResult>
}