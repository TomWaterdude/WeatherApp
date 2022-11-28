package com.example.weatherapp.models

import com.squareup.moshi.Json

data class ForecastWeatherData(
    @Json(name = "icon") val iconName: String,
    @Json(name = "main") val main: String,
)

data class ForecastTempData(
    @Json(name = "min") val minTemperature: Float,
    @Json(name = "max") val maxTemperature: Float,
)

data class ForecastData(
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val temperature: ForecastTempData,
    @Json(name = "pressure") val pressure: Float,
    @Json(name = "humidity") val humidity: Int,
    @Json(name= "weather") val forecastWeatherData: List<ForecastWeatherData>
)

data class Forecast(
    @Json(name = "list") val forecastList: List<ForecastData>,
)

