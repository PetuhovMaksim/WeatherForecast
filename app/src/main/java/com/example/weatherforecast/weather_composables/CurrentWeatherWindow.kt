package com.example.weatherforecast.weather_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.R
import com.example.weatherforecast.enums.WT
import com.example.weatherforecast.functions.getWeather
import com.example.weatherforecast.serialized_data.CurrentWeatherData
import com.example.weatherforecast.stBackColor
import com.example.weatherforecast.stButtonAcvatedColor
import com.example.weatherforecast.stFieldBorder
import com.example.weatherforecast.stFieldColor
import com.example.weatherforecast.stFieldShape
import com.example.weatherforecast.transparentButtonColors

@Preview
@Composable
fun CurrentWeatherWindow(modifier: Modifier = Modifier,
                         weatherData: CurrentWeatherData = CurrentWeatherData(),
                         onCurrentButtonClick: () -> Unit = {},
                         onWeekButtonClick: () -> Unit = {}) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
            .background(color = stBackColor)) {

        Row(modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly) {

            Button(onClick = onCurrentButtonClick,
                colors = transparentButtonColors,
                modifier = Modifier.width(200.dp)
                    .border(border = stFieldBorder, shape = stFieldShape)
                    .background(color = stButtonAcvatedColor, shape = stFieldShape)) {
                TextStandart("День")
            }

            Button(onClick = onWeekButtonClick,
                colors = transparentButtonColors,
                modifier = Modifier.width(200.dp)
                    .border(border = stFieldBorder, shape = stFieldShape)
                    .background(color = stFieldColor, shape = stFieldShape)) {
                TextStandart("Неделя")
            }

        }

        val wt: WT = getWeather(precipitation = weatherData.precipitation, is_day = weatherData.is_day == 1)

        Image(bitmap = ImageBitmap.imageResource(wt.icon),
            contentDescription = "",
            modifier = Modifier.size(100.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(0.8f)
                .verticalScroll(ScrollState(0))) {
            WeatherItem(icon = R.drawable.time, text = weatherData.time)
            WeatherItem(icon = R.drawable.temp, text = weatherData.temperature_2m.toString() + "°C")

        }
    }
}