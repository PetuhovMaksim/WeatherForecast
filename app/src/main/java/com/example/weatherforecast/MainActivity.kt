package com.example.weatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecast.ui.theme.WeatherForecastTheme
import com.example.weatherforecast.weather_composables.App

const val url: String = "https://api.open-meteo.com/v1/forecast?latitude=59.94&longitude=30.31&daily=temperature_2m_max,temperature_2m_min,apparent_temperature_min,apparent_temperature_max,sunrise,sunset&hourly=temperature_2m,apparent_temperature,precipitation&current=temperature_2m,relative_humidity_2m,apparent_temperature,is_day,precipitation,rain,showers,snowfall&timezone=Europe%2FMoscow&past_days=1"

val stButtonColors: ButtonColors = ButtonColors(Color.White, Color.Blue, Color.LightGray, Color.Blue)
val transparentButtonColors: ButtonColors = ButtonColors(Color.Transparent, Color.Transparent, Color.Transparent, Color.Blue)
val stFontSize: TextUnit = 20.sp
val stTextColor: Color = Color(red = 0, green = 0, blue = 100)
val stBackColor: Color = Color(red = 0, green = 200, blue = 0)
val stButtonAcvatedColor: Color = Color(red = 133, green = 137, blue = 173, alpha = 255)
val stFieldShape: RoundedCornerShape = RoundedCornerShape(20.dp)
val stFieldColor: Color = Color(red = 255, green = 255, blue = 255, alpha = 255)
val stFieldBorder: BorderStroke = BorderStroke(2.dp, Color(red = 0, blue = 200, green = 0))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherForecastTheme {
                App()
            }
        }
    }
}