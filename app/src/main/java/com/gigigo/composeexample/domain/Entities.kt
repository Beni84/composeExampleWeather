package com.gigigo.composeexample.domain

import com.gigigo.composeexample.R

data class Weather(
    val city: String,
    val currentTemperature: String,
    val currentStatus: WeatherState,
    val forecast: List<WeatherForecast>
)

class WeatherForecast(
    val day: String,
    val temperature: String,
    val status: WeatherState
)

enum class WeatherState {
    Sunny,
    PartlyCloudy,
    Cloudy,
    Rainy,
    Storm,
    Snowy,
}

fun WeatherState.weatherToString() =
    when (this) {
        WeatherState.Sunny -> "Soleado"
        WeatherState.PartlyCloudy -> "Parcialmente Soleado"
        WeatherState.Cloudy -> "Nublado"
        WeatherState.Rainy -> "Lluvia"
        WeatherState.Storm -> "Tormenta"
        WeatherState.Snowy -> "Nieve"
    }

fun WeatherState.weatherToImage() =
    when (this) {
        WeatherState.Sunny -> R.drawable.ic_weather_1_sunny
        WeatherState.PartlyCloudy -> R.drawable.ic_weather_2_partly_sunny
        WeatherState.Cloudy -> R.drawable.ic_weather_3_cloudy
        WeatherState.Rainy -> R.drawable.ic_weather_5_rain
        WeatherState.Storm -> R.drawable.ic_weather_6_storm
        WeatherState.Snowy -> R.drawable.ic_weather_7_snow
    }

val weather = Weather(
    city = "Madrid",
    currentTemperature = "21.0º",
    currentStatus = WeatherState.Sunny,
    forecast = listOf(
        WeatherForecast(
            day = "VIE",
            temperature = "25.0º",
            status = WeatherState.Sunny
        ),
        WeatherForecast(
            day = "SAB",
            temperature = "23.0º",
            status = WeatherState.PartlyCloudy
        ),
        WeatherForecast(
            day = "DOM",
            temperature = "21.0º",
            status = WeatherState.Cloudy
        ),
        WeatherForecast(
            day = "LUN",
            temperature = "21.0º",
            status = WeatherState.Cloudy
        ),
        WeatherForecast(
            day = "MAR",
            temperature = "9.0º",
            status = WeatherState.Rainy
        ),
        WeatherForecast(
            day = "MIE",
            temperature = "6.0º",
            status = WeatherState.Storm
        ),
        WeatherForecast(
            day = "JUE",
            temperature = "-10.0º",
            status = WeatherState.Snowy
        )
    )
)
