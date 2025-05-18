package com.example.weatherforecast.serialized_data

import kotlinx.serialization.Serializable

@Serializable
data class DaysWeatherData(
    val time: Array<String> = arrayOf(),
    val temperature_2m_max: Array<Float> = arrayOf(),
    val temperature_2m_min: Array<Float> = arrayOf(),
    val apparent_temperature_min: Array<Float> = arrayOf(),
    val apparent_temperature_max: Array<Float> = arrayOf(),
    val sunrise: Array<String> = arrayOf(),
    val sunset: Array<String> = arrayOf(),
    val precipitation_sum: Array<Float> = arrayOf(),
    val rain_sum: Array<Float> = arrayOf(),
    val showers_sum: Array<Float> = arrayOf(),
    val snowfall_sum: Array<Float> = arrayOf()
)