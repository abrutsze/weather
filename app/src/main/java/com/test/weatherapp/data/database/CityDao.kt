package com.test.weatherapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.weatherapp.data.models.City
import io.reactivex.Single

@Dao
interface CityDao {

    @Insert
    fun insert(city: City)

    @Query("Delete from City")
    fun deleteAll()

    @Query("SELECT * FROM City WHERE name = :name")
    fun cityByName(name: String): Single<City>

    @Query("SELECT * from City ORDER BY name ASC")
    fun getAllCitys(): Single<List<City>>
}