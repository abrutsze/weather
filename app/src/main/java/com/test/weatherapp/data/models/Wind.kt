package com.test.weatherapp.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Wind(
    var speed: Float,
    var deg: Float
) : Parcelable