package com.gigigo.composeexample.ui.composables

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gigigo.composeexample.R

@Composable
fun AppTopBar(onClickPhone: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 8.dp,
        actions = {
            IconButton(onClick = { onClickPhone() }) {
                Icon(Icons.Default.Phone, contentDescription = null)
            }
        }
    )
}