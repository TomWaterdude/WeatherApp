package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.models.DayForecast
import com.example.weatherapp.models.ForecastTemp
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonthDay

val forecastData = listOf(
    DayForecast(1664275500L, 1664275500L,  1664335680L, ForecastTemp(65F,77F), 1050F, 58),
    DayForecast(1664361960L, 1664361960L,  1664414820L, ForecastTemp(65F,77F), 1048F, 62),
    DayForecast(1664452080L, 1664452080L,  1664501100L, ForecastTemp(64F,76F), 1046F, 63),
    DayForecast(1664538600L, 1664538600L,  1664594880L, ForecastTemp(64F,76F), 1048F, 65),
    DayForecast(1664621100L, 1664621100L,  1664681280L, ForecastTemp(63F,77F), 1049F, 67),
    DayForecast(1664711700L, 1664711700L,  1664767680L, ForecastTemp(63F,78F), 1047F, 59),
    DayForecast(1664798220L, 1664798220L,  1664846160L, ForecastTemp(62F,76F), 1046F, 58),
    DayForecast(1664884800L, 1664884800L,  1664932500L, ForecastTemp(62F,75F), 1050F, 57),
    DayForecast(1664971500L, 1664971500L,  1665018780L, ForecastTemp(61F,74F), 1047F, 55),
    DayForecast(1665058140L, 1665058140L,  1665105060L, ForecastTemp(61F,73F), 1045F, 62),
    DayForecast(1665144780L, 1665144780L,  1665191400L, ForecastTemp(60F,75F), 1043F, 66),
    DayForecast(1665231240L, 1665231240L,  1665277680L, ForecastTemp(60F,73F), 1049F, 63),
    DayForecast(1665317700L, 1665317700L,  1665364020L, ForecastTemp(61F,72F), 1051F, 65),
    DayForecast(1665404160L, 1665404160L,  1665450300L, ForecastTemp(61F,71F), 1043F, 64),
    DayForecast(1665490800L, 1665490800L,  1665545280L, ForecastTemp(62F,71F), 1032F, 66),
    DayForecast(1665490800L, 1665490800L,  1665631680L, ForecastTemp(62F,73F), 1059F, 63),
)

// Original ForecastScreen
//@Composable
//fun ForecastScreen(){
//    LazyColumn{
//        items(items = forecastData){ item: DayForecast ->
//            ForecastRow(item = item)
//        }
//    }
//}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text(text = stringResource(id = R.string.app_name))}
            )
         }
    ) { contentPadding ->
        Modifier.padding(contentPadding)
        LazyColumn{
            items(items = forecastData){ item: DayForecast ->
                ForecastRow(item = item)
            }
        }
    }
}


//@Composable
//private fun ForecastScreenContent(item: DayForecast){
//    Row (
//        modifier = Modifier.background(Color.White),
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        val textStyle = TextStyle(
//            fontSize = 16.sp
//        )
//        Image(
//            modifier = Modifier.size(60.dp),
//            painter = painterResource(id = R.drawable.sun_icon),
//            contentDescription = "Sunny")
//        Spacer(modifier = Modifier.weight(.2f, fill = true))
//        Text(text = item.date.toMonthDay(),
//            style = TextStyle(
//                fontSize = 20.sp
//            )
//        ) // different way of doing it? instead of stringResource
//        Spacer(modifier = Modifier.weight(1f, fill = true))
//        Column {
//            Text(text = stringResource(id = R.string.high, item.temp.max.toInt()),
//                style = textStyle
//            )
//            Text(text = stringResource(id = R.string.low, item.temp.min.toInt()),
//                style = textStyle
//            )
//        }
//        Spacer(modifier = Modifier.weight(1f, fill = true))
//        Column (
//            horizontalAlignment = Alignment.End
//        ) {
//            Text(text = stringResource(id = R.string.forecast_item_sunrise, item.sunrise.toHourMinute()),
//                style = textStyle
//            )
//            Text(text = stringResource(id = R.string.forecast_item_sunset, item.sunset.toHourMinute()),
//                style = textStyle)
//        }
//    }
//}


@Composable
private fun ForecastRow(item: DayForecast){
    Row (
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically
            ){
        val textStyle = TextStyle(
            fontSize = 16.sp
        )
        Image(
            modifier = Modifier.size(60.dp),
            painter = painterResource(id = R.drawable.sun_icon),
            contentDescription = "Sunny")
        Spacer(modifier = Modifier.weight(.2f, fill = true))
        Text(text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 20.sp
            )
        ) // different way of doing it? instead of stringResource
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column {
            Text(text = stringResource(id = R.string.high, item.temp.max.toInt()),
                style = textStyle
                )
            Text(text = stringResource(id = R.string.low, item.temp.min.toInt()),
                style = textStyle
                )
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column (
            horizontalAlignment = Alignment.End
                ) {
            Text(text = stringResource(id = R.string.forecast_item_sunrise, item.sunrise.toHourMinute()),
                style = textStyle
                )
            Text(text = stringResource(id = R.string.forecast_item_sunset, item.sunset.toHourMinute()),
                style = textStyle)
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview(){
    ForecastRow(item = forecastData[0])
}