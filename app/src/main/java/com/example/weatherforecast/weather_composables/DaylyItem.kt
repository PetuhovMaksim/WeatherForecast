package com.example.weatherforecast.weather_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.R
import com.example.weatherforecast.functions.getWeather

@Composable
fun DaylyItem(time: String,
              isDay: Boolean = true,
              temp: Float = 0f,
              precipitation: Float = 0f, ) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Image(bitmap = ImageBitmap.imageResource(getWeather(precipitation, isDay).icon),
            contentDescription = "",
            modifier = Modifier.size(100.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.width(200.dp)
                .verticalScroll(ScrollState(0))) {
            WeatherItem(icon = R.drawable.time, text = time)
            WeatherItem(icon = R.drawable.temp, text = temp.toString() + "°C")
        }
    }
}