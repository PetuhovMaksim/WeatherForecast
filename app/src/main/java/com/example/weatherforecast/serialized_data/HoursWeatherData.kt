package com.example.weatherforecast.serialized_data

import kotlinx.serialization.Serializable

@Serializable
data class HoursWeatherData(
    val time: Array<String> = arrayOf(), // День и время для погоды
    val temperature_2m: Array<Float> = arrayOf(), // Почасовая температура
    val apparent_temperature: Array<Float> = arrayOf(), // Ожидаемая температура
    val precipitation: Array<Float> = arrayOf(),
    val rain: Array<Float> = arrayOf(),
    val showers: Array<Float> = arrayOf(),
    val snowfall: Array<Float> = arrayOf(),
    val relative_humidity_2m: Array<Float> = arrayOf()
)