package com.example.weatherforecast.weather_composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecast.stButtonColors
import com.example.weatherforecast.stFontSize

@Composable
fun Greetings(modifier: Modifier = Modifier,
              basic: String = "Izhevsk",
              errorMessage: String = "",
              onTextChange: (String) -> Unit = { s: String -> {} },
              onButtonClick: () -> Unit = {}) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextStandart("Добрый", fontSize = 36.sp)
            TextStandart("День", fontSize = 36.sp)
            TextStandart(errorMessage, color = Color(255, 100, 100))
        }

        TextStandart("Введите город:")
        TextField(value = basic, onValueChange = onTextChange,
            modifier = Modifier.padding(5.dp))
        Button(onClick = onButtonClick,
            colors = stButtonColors
        ) {
            Text("Начать", fontSize = stFontSize)
        }

    }
}