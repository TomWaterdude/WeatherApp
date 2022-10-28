package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    onForecastButtonClick : () -> Unit,
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) }
            )
        }
    ) { contentPadding ->
        Modifier.padding(contentPadding)
        CurrentConditionsContent(
        ) {
            onForecastButtonClick()
        }
    }
}

@Composable
private fun CurrentConditionsContent(
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
                    text = stringResource(id = R.string.current_temp, 75),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 72.sp
                    )
                )
                Text(
                    text = stringResource(id = R.string.feels_like, 73),
                    style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f, true))
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.sun_icon),
                contentDescription = "Sunny")
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
            Text(text = stringResource(id = R.string.high, 81), style = textStyle)
            Text(text = stringResource(id = R.string.low, 69), style = textStyle)
            Text(text = stringResource(id = R.string.humidity, 56), style = textStyle)
            Text(text = stringResource(id = R.string.pressure, 1234), style = textStyle)
        }
        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick,
            modifier = Modifier.height(50.dp).width(140.dp),
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