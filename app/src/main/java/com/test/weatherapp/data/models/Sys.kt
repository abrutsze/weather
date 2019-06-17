package com.test.weatherapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Sys(
    var type: Int,
    var id: Int,
    var message: Double,
    var country: String,
    var sunrise: Int,
    var sunset: Int
) : Parcelable
