package com.example.themming.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.themming.ui.AppTheme
import com.example.themming.ui.JetpackComposeMaterialTheme

@Composable
fun LargeSpacer() {
    Spacer(modifier = Modifier.size(AppTheme.sizes.large))
}

@Composable
fun NormalSpacer() {
    Spacer(modifier = Modifier.size(AppTheme.sizes.medium))
}

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.size(AppTheme.sizes.small))
}

@Composable
fun TinySpacer() {
    Spacer(modifier = Modifier.size(AppTheme.sizes.smaller))
}
