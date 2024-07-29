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
import com.serjshul.bubble.ui.theme.md_theme_light_primary

@Composable
fun SaveIconButton(
    modifier: Modifier = Modifier,
    isSaved: Boolean,
    onClick: () -> Unit
) {
    val isCurrentlySaved = remember { mutableStateOf(isSaved) }

    IconToggleButton(
        modifier = modifier,
        checked = isCurrentlySaved.value,
        onCheckedChange = {
            isCurrentlySaved.value = !isCurrentlySaved.value
            onClick()
        }
    ) {
        val transition = updateTransition(isCurrentlySaved.value, label = "saveTransition")
        val tint by transition.animateColor(label = "saveTint") { isSaved ->
            if (isSaved) md_theme_light_primary else md_theme_light_onBackground
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
            label = "saveSize"
        ) { if (it) 29.dp else 29.dp }

        Icon(
            ImageVector.vectorResource(
                id =
                if (isCurrentlySaved.value)
                    R.drawable.action_saved
                else
                    R.drawable.action_unsaved
            ),
            contentDescription = "Save",
            tint = tint,
            modifier = Modifier.size(size)
        )
    }
}

@Preview
@Composable
fun SaveIconButtonPreview() {
    SaveIconButton(
        isSaved = true,
        onClick = {}
    )
}