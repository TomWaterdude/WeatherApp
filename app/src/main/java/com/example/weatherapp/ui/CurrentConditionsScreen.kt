package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.CurrentConditions

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    viewModel: CurrentConditionsViewModel = hiltViewModel(),
    onForecastButtonClick : () -> Unit,

){
    val state by viewModel.currentConditions.collectAsState(initial = null)

    LaunchedEffect(Unit){
        viewModel.fetchData()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) {
        state?.let{
            CurrentConditionsContent (it){
                onForecastButtonClick()
            }
        }
    }
}

@Composable
private fun CurrentConditionsContent(
    currentConditions: CurrentConditions,
    onForecastButtonClick: () -> Unit
){
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.city_name),
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.temperature, currentConditions.conditions.temperature.toInt()),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 72.sp
                    )
                )
                Text(
                    text = stringResource(id = R.string.feels_like, currentConditions.conditions.feelsLike.toInt()),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f, true))
            AsyncImage(
                model = String.format("https://openweathermap.org/img/wn/%s@2x.png", currentConditions.weatherData.firstOrNull()?.iconName),
                modifier = Modifier.size(72.dp),
                contentDescription = "Weather Image")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            val textStyle = TextStyle(
                fontSize = 16.sp
            )
            Text(text = stringResource(id = R.string.high, currentConditions.conditions.maxTemperature.toInt()), style = textStyle)
            Text(text = stringResource(id = R.string.low, currentConditions.conditions.minTemperature.toInt()), style = textStyle)
            Text(text = stringResource(id = R.string.humidity, currentConditions.conditions.humidity.toInt()), style = textStyle)
            Text(text = stringResource(id = R.string.pressure, currentConditions.conditions.pressure.toInt()), style = textStyle)
        }
        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick,
            modifier = Modifier
                .height(50.dp)
                .width(140.dp),
        ){
            Text(
                text = stringResource(id = R.string.forecast),
                style = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
    }
}

@Preview(
    device = Devices.PIXEL_4,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CurrentConditionsPreview(){
    CurrentConditions{}
}