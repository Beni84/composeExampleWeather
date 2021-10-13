package com.gigigo.composeexample.weather

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gigigo.composeexample.R
import com.gigigo.composeexample.domain.*
import com.gigigo.composeexample.ui.theme.AlphaBlack
import com.gigigo.composeexample.ui.theme.AlphaWhite
import com.gigigo.composeexample.ui.theme.ComposeExampleTheme

private val Colors.bgCard: Color
    get() = if (isLight) AlphaBlack else AlphaWhite



@Composable
fun HomeScreen() {
    HomeContainer(weather)
}

@Composable
fun HomeContainer(weather: Weather) {

}

@Composable
fun ForecastItem(forecast: WeatherForecast) {
    //Card
}

@Composable
fun CurrentTemperature(weather: Weather) {
    //Add composable text temperature
}

@Composable
fun CurrentWeatherStatus(weather: Weather) {
    // Row with image and text status
}

@Composable
fun DrawImageBackground() {
    // Add background image
}

//Add preview