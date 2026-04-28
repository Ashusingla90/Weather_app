package com.example.weatherapp.presentation.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.weatherapp.data.dto.getForecast.ForecastItem
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ForecastSection(forecast: List<ForecastItem>) {

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

        Text(
            "24-Hours Forecast", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

            items(forecast){item->

                ForecastCard(item)

            }

        }
    }

}

@Composable
fun ForecastCard(forecast: ForecastItem) {

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(140.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.15f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                getTimeFromTimestamp(forecast.dt),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = getWeatherEmoji(forecast.weather.firstOrNull()?.main ?: "clear"),
                fontSize = 36.sp
            )

            Text(
                text = "${forecast.main.temp.toInt()}°",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


fun getTimeFromTimestamp(timestamp: Long): String {

    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())

    return sdf.format(Date(timestamp * 1000))
}