package com.example.weatherapp.presentation.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.dto.getCurrentWeather.WeatherModel

@Composable
fun WeatherDetailGrid(weather: WeatherModel) {

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            WeatherDetailCard(
                icon = "💨",
                label = "Wind Speed",
                value = "${weather.wind.speed}",
                modifier = Modifier.weight(1f)
            )


            WeatherDetailCard(
                icon = "💧",
                label = "Humidity",
                value = "${weather.main.humidity}%",
                modifier = Modifier.weight(1f)

            )


        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            WeatherDetailCard(
                icon = " 🌡️ ",
                label = "Pressure",
                value = "${weather.main.pressure}",
                modifier = Modifier.weight(1f)
            )


            WeatherDetailCard(
                icon = " 👁️",
                label = "Visibility",
                value = "${weather.visibility / 1000} km",
                modifier = Modifier.weight(1f)

            )
        }

    }
}

@Composable
fun WeatherDetailCard(icon: String, label: String, value: String, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.height(120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.15f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = icon, fontSize = 28.sp)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Text(
                    text = label,
                    color = Color.White.copy(0.7f),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = value,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

        }
    }

}