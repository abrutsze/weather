package com.test.weatherapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Coord(
    var lon: Double,
    var lat: Double
) : Parcelable