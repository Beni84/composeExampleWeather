package com.gigigo.composeexample.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.compose.rememberNavController
import com.gigigo.composeexample.databinding.CustomViewBinding
import com.gigigo.composeexample.databinding.FragmentFirstBinding
import com.gigigo.composeexample.databinding.FragmentSecondBinding

import com.gigigo.composeexample.R as R

@Composable
fun CustomViewScreen(onNavigate: (Int) -> Unit) {
    //Custom view with Compose
}

@Composable
fun SecondScreen(onNavigate: (Int) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val navController = rememberNavController()

        Text(text = "Este es el segundo fragmento",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(64.dp))
        Button(
            onClick = {
                onNavigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        ) {
            Text("Volver")
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen(onNavigate = {})
}