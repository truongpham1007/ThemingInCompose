package com.example.themming.ui

import android.annotation.SuppressLint
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

interface AppColorPalette {
    val primary: Color
    val background: Color
    val basic: Color
    val disable: Color
    val text: Color
    val textReverse: Color
    val success: Color
    val link: Color
    val warning: Color
    val error: Color
    val materialColors: Colors
}

object AppColors {
    val primary : Color = Color(0xFF3366FF)
    val background = Color(0xFFFFFFFF)
    val backgroundReverse = Color(0xFF192038)
    val basic = Color(0xFF8F9BB3)
    val disable = basic.copy(alpha = 0.24f)
    val text = Color(0xFF192038)
    val textReverse = Color(0xFFFFFFFF)
    val success = Color(0xFF00E096)
    val link = Color(0xFF0095FF)
    val warning = Color(0xFFFFAA00)
    val error = Color(0xFFFF3D71)
}

fun CustomLightColorPalette(): AppColorPalette = object : AppColorPalette {
    override val primary: Color = AppColors.primary
    override val background: Color = AppColors.background
    override val basic: Color = AppColors.basic
    override val disable: Color = AppColors.disable
    override val text: Color = AppColors.text
    override val textReverse: Color = AppColors.textReverse
    override val success: Color = AppColors.success
    override val link: Color = AppColors.link
    override val warning: Color = AppColors.warning
    override val error: Color = AppColors.error

    @SuppressLint("ConflictingOnColor")
    override val materialColors: Colors = lightColors(
        primary = AppColors.primary,
        background = AppColors.background,
        surface = AppColors.background,
        onSurface = AppColors.error
    )
}

fun CustomDarkColorPalette(): AppColorPalette = object : AppColorPalette {
    override val primary: Color = AppColors.primary
    override val background: Color = AppColors.backgroundReverse
    override val basic: Color = AppColors.basic
    override val disable: Color = AppColors.disable
    override val text: Color = AppColors.textReverse
    override val textReverse: Color = AppColors.text
    override val success: Color = AppColors.success
    override val link: Color = AppColors.link
    override val warning: Color = AppColors.warning
    override val error: Color = AppColors.error

    @SuppressLint("ConflictingOnColor")
    override val materialColors: Colors = darkColors(
        primary = AppColors.primary,
        background = AppColors.backgroundReverse,
        surface = AppColors.backgroundReverse,
        onSurface = AppColors.textReverse
    )
}
