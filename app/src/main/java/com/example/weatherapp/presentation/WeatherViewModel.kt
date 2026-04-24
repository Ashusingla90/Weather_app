package com.example.weatherapp.presentation

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository = WeatherRepository()) :
    ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState

    private val _searchQuery = MutableStateFlow("Delhi")
    val searchQuery = _searchQuery.asStateFlow()


    fun loadWeather(city: String) {
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading

            val weatherResult = repository.getCurrentWeather(city)

            weatherResult.fold(
                onSuccess = { weather ->

                    // Load Forecast
                    val forecastResult = repository.getForecast(city)

                    forecastResult.fold(onSuccess = { forecasts ->

                        _uiState.value = WeatherUiState.Success(
                            currentWeather = weather, forecast = forecasts.list.take(n = 8)
                        )
                    }, onFailure = {
                        _uiState.value = WeatherUiState.Success(
                            currentWeather = weather, forecast = emptyList()
                        )
                    })
                },

                onFailure = { error ->
                    _uiState.value = WeatherUiState.Error(
                        error.message ?: "Failed to load data."
                    )
                })
        }
    }


    // Update search query
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }


    // refresh function
    fun refresh() {
        loadWeather(_searchQuery.value)
    }

    override fun onCleared() {
        super.onCleared()
        repository.close()
    }


}