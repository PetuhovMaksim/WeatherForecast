package com.example.weatherforecast.weather_composables

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.serialized_data.HourlyData
import com.example.weatherforecast.stBackColor
import com.example.weatherforecast.stFieldBorder
import com.example.weatherforecast.stFieldColor
import com.example.weatherforecast.stFieldShape

@Composable
fun DaylyWeatherWindow(weatherData: HourlyData = HourlyData()) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(color = stBackColor)) {

        TextStandart("Погода на " + weatherData.time[0].substring(0, 10),
            modifier = Modifier.padding(15.dp)
                .background(color = stFieldColor, shape = stFieldShape)
                .border(border = stFieldBorder, shape = stFieldShape)
                .padding(10.dp))

        Row(modifier = Modifier.horizontalScroll(ScrollState(0))) {
            for (i in 0..<weatherData.time.size) {
                var isDay: Boolean = true
                if (i == 0 || i > 3)
                    isDay = false
                DaylyItem(weatherData.time[i].substring(11),
                    isDay,
                    weatherData.temps[i],
                    weatherData.appTemps[i])
            }
        }
    }
}