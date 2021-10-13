package com.gigigo.composeexample.old

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AbstractComposeView
import com.gigigo.composeexample.domain.weather
import com.gigigo.composeexample.ui.theme.ComposeExampleTheme
import com.gigigo.composeexample.weather.HomeContainer

class CallToActionViewButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    @Composable
    override fun Content() {
        ComposeExampleTheme() {
            HomeContainer(weather)
        }
    }
}
