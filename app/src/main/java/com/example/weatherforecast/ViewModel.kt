package com.example.weatherforecast

import androidx.lifecycle.ViewModel
import com.example.weatherforecast.serialized_data.CityData
import com.example.weatherforecast.serialized_data.WeatherData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WeatherViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    fun setWeatherData(weather: WeatherData) {
        _uiState.update { currentState -> currentState.copy(weatherData = weather)}
    }

    fun setCityData(city: CityData) {
        _uiState.update { currentState ->
            currentState.copy(cityData = city)}
    }

    fun setCurrentDay(current: Int) {
        _uiState.update { currentState -> currentState.copy(currentDayId = current)}
    }
}

