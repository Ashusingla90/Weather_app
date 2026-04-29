package com.example.weatherapp.presentation.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.dto.getCurrentWeather.WeatherModel
import com.example.weatherapp.data.dto.getForecast.Weather

@Composable
fun MainWeatherCard(weather: WeatherModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.15f))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Weather icon
            Text(
                getWeatherEmoji(weather.weather.firstOrNull()?.main ?: "clear"),
                fontSize = 80.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "${weather.main.temp.toInt()}°",
                color = Color.White,
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

// helper fun emoji
fun getWeatherEmoji(condition: String): String {

    return when (condition.lowercase()) {
        "clear" -> "☀"
        "clouds" -> "☁️"
        "rain" -> "🌧"
        "drizzle" -> "🌦"
        "thunderstorm" -> "⛈️"
        "snow" -> "🌨"
        "mist", "fog", "haze" -> "🌫"
        else -> "🌤"
    }
}