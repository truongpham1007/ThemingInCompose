package com.example.themming.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.jetpackcomposematerial.ui.theme.attr.CustomSize
import com.example.jetpackcomposematerial.ui.theme.attr.CustomTypography
import com.example.themming.ui.theme.Elevations
import com.example.themming.ui.theme.Paddings

@Composable
fun AppTheme(
    colors: AppColorPalette = CustomLightColorPalette(),
    typography: CustomTypography = CustomTypography(),
    content: @Composable() () -> Unit
) {
    CompositionLocalProvider(
        LocalLightColors provides colors,
        LocalAppTypography provides typography,
    ) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = typography.materialTypography
        ) {
            content()
        }
    }
}

object AppTheme {
    val lightColors: AppColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalLightColors.current

    val darkColors: AppColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalDarkColors.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val sizes: CustomSize
        @Composable
        @ReadOnlyComposable
        get() = LocalSize.current
}

internal val LocalLightColors = staticCompositionLocalOf { CustomLightColorPalette() }
internal val LocalDarkColors = staticCompositionLocalOf { CustomDarkColorPalette() }
internal val LocalAppTypography = staticCompositionLocalOf { CustomTypography() }
internal val LocalElevations = staticCompositionLocalOf { Elevations() }
internal val LocalPaddings = staticCompositionLocalOf { Paddings() }
internal val LocalSize = staticCompositionLocalOf { CustomSize() }
