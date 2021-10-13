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
private fun currentRoute(navController: NavHostController): String? {
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.destination?.route
  return currentRoute
}

@Composable
fun MainBottomBar(navController: NavHostController) {
  val stateTab = remember { mutableStateOf(TAB_HOME) }
//  val stateTab by remember { mutableStateOf(TAB_HOME) }

  val currentRoute = currentRoute(navController)

  BottomAppBar(
    elevation = 8.dp,
    backgroundColor = MaterialTheme.colors.primary
  ) {
    BottomBarItem(
      selected = currentRoute == TAB_HOME,
      text = stringResource(R.string.menu_home),
      icon = Icons.Default.Home
    ) { navController.navigate(TAB_HOME) }
    BottomBarItem(
      selected = currentRoute == TAB_OTHERS,
      text = stringResource(R.string.menu_others),
      icon = Icons.Default.Add
    ) { navController.navigate(TAB_OTHERS) }
  }
}

@Composable
private fun RowScope.BottomBarItem(
  selected: Boolean = false,
  text: String,
  icon: ImageVector,
  onClick: () -> Unit
) {
  BottomNavigationItem(
    selected = selected,
    onClick = { onClick() },
    selectedContentColor = Color.White,
    unselectedContentColor = Color.White.copy(0.4f),
    icon = {
      Icon(icon, contentDescription = null)
    },
    label = { Text(text) }
  )
}