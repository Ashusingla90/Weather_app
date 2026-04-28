package com.example.weatherapp.presentation.weatherScreen.components

import android.app.AlertDialog
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchDialog(
    modifier: Modifier = Modifier,
    currentQuery: String,
    onDismiss: () -> Unit,
    onSearch: (String) -> Unit
) {

    var searchText by remember { mutableStateOf(currentQuery) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {

            Button(
                onClick = {
                    if (searchText.isNotBlank()) {
                        onSearch(searchText)
                        onDismiss()
                    }
                }, colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF3B82F6))
            ) {
                Text("Search", color = Color.White)

            }
        },

        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        },

        title = {
            Text(
                text = "Search City",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E3A8A)
            )

        },

        text = {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("City Name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF3B82F6),
                    focusedLabelColor = Color(0xFF3B82F6)
                )
            )
        },

        containerColor = Color.White,
        shape = RoundedCornerShape(24.dp)


    )

}