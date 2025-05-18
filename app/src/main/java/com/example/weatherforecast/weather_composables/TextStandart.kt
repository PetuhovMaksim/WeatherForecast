package com.example.weatherforecast.weather_composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.weatherforecast.stFontSize
import com.example.weatherforecast.stTextColor

@Composable
fun TextStandart(text: String,
                 modifier: Modifier = Modifier,
                 fontSize: TextUnit = stFontSize,
                 fontWeight: FontWeight = FontWeight.Bold,
                 color: Color = stTextColor
) {
    Text(text = text,
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color)
}