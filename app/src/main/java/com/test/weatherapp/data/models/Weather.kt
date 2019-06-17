package com.test.weatherapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Weather(
    var id: Int,
    var main: String,
    var description: String,
    var icon: String
) : Parcelable