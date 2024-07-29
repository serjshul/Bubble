package com.serjshul.bubble.ui.components.buttons

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onLike

@Composable
fun LikeIconButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean,
    onClick: () -> Unit
) {
    val isCurrentlyLiked = remember { mutableStateOf(isLiked) }

    IconToggleButton(
        modifier = modifier,
        checked = isCurrentlyLiked.value,
        onCheckedChange = {
            onClick()
            isCurrentlyLiked.value = !isCurrentlyLiked.value
        }
    ) {
        val transition = updateTransition(isCurrentlyLiked.value, label = "likeTransition")
        val tint by transition.animateColor(label = "likeTint") { isLiked ->
            if (isLiked) md_theme_light_onLike else md_theme_light_onBackground
        }
        val size by transition.animateDp(
            transitionSpec = {
                if (false isTransitioningTo true) {
                    keyframes {
                        durationMillis = 250
                        29.dp at 0 using LinearOutSlowInEasing
                        32.dp at 15 using FastOutLinearInEasing
                        35.dp at 75
                        32.dp at 150
                    }
                } else {
                    spring(stiffness = Spring.StiffnessVeryLow)
                }
            },
            label = "likeSize"
        ) { if (it) 29.dp else 29.dp }

        Icon(
            imageVector = if (isCurrentlyLiked.value) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = "like",
            tint = tint,
            modifier = Modifier.size(size)
        )
    }
}

@Preview
@Composable
fun LikeIconButtonPreview() {
    LikeIconButton(
        isLiked = true,
        onClick = {}
    )
}