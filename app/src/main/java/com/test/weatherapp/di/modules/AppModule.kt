package com.test.weatherapp.di.modules

import android.content.Context
import androidx.room.Room
import com.test.weatherapp.App
import com.test.weatherapp.data.database.AppDatabase
import com.test.weatherapp.data.database.CityDao
import com.test.weatherapp.data.network.Api
import com.test.weatherapp.data.repository.WeatherRepo
import com.test.weatherapp.data.repository.WeatherRepository
import com.test.weatherapp.utils.AppConstants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    fun providesApp(): App = app

    @Provides
    @Singleton
    internal fun provideContext(): Context = app.applicationContext


    @Singleton
    @Provides
    internal fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME).build()
    }


    @Singleton
    @Provides
    internal fun providesCityAppDataBaseDao(database: AppDatabase): CityDao {
        return database.cityDao
    }


    @Singleton
    @Provides
    internal fun provideWeatherRepository(context: Context, dataBase: AppDatabase, api: Api): WeatherRepository {
        return WeatherRepository(context, dataBase, api)
    }

    @Singleton
    @Provides
    internal fun provideWeatherRepo(weatherRepository: WeatherRepository): WeatherRepo {
        return weatherRepository
    }


}