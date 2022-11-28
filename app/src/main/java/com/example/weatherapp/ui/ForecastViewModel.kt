package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.LatitudeLongitude
import com.example.weatherapp.service.OpenWeatherMapAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapAPI) : ViewModel(){
    private val _forecast = Channel<Forecast>()

    public val forecast: Flow<Forecast> = _forecast.receiveAsFlow()

    fun fetchData() = runBlocking {
        val forecast = api.getForecast("55431")
        _forecast.trySend(forecast)
    }

    fun fetchCurrentLocationData(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val forecast = api.getForecast(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _forecast.trySend(forecast)
    }
}