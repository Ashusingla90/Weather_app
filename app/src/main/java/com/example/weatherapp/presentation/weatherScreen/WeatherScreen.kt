package com.example.weatherapp.presentation.weatherScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.presentation.WeatherUiState
import com.example.weatherapp.presentation.WeatherViewModel
import com.example.weatherapp.presentation.weatherScreen.components.ErrorScreen
import com.example.weatherapp.presentation.weatherScreen.components.LoadingScreen
import com.example.weatherapp.presentation.weatherScreen.components.SearchDialog
import com.example.weatherapp.presentation.weatherScreen.components.WeatherContent

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {

    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    var showSearchDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1E3A8A),
                        Color(0xFF3B82F6),
                        Color(0xFF60A5FA)
                    )
                )
            )
    ) {
        when (val state = uiState) {

            WeatherUiState.Loading -> {
                LoadingScreen()
            }

            is WeatherUiState.Success -> {
                WeatherContent(
                    weather = state.currentWeather, forecast = state.forecast,
                    onSearchClick = { showSearchDialog = true })
            }

            is WeatherUiState.Error -> {
                ErrorScreen(message = state.message) { showSearchDialog = true }
            }
        }

        if (showSearchDialog) {
            SearchDialog(
                currentQuery = searchQuery,
                onDismiss = { showSearchDialog = false },
                onSearch = { city ->
                    viewModel.updateSearchQuery(city)
                    viewModel.loadWeather(city)
                    showSearchDialog = false
                }
            )
        }
    }
}


//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun WeatherScreenPrev() {
//    WeatherScreen()
//}