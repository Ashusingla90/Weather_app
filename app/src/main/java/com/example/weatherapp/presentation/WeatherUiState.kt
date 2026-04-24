package com.example.weatherapp.presentation

import com.example.weatherapp.data.dto.getCurrentWeather.WeatherModel
import com.example.weatherapp.data.dto.getForecast.ForecastItem

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(
        val currentWeather: WeatherModel,
        val forecast: List<ForecastItem> = emptyList()
    ) : WeatherUiState()

    data class Error(val message: String) : WeatherUiState()
}
