package com.example.weatherapp.presentation.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

@Composable
fun SunTimeCard(weather: WeatherModel, modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.15f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "🌅",
                    fontSize = 40.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sunrise",
                    color = Color.White.copy(0.7f),
                    fontSize = 14.sp
                )

                Text(
                    text = getTimeFromTimestamp(weather.sys.sunrise),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold

                )
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "🌆",
                    fontSize = 40.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sunset",
                    color = Color.White.copy(0.7f),
                    fontSize = 14.sp
                )

                Text(
                    text = getTimeFromTimestamp(weather.sys.sunset),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold

                )
            }

        }
    }
}