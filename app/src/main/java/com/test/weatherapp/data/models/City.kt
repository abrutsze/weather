package com.test.weatherapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class City(
    @PrimaryKey
    var name: String,
    var timezone: Int,
    var id: Int
)