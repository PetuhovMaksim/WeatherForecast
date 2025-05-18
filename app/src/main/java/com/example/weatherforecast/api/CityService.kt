package com.example.weatherforecast.api

import com.example.weatherforecast.serialized_data.CityData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CityService {
    @GET("/v1/city")
    fun tryToGetCityInfo(@Query("name") cityName: String,
                         @Header("X-Api-Key")key: String = "EoaMyFFeFistlmpbNNed3Q==EDyWDrRzVmUOhc4F"): Call<List<CityData>>
}