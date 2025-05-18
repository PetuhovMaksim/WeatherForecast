package com.example.weatherforecast.functions

import com.example.weatherforecast.enums.WT

fun getWeather(precipitation: Float, is_day: Boolean): WT {
    val wt: WT
    if (is_day) {
        if (precipitation >= 0.2f)
            wt = WT.DayRain
        else
            wt = WT.Day
    }
    else {
        if (precipitation >= 0.2f)
            wt = WT.NightRain
        else
            wt = WT.Night
    }
    return wt
}