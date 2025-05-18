package com.example.weatherforecast.weather_composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.stFieldBorder
import com.example.weatherforecast.stFieldColor
import com.example.weatherforecast.stFieldShape

@Composable
fun WeatherItem(icon: Int, text: String, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
            .padding(5.dp)
            .border(border = stFieldBorder, shape = stFieldShape)
            .background(color = stFieldColor, shape = stFieldShape)) {

        Image(
            ImageBitmap.imageResource(icon),
            contentDescription = "",
            modifier = Modifier.size(80.dp)
                .border(border = stFieldBorder, shape = stFieldShape)
                .background(color = stFieldColor, shape = stFieldShape)
                .clip(shape = stFieldShape))

        TextStandart(text = text, Modifier.padding(start = 10.dp))

    }
}