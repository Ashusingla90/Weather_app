package com.example.weatherapp.presentation.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorScreen(message: String, onRetry: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "⚠️", fontSize = 64.sp
            )

            Text(
                text = "Oops!", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold
            )

            Text(
                text = message,
                color = Color.White.copy(0.9f),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = onRetry, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = Color(0xFF1E3A8A)
                ), modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "Search Again", fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}