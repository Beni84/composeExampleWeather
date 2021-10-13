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
    val viewModel = hiltViewModel<MainViewModel>()
    val state = viewModel.state.observeAsState()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val context = LocalContext.current

    state.value?.message?.let {
        LaunchedEffect(scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar(
                message = "Error message",
                actionLabel = "Retry message"
            )
        }

//        LaunchedEffect(scaffoldState.snackbarHostState) {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:617 32 31 23"))
//            startActivity(context, intent, null)
//        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppTopBar(
                onClickPhone = { viewModel.onClickPhone() }
            )
        },
        bottomBar = { MainBottomBar(navController) }
    ) {
        MainScreenNavigationConfigurations(navController = navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = TAB_HOME) {
        composable(TAB_HOME) {
            HomeScreen()
        }
        composable(TAB_OTHERS) {
            SecondScreen()
        }
    }
}


@Composable
fun SecondScreen() {
    SecondScreen(onNavigate = {})
}


