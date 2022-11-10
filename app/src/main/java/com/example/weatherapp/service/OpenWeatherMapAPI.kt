package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapAPI {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "192ed6c5b9045692e7c6a357b68b89fc",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip:String,
        @Query("appid") apiKey: String = "192ed6c5b9045692e7c6a357b68b89fc",
        @Query("cnt") cnt: Int = 16,
        @Query("units") units: String = "imperial",
    ) : Forecast
}