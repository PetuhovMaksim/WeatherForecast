package com.example.weatherforecast.api

import com.example.weatherforecast.serialized_data.CityData
import com.example.weatherforecast.serialized_data.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InfoGetter {
    val weatherRetrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cityRetrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService = weatherRetrofit.create(WeatherService::class.java)
    val cityService = cityRetrofit.create(CityService::class.java)

    var weatherOnResponse: (WeatherData) -> Unit = {}
    var cityOnResponse: (CityData) -> Unit = {}
    var weatherOnFailure: () -> Unit = {}
    var cityOnFailure: () -> Unit = {}

    fun tryGetWeatherInfo(latitude: Float, longitude: Float) {
        val repos: Call<WeatherData> = weatherService.tryToGetWeatherInfo(latitude, longitude)
        repos.enqueue(object : Callback<WeatherData> {
            override fun onResponse(
                call: Call<WeatherData>,
                response: Response<WeatherData>
            ) {
                if (response.isSuccessful) {
                    println("WEATHER RESPONSE")
                    weatherOnResponse(response.body()!!)
                }
                else {
                    weatherOnFailure()
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                weatherOnFailure()
            }
        })
    }

    fun tryGetCityInfo(name: String) {
        val repos: Call<List<CityData>> = cityService.tryToGetCityInfo(name)
        repos.enqueue(object : Callback<List<CityData>> {
            override fun onResponse(
                call: Call<List<CityData>>,
                response: Response<List<CityData>>
            ) {
                if (response.isSuccessful && response.body()!!.size > 0) {
                    println("CITY RESPONSE")
                    cityOnResponse(response.body()!![0])
                }
                else {
                    cityOnFailure()
                }
            }

            override fun onFailure(call: Call<List<CityData>>, t: Throwable) {
                cityOnFailure()
            }
        })
    }
}