package com.gigigo.composeexample.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gigigo.composeexample.R

const val TAB_HOME = "Home"
const val TAB_OTHERS = "Others"

@Composable
fun MainBottomBar(navController: NavHostController) {

}

@Composable
private fun RowScope.BottomBarItem(
  selected: Boolean = false,
  text: String,
  icon: ImageVector,
  onClick: () -> Unit
) {

}

@Composable
private fun currentRoute(navController: NavHostController): String? {
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.destination?.route
  return currentRoute
}