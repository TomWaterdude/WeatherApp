package com.example.weatherapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.databinding.FragmentForecastBinding
import com.example.weatherapp.models.DayForecast
import com.example.weatherapp.models.ForecastTemp

private val forecastData = listOf(

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

class ForecastFragment : Fragment(R.layout.fragment_forecast){

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)
        getActivity()?.setTitle("Forecast")
        //requireActivity().title = "Forecast"

    }
}