package com.example.themming.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.themming.ui.theme.*

private val PinkDarkColorPalette = darkColors(
    primary = pink500,
    secondary = yellow200,
    primaryVariant = pink600,
    onPrimary = Color.White,
    surface = pinkDarkPrimary
)

private val PinkLightColorPalette = lightColors(
    primary = pink200,
    primaryVariant = pink500,
    surface = pinkLightPrimary
)

@Composable
fun PinkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    JetpackComposeMaterialTheme(
        lightColorPalette = PinkLightColorPalette,
        darkColorPalette = PinkDarkColorPalette,
        darkTheme = darkTheme,
        content = content
    )
}

@Composable
fun JetpackComposeMaterialTheme(
    lightColorPalette: Colors,
    darkColorPalette: Colors,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }
    CompositionLocalProvider(
        LocalPaddings provides Paddings(),
        LocalElevations provides Elevations(card = 8.dp)
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object JetpackComposeMaterialTheme {
    /**
     * Proxy to [MaterialTheme]
     */
    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    /**
     * Proxy to [MaterialTheme]
     */
    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    /**
     * Proxy to [MaterialTheme]
     */
    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    /**
     * Retrieves the current [Paddings].
     */
    val paddings: Paddings
        @Composable
        get() = LocalPaddings.current

    /**
     * Retrieves the current [Paddings].
     */
    val elevations: Elevations
        @Composable
        get() = LocalElevations.current

}

