package com.test.weatherapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Main(
    var temp: Double,
    var pressure: Int,
    var humidity: Int,
    var tempMin: Double,
    var tempMax: Double
) : Parcelable