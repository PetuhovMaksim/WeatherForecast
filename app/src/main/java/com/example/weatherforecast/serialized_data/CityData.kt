package com.example.weatherforecast.serialized_data

import kotlinx.serialization.Serializable

@Serializable
data class CityData(
    val name: String = "",
    val latitude: Float = 0f,
    val longitude: Float = 0f
)