package com.test.weatherapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.weatherapp.data.models.City

@Database(entities = [City::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val cityDao: CityDao
}