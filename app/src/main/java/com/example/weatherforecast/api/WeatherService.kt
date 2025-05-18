package com.example.weatherforecast.api

import com.example.weatherforecast.serialized_data.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/v1/forecast?daily=rain_sum,showers_sum,snowfall_sum,sunset,sunrise,temperature_2m_max,temperature_2m_min,apparent_temperature_max,apparent_temperature_min,precipitation_sum&hourly=temperature_2m,rain,showers,snowfall,precipitation,relative_humidity_2m,apparent_temperature&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,snowfall&timezone=Europe%2FMoscow")
    fun tryToGetWeatherInfo(
        @Query("latitude")latitude: Float,
        @Query("longitude")longitude: Float): Call<WeatherData>
}