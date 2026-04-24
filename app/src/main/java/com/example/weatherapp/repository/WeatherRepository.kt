package com.example.weatherapp.repository

import com.example.weatherapp.data.dto.getCurrentWeather.WeatherModel
import com.example.weatherapp.data.dto.getForecast.City
import com.example.weatherapp.data.dto.getForecast.ForecastModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherRepository {

    private val client = HttpClient(CIO){

        install(ContentNegotiation){

            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                prettyPrint = true
            })
        }

        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
    }

    private val apiKey = "1c9bf7f5370f0d02db27ae6895950067"
    private val baseUrl = "https://api.openweathermap.org/data/2.5"

    suspend fun getCurrentWeather(city: String): Result<WeatherModel>{
        return try {
            val response = client.get("$baseUrl/weather"){
                parameter("q", city)
                parameter("appid", apiKey)
                parameter("units", "metric")
            }
            Result.success(response.body())
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun getForecast(city: String): Result<ForecastModel>{

        return try {

            val response = client.get("$baseUrl/forecast"){
                parameter("q", city)
                parameter("appid", apiKey)
                parameter("units", "metric")
            }
            Result.success(response.body())
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    fun close() {
        client.close()
    }
}