package com.example.weatherapp.data.dto.getCurrentWeather
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    val country: String,
    val sunrise: Long,
    val sunset: Long
)