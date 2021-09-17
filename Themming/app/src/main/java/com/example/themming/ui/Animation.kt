package com.example.themming.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.IntSize


@ExperimentalAnimationApi
@Composable
fun ExpandVerticalyAnimation(
    isVisible: Boolean,
    content: @Composable() () -> Unit
) {

    AnimatedVisibility(
        isVisible,
        // Sets the initial height of the content to 20, revealing only the top of the content at
        // the beginning of the expanding animation.
        enter = expandIn(
            // Overwrites the corner of the content that is first revealed
            expandFrom = Alignment.BottomStart,
            // Overwrites the initial size to 50 pixels by 50 pixels
            initialSize = { IntSize(50, 50) },
            // Overwrites the default spring animation with tween
            animationSpec = tween(100, easing = LinearOutSlowInEasing)
        ),
        exit = shrinkOut(
            // Overwrites the area of the content that the shrink animation will end on. The
            // following parameters will shrink the content's clip bounds from the full size of the
            // content to 1/10 of the width and 1/5 of the height. The shrinking clip bounds will
            // always be aligned to the CenterStart of the full-content bounds.
            shrinkTowards = Alignment.CenterStart,
            // Overwrites the target size of the shrinking animation.
            targetSize = { fullSize -> IntSize(fullSize.width / 10, fullSize.height / 5) },
            animationSpec = tween(100, easing = FastOutSlowInEasing)
        )
    ) {
        content()
    }
}