package com.example.weatherforecast

import com.example.weatherforecast.serialized_data.CityData
import com.example.weatherforecast.serialized_data.WeatherData

data class WeatherUiState(
    val error: Boolean = false,
    val currentDayId: Int = 0,
    val gotWeather: Boolean = false,
    val weatherData: WeatherData = WeatherData(),

    val gotCity: Boolean = false,
    val cityData: CityData = CityData()
)