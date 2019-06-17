package com.test.weatherapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class WeatherResult(

    var coord: Coord,
    var weather: List<Weather>,
    var base: String,
    var main: Main,
    var visibility: Int,
    var wind: Wind,
    var clouds: Clouds, var dt: Int,
    var sys: Sys,
    var timezone: Int,
    var id: Int,
    var name: String, var cod: Int
) : Parcelable