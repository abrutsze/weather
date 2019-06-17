package com.test.weatherapp.view.fragments


import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.test.weatherapp.App
import com.test.weatherapp.R
import com.test.weatherapp.data.models.WeatherResult
import com.test.weatherapp.view.base.BaseFragment
import com.test.weatherapp.viewModel.ViewModelFactory
import com.test.weatherapp.viewModel.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainFragment : BaseFragment() {


    private lateinit var viewModel: WeatherViewModel
    private var tvCity: TextView? = null
    private var tvWeather: TextView? = null
    private var tvDesc: TextView? = null
    private var tvTemperature: TextView? = null
    private var tvLowestTemp: TextView? = null
    private var tvHighestTemp: TextView? = null
    private var tvPressure: TextView? = null
    private var tvHumidity: TextView? = null
    private var tvWindSpeed: TextView? = null
    private var tvSunrise: TextView? = null
    private var tvSunset: TextView? = null
    private var tvCoordinate: TextView? = null
    private var iconImage: ImageView? = null
    private var tvSearch: TextView? = null
    private var edSearch: EditText? = null

    override fun initBeforeView() {
        with(context!!.applicationContext as App) {
            viewModel = androidx.lifecycle.ViewModelProviders.of(
                this@MainFragment,
                ViewModelFactory(this)
            ).get(WeatherViewModel::class.java)
        }
    }

    override fun getContentViewId(): Int = R.layout.fragment_main

    override fun initViews(rootView: View) {

        tvCity = rootView.findViewById<TextView>(R.id.tvCity)
        tvWeather = rootView.findViewById<TextView>(R.id.tvWeather)
        tvDesc = rootView.findViewById<TextView>(R.id.tvDesc)
        tvTemperature = rootView.findViewById<TextView>(R.id.tvTemperature)
        tvLowestTemp = rootView.findViewById<TextView>(R.id.tvLowestTemp)
        tvHighestTemp = rootView.findViewById<TextView>(R.id.tvHighestTemp)
        tvPressure = rootView.findViewById<TextView>(R.id.tvPressure)
        tvHumidity = rootView.findViewById<TextView>(R.id.tvHumidity)
        tvWindSpeed = rootView.findViewById<TextView>(R.id.tvWindSpeed)
        tvSunrise = rootView.findViewById<TextView>(R.id.tvSunrise)
        tvSunset = rootView.findViewById<TextView>(R.id.tvSunset)
        tvCoordinate = rootView.findViewById<TextView>(R.id.tvCoordinate)
        iconImage = rootView.findViewById<ImageView>(R.id.icon)
        tvSearch = rootView.findViewById<TextView>(R.id.tvSearch)
        edSearch = rootView.findViewById<EditText>(R.id.edSearch)




        progress.visibility = View.VISIBLE
        initObserver()
        viewModel.getWeather("Moscow")

        tvSearch?.setOnClickListener {
            progress.visibility = View.VISIBLE
            viewModel.getWeather(edSearch?.text.toString())
        }
    }


    private fun initObserver() {

        viewModel.weatherResult.observe(this, Observer<WeatherResult> {
            progress.visibility = View.GONE
            if (it != null) {
                tvCity?.text = it.name
                tvWeather?.text = "Weather : ${it.weather.get(0).main}"
                tvDesc?.text = "Description : ${it.weather.get(0).description}"
                tvTemperature?.text = "Temperature : ${it.main.temp} fahrenheit"
                tvLowestTemp?.text = "Lowest temperature : ${it.main.tempMin} fahrenheit"
                tvHighestTemp?.text = "Highest temperature : ${it.main.tempMax} fahrenheit"
                tvPressure?.text = "Pressure : ${it.main.pressure} hPa"
                tvHumidity?.text = "Humidity : ${it.main.humidity} %"
                tvWindSpeed?.text = "Wind Speed : ${it.wind.speed} miles/hour"
                tvSunrise?.text = "Sunrise : " + formatTime(it.sys.sunrise)
                tvSunset?.text = "Sunset : " + formatTime(it.sys.sunset)
                tvCoordinate?.text = "Coordinate : ${it.coord.lat},${it.coord.lon}"
                Glide.with(this).load("http://openweathermap.org/img/w/${it.weather.get(0).icon}.png").into(iconImage!!)
            }

        })


        viewModel.weatherLoader.observe(this, Observer {
            progress.visibility = View.GONE

        })


        viewModel.weatherError.observe(this, Observer {
            progress.visibility = View.GONE
        })
    }

    fun formatTime(dateObject: Int): String {
        var date: Date = Date(dateObject.toLong())
        val timeFormat = SimpleDateFormat("h:mm a")
        return timeFormat.format(date)
    }


}
