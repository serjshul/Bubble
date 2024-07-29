package com.serjshul.bubble.ui.components.buttons

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground

@Composable
fun CommentIconButton(
    modifier: Modifier = Modifier,
    isCommented: Boolean,
    onClick: () -> Unit
) {
    val isCurrentlyCommented = remember { mutableStateOf(isCommented) }

    IconToggleButton(
        modifier = modifier,
        checked = isCurrentlyCommented.value,
        onCheckedChange = {
            isCurrentlyCommented.value = !isCurrentlyCommented.value
            onClick()
        }
    ) {
        val transition = updateTransition(isCurrentlyCommented.value, label = "CommentTransition")
        val size by transition.animateDp(
            transitionSpec = {
                keyframes {
                    durationMillis = 250
                    29.dp at 0 using LinearOutSlowInEasing
                    32.dp at 15 using FastOutLinearInEasing
                    35.dp at 75
                    32.dp at 150
                }
            },
            label = "CommentSize"
        ) { if (it) 29.dp else 29.dp }

        Icon(
            ImageVector.vectorResource(id = R.drawable.action_comment),
            contentDescription = "Comment",
            tint = md_theme_light_onBackground,
            modifier = Modifier.size(size)
        )
    }
}

@Preview
@Composable
fun CommentIconButtonPreview() {
    CommentIconButton(
        isCommented = true,
        onClick = {}
    )
}