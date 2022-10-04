package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastAdapter(private val data : List<DayForecast>) : RecyclerView.Adapter<ForecastViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}

class ForecastViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val dayForecastDate: TextView
    private val dayForecastCurrentTemp: TextView
    private val dayForecastHigh: TextView
    private val dayForecastLow: TextView
    private val dayForecastSunrise: TextView
    private val dayForecastSunset: TextView

    init{
        dayForecastDate = view.findViewById(R.id.forecast_date)
        dayForecastCurrentTemp = view.findViewById(R.id.forecast_current_temp)
        dayForecastHigh = view.findViewById(R.id.forecast_high)
        dayForecastLow = view.findViewById(R.id.forecast_low)
        dayForecastSunrise = view.findViewById(R.id.sunrise)
        dayForecastSunset = view.findViewById(R.id.sunset)
    }

    fun bind(data: DayForecast){
        dayForecastDate.text = dateFormatter(data.date)
        dayForecastSunrise.text = timeFormatter(data.sunrise)
        dayForecastSunset.text = timeFormatter(data.sunset)
        dayForecastLow.text = data.temp.min.toString()
        dayForecastHigh.text = data.temp.max.toString()
    }

    private fun dateFormatter(long: Long): String? {
        val formatter = DateTimeFormatter.ofPattern("MMM dd ")
        val dateTime = LocalDateTime.ofEpochSecond(long, 0, ZoneOffset.of("-5"))
        return formatter.format(dateTime)
    }

    private fun timeFormatter(long: Long): String? {
        val dateTime = LocalDateTime.ofEpochSecond(long, 0, ZoneOffset.of("-5"))
        val timeFormatter = DateTimeFormatter.ofPattern("h:mm")
        return timeFormatter.format(dateTime)
    }
}