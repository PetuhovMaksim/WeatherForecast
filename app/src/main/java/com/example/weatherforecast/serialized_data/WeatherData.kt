package com.example.weatherforecast.serialized_data

import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(
    val latitude: Float = 0f,
    val longitude: Float = 0f,

    val hourly: HoursWeatherData = HoursWeatherData(),
    val daily: DaysWeatherData = DaysWeatherData(),
    val current: CurrentWeatherData = CurrentWeatherData()
)