//package com.example.weatherapp
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import javax.inject.Inject
//
//class MainViewModel @Inject constructor(
//    private val currentConditions: CurrentConditionsFragment,
//) : ViewModel(){
//
//    private val _viewState = MutableLiveData<CurrentConditionsFragment>()
//
//    val viewState: LiveData<CurrentConditionsFragment> = _viewState
//}