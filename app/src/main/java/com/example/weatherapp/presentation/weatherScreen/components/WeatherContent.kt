package com.example.weatherapp.presentation.weatherScreen.components

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.dto.getCurrentWeather.WeatherModel
import com.example.weatherapp.data.dto.getForecast.ForecastItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import java.util.Date
import java.util.Locale

@Composable
fun WeatherContent(weather: WeatherModel, forecast: List<ForecastItem>, onSearchClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 36.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column() {
                Text(
                    weather.name,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(weather.sys.country ?: "", color = Color.White.copy(0.8f), fontSize = 16.sp)
            }

            IconButton(
                onClick = onSearchClick,
                modifier = Modifier
                    .size(48.dp)
                    .background(color = Color.White.copy(0.2f))
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )

            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Current Date
        Text(getCurrentDate(), color = Color.White.copy(0.8f), fontSize = 14.sp)

        Spacer(modifier = Modifier.height(12.dp))

        // Main Weather Card
        MainWeatherCard(weather)

        Spacer(modifier = Modifier.height(12.dp))

        // Weather Grid
        WeatherDetailGrid(weather)

        Spacer(modifier = Modifier.height(24.dp))

        // Forecast
        if(forecast.isNotEmpty()){
            ForecastSection(forecast)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sun times
        SunTimeCard(weather)



    }
}


fun getCurrentDate(): String {
    val sdf = java.text.SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault())

    return sdf.format(Date())
}