package com.example.weatherforecast.weather_composables

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherforecast.WeatherViewModel
import com.example.weatherforecast.api.InfoGetter
import com.example.weatherforecast.enums.Targets
import com.example.weatherforecast.serialized_data.CityData
import com.example.weatherforecast.serialized_data.HourlyData
import com.example.weatherforecast.serialized_data.WeatherData
import com.example.weatherforecast.stBackColor
import com.example.weatherforecast.stFieldBorder
import com.example.weatherforecast.stFieldColor
import com.example.weatherforecast.stFieldShape

@SuppressLint("DefaultLocale")
@Composable
fun App(viewModel: WeatherViewModel = viewModel(),
        navController: NavHostController = rememberNavController()
) {
    val isVertical: Boolean = LocalConfiguration.current.orientation === Configuration.ORIENTATION_PORTRAIT

    var param by rememberSaveable { mutableStateOf<String>("Izhevsk") }
    var messageOfError by rememberSaveable { mutableStateOf<String>("") }
    val uiState by viewModel.uiState.collectAsState()
    val infoGetter = InfoGetter()
    infoGetter.weatherOnResponse = {
            wd: WeatherData -> viewModel.setWeatherData(wd)
        navController.navigate(route = Targets.CurrentWeather.name)
    }
    infoGetter.weatherOnFailure = {
        navController.navigate(Targets.Greetings.name)
        messageOfError = "Ошибка получения прогноза"
    }
    infoGetter.cityOnResponse = { cd: CityData -> viewModel.setCityData(cd)
        navController.navigate(Targets.WeatherWaiter.name)}
    infoGetter.cityOnFailure = {
        navController.navigate(Targets.Greetings.name)
        messageOfError = "Ошибка при поиске города"
    }

    NavHost(navController = navController,
        startDestination = Targets.Greetings.name) {

        composable(route = Targets.Greetings.name) {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = stBackColor)
                .padding(30.dp),
                contentAlignment = Alignment.Center) {
                Greetings(basic = param,
                    errorMessage = messageOfError,
                    modifier = Modifier
                        .background(color = stFieldColor, shape = stFieldShape)
                        .border(border = stFieldBorder, shape = stFieldShape)
                        .fillMaxHeight(0.8f),
                    onTextChange = { s: String -> param = s },
                    onButtonClick = {
                        infoGetter.tryGetCityInfo(name = param)
                    })
            }

        }

        composable(route = Targets.WeatherWaiter.name) {
            var fetched: Boolean by rememberSaveable { mutableStateOf<Boolean>(false) }

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = stBackColor)
                    .padding(20.dp)) {

                Column(modifier = Modifier
                    .fillMaxHeight(0.65f)
                    .fillMaxWidth()
                    .background(color = stFieldColor, shape = stFieldShape)
                    .border(border = stFieldBorder, shape = stFieldShape),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    TextStandart(text = "Пытаемся получить")
                    TextStandart(text = "данные о погоде...")
                    TextStandart(text = String.format("Название города: %s", uiState.cityData.name))
                    TextStandart(text = String.format("Широта: %f", uiState.cityData.latitude))
                    TextStandart(text = String.format("Долгота: %f", uiState.cityData.longitude))
                }
            }

            if (!fetched) {
                infoGetter.tryGetWeatherInfo(latitude = uiState.cityData.latitude,
                    longitude = uiState.cityData.longitude)
                fetched = true
            }


        }

        composable(route = Targets.CurrentWeather.name) {

            CurrentWeatherWindow(weatherData = uiState.weatherData.current,
                onWeekButtonClick = { navController.navigate(Targets.Weekly.name) })

        }

        composable(route = Targets.Weekly.name) {

            WeeklyWeatherWindow(weatherData = uiState.weatherData.daily,
                onCurrentButtonClick = { navController.navigate(Targets.CurrentWeather.name) },
                dayClickTemplate = { id: Int -> run {
                    viewModel.setCurrentDay(id)
                    navController.navigate(Targets.Dayly.name)
                } })

        }

        composable(route = Targets.Dayly.name) {

            val hourly: HourlyData = HourlyData(dayId = uiState.currentDayId,
                hoursData = uiState.weatherData.hourly)

            DaylyWeatherWindow(hourly)
        }

    }
}