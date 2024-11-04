package com.serjshul.bubble.ui.components.buttons

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onLike
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_light_secondary

@Composable
fun LikeIconToggleButton(
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
fun LikeIconToggleButtonPreview() {
    LikeIconToggleButton(
        isLiked = true,
        onClick = {}
    )
}

@Composable
fun CommentIconToggleButton(
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
fun CommentIconToggleButtonPreview() {
    CommentIconToggleButton(
        isCommented = true,
        onClick = {}
    )
}

@Composable
fun RepostIconToggleButton(
    modifier: Modifier = Modifier,
    isReposted: Boolean,
    onClick: () -> Unit
) {
    val isCurrentlyReposted = remember { mutableStateOf(isReposted) }

    IconToggleButton(
        modifier = modifier,
        checked = isCurrentlyReposted.value,
        onCheckedChange = {
            isCurrentlyReposted.value = !isCurrentlyReposted.value
            onClick()
        }
    ) {
        val transition = updateTransition(isCurrentlyReposted.value, label = "repostTransition")
        val tint by transition.animateColor(label = "repostTint") { isReposted ->
            if (isReposted) md_theme_light_primary else md_theme_light_onBackground
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
            label = "repostSize"
        ) { if (it) 29.dp else 29.dp }

        Icon(
            ImageVector.vectorResource(id = R.drawable.action_repost),
            contentDescription = "Repost",
            tint = tint,
            modifier = Modifier.size(size)
        )
    }
}

@Preview
@Composable
fun RepostIconToggleButtonPreview() {
    RepostIconToggleButton(
        isReposted = true,
        onClick = {}
    )
}

@Composable
fun SaveIconToggleButton(
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
fun SaveIconToggleButtonPreview() {
    SaveIconToggleButton(
        isSaved = true,
        onClick = {}
    )
}

@Composable
fun CloseIconToggleButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    tint: Color,
    onClick: () -> Unit
) {
    IconToggleButton(
        modifier = modifier,
        checked = true,
        onCheckedChange = { onClick() }
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(backgroundColor)
        ) {
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.Outlined.Clear,
                tint = tint,
                contentDescription = "Close"
            )
        }
    }
}

@Preview
@Composable
fun CloseIconToggleButtonPreview() {
    CloseIconToggleButton(
        backgroundColor = md_theme_light_secondary,
        tint = md_theme_light_onSecondary,
        onClick = {}
    )
}

@Composable
fun AddIconToggleButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    tint: Color,
    onClick: () -> Unit
) {
    IconToggleButton(
        modifier = modifier,
        checked = true,
        onCheckedChange = { onClick() }
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(backgroundColor)
        ) {
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.Outlined.Add,
                tint = tint,
                contentDescription = "Add"
            )
        }
    }
}

@Preview
@Composable
fun AddIconToggleButtonPreview() {
    AddIconToggleButton(
        backgroundColor = md_theme_light_secondary,
        tint = md_theme_light_onSecondary,
        onClick = {}
    )
}