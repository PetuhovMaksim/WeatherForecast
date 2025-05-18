package com.example.weatherforecast.serialized_data

class HourlyData() {
    var time: MutableList<String> = mutableListOf()
    var temps: MutableList<Float> = mutableListOf()
    var appTemps: MutableList<Float> = mutableListOf()
    var precipitations: MutableList<Float> = mutableListOf()
    var rains: MutableList<Float> = mutableListOf()
    var showers: MutableList<Float> = mutableListOf()
    var snowfalls: MutableList<Float> = mutableListOf()
    val humidities: MutableList<Float> = mutableListOf()

    constructor(dayId: Int, hoursData: HoursWeatherData): this() {
        if (dayId > 6)
            throw Exception("Too Much")
        val startingIndex = dayId * 24
        for (i in 0..5) {
            time.add(hoursData.time[startingIndex + i * 4])
            temps.add(0f)
            appTemps.add(0f)
            precipitations.add(0f)
            rains.add(0f)
            showers.add(0f)
            snowfalls.add(0f)
            humidities.add(0f)
            for (j in (startingIndex + i * 4)..<(startingIndex + i * 4 + 4)) {
                if (hoursData.temperature_2m[j] > temps[i])
                    temps[i] = hoursData.temperature_2m[j]
                if (hoursData.apparent_temperature[j] > appTemps[i])
                    appTemps[i] = hoursData.apparent_temperature[j]
                if (hoursData.precipitation[j] > precipitations[i])
                    precipitations[i] = hoursData.precipitation[j]
                if (hoursData.rain[j] > rains[i])
                    rains[i] = hoursData.rain[j]
                if (hoursData.showers[j] > showers[i])
                    showers[i] = hoursData.showers[j]
                if (hoursData.snowfall[j] > snowfalls[i])
                    snowfalls[i] = hoursData.snowfall[j]
                if (hoursData.relative_humidity_2m[j] > humidities[i])
                    humidities[i] = hoursData.relative_humidity_2m[j]
            }

        }
    }
}
