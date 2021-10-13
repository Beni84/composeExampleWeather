package com.gigigo.composeexample.ui.composables

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gigigo.composeexample.MainViewModel
import com.gigigo.composeexample.weather.HomeScreen

@Composable
fun MainScreen() {
    //Add Scaffold
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    //Navigate to Composables
}


