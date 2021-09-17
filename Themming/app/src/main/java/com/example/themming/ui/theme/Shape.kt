package com.example.themming.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

@Immutable
data class Shape internal  constructor(
    val small : Dp = 4.dp,
    val medium : Dp = 4.dp,
    val large : Dp = 0.dp
)

internal val LocalShapes = staticCompositionLocalOf { Shape() }