package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.models.DayForecast
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
    //private val dayForecastCurrentTemp: TextView
    private val dayForecastHigh: TextView
    private val dayForecastLow: TextView
    private val dayForecastSunrise: TextView
    private val dayForecastSunset: TextView
    private val resources = view.resources

    init{
        dayForecastDate = view.findViewById(R.id.forecast_date)
        //dayForecastCurrentTemp = view.findViewById(R.id.forecast_current_temp)
        dayForecastHigh = view.findViewById(R.id.forecast_high)
        dayForecastLow = view.findViewById(R.id.forecast_low)
        dayForecastSunrise = view.findViewById(R.id.sunrise)
        dayForecastSunset = view.findViewById(R.id.sunset)
    }

    fun bind(data: DayForecast){
        // date doesn't have a place in strings.xml, should it???
        dayForecastDate.text = dateFormatter(data.date)
        dayForecastSunrise.text = resources.getString(R.string.forecast_item_sunrise, timeFormatter(data.sunrise))
        dayForecastSunset.text = resources.getString(R.string.forecast_item_sunset, timeFormatter(data.sunset))
        dayForecastHigh.text = resources.getString(R.string.forecast_item_high, data.temp.max)
        dayForecastLow.text = resources.getString(R.string.forecast_item_low, data.temp.min)
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