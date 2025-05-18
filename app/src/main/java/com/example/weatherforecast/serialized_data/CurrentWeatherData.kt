package com.example.weatherforecast.serialized_data

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherData(
    val time: String = "",
    val temperature_2m: Float = 0f,
    val relative_humidity_2m: Float = 0f,
    val apparent_temperature: Float = 0f,
    val is_day: Int = 1,
    val precipitation: Float = 0f,
    val rain: Float = 0f,
    val showers: Float = 0f,
    val snowfall: Float = 0f,
)