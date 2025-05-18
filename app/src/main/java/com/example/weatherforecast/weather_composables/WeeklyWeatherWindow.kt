package com.example.weatherforecast.weather_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.R
import com.example.weatherforecast.enums.WT
import com.example.weatherforecast.functions.getWeather
import com.example.weatherforecast.serialized_data.DaysWeatherData
import com.example.weatherforecast.stBackColor
import com.example.weatherforecast.stButtonAcvatedColor
import com.example.weatherforecast.stFieldBorder
import com.example.weatherforecast.stFieldColor
import com.example.weatherforecast.stFieldShape
import com.example.weatherforecast.transparentButtonColors
import kotlin.math.roundToInt

@Composable
fun WeeklyWeatherWindow(modifier: Modifier = Modifier,
                        weatherData: DaysWeatherData = DaysWeatherData(),
                        onWeekButtonClick: () -> Unit = {},
                        onCurrentButtonClick: () -> Unit = {},
                        dayClickTemplate: (Int) -> Unit = {}) {
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
                    .background(color = stFieldColor, shape = stFieldShape)) {
                TextStandart("День")
            }

            Button(onClick = onWeekButtonClick,
                colors = transparentButtonColors,
                modifier = Modifier.width(200.dp)
                    .border(border = stFieldBorder, shape = stFieldShape)
                    .background(color = stButtonAcvatedColor, shape = stFieldShape)) {
                TextStandart("Неделя")
            }

        }

        Row(modifier = Modifier.horizontalScroll(ScrollState(0))) {
            for (i in 0..<weatherData.time.size) {

                val wt: WT = getWeather(precipitation = weatherData.precipitation_sum[i], is_day = true)

                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable { dayClickTemplate(i) }) {
                    Image(bitmap = ImageBitmap.imageResource(wt.icon),
                        contentDescription = "",
                        modifier = Modifier.width(100.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.width(400.dp)
                            .verticalScroll(ScrollState(0))) {
                        WeatherItem(icon = R.drawable.timee, text = weatherData.time[i])
                        WeatherItem(icon = R.drawable.temp, text = ((weatherData.temperature_2m_max[i] + weatherData.temperature_2m_min[i]) / 2).toString() + "°C")
                        WeatherItem(icon = R.drawable.day, text = weatherData.sunrise[i].toString())
                        WeatherItem(icon = R.drawable.night, text = weatherData.sunset[i].toString())
                    }
                }
            }
        }
    }
}