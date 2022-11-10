package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastData
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonthDay
import dagger.hilt.android.lifecycle.HiltViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel()
) {
    val state by viewModel.forecast.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) {
        state?.let {
            LazyColumn {
                items(items = it.forecastList) { item: ForecastData ->
                    ForecastRow(forecast = it, item = item,)
                }
            }
        }
    }
}

@Composable
private fun ForecastRow(
    forecast: Forecast,
    item: ForecastData){
    Row (
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically
            ){
        val textStyle = TextStyle(
            fontSize = 16.sp
        )
        AsyncImage(
            model = String.format("https://openweathermap.org/img/wn/%s@2x.png", item.forecastWeatherData.firstOrNull()?.iconName),
            modifier = Modifier.size(72.dp),
            contentDescription = "Weather Image"
        )
        Spacer(modifier = Modifier.weight(.2f, fill = true))
        Text(text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column {
            Text(text = stringResource(id = R.string.high, item.temperature.maxTemperature.toInt()),
                style = textStyle
                )
            Text(text = stringResource(id = R.string.low, item.temperature.minTemperature.toInt()),
                style = textStyle
                )
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column (
            horizontalAlignment = Alignment.End
                ) {
            Text(text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle
                )
            Text(text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle)
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview(){
    //ForecastRow(item = forecastData[0])
}