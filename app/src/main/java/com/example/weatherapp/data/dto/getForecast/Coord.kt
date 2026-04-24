package com.example.weatherapp.data.dto.getForecast
import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    val lat: Double,
    val lon: Double
)