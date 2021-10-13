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
    DrawImageBackground()
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CityText(weather)
        Spacer(modifier = Modifier.height(50.dp))
        CurrentTemperature(weather)
        CurrentWeatherStatus(weather)
        Spacer(modifier = Modifier.height(50.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(weather.forecast) { message ->
                ForecastItem(message)
            }
        }
    }
}

@Composable
fun ForecastItem(forecast: WeatherForecast) {
    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp),
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.bgCard
    ) {
        Box(modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .fillMaxWidth()
        ) {
            Text(text = forecast.day)
            Image(
                contentDescription = null,
                painter = painterResource(id = forecast.status.weatherToImage()),
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth(),
                alignment = Alignment.Center
            )
            Text(text = forecast.temperature,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End)
        }
    }
}

@Composable
fun CurrentTemperature(weather: Weather) {
    Text(
        text = weather.currentTemperature,
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onPrimary,
    )
}

@Composable
fun CurrentWeatherStatus(weather: Weather) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = weather.currentStatus.weatherToImage()),
            contentDescription = null,
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
        )
        Text(
            text = weather.currentStatus.weatherToString(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(horizontal = 12.dp),
        )
    }
}

@Composable
fun CityText(weather: Weather) {
    Row(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = weather.city,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun DrawImageBackground() {
    Image(
        painter = painterResource(id = R.drawable.sunny),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )
}

@Preview(name = "Dark", device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Normal", device = Devices.NEXUS_5)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme() {
        HomeContainer(weather)
    }
}