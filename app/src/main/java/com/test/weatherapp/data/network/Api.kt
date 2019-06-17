package com.test.weatherapp.data.network

import com.test.weatherapp.data.models.WeatherResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("2.5/weather")
    fun getWeather(@Query("q") q: String, @Query("appid") appid: String): Observable<WeatherResult>
}
