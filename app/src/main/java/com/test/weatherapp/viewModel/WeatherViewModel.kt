package com.test.weatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.weatherapp.data.models.WeatherResult
import com.test.weatherapp.data.repository.WeatherRepo
import com.test.weatherapp.di.component.DIComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherViewModel : ViewModel(), DIComponent.Injectable {

    var weatherResult: MutableLiveData<WeatherResult> = MutableLiveData()
    var weatherError: MutableLiveData<String> = MutableLiveData()
    var weatherLoader: MutableLiveData<Boolean> = MutableLiveData()


    @Inject
    lateinit var weatherRepo: WeatherRepo


    override fun inject(diComponent: DIComponent) {
        diComponent.inject(this)
    }


    fun getWeather(name: String) {
        val observer = object : DisposableObserver<WeatherResult>() {
            override fun onNext(weatherResult1: WeatherResult) {
                weatherResult.postValue(weatherResult1)
                weatherLoader.postValue(false)
            }


            override fun onError(e: Throwable) {
                weatherError.postValue(e.message)
                weatherLoader.postValue(false)
            }

            override fun onComplete() {

            }
        }


        weatherRepo.getWeather(name).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(observer)
    }


}
