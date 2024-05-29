package com.serjshul.bubble.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary

object IconButtonType {
    const val FAVORITE = "favorite"
    const val REMOVE = "remove"
}

@Composable
fun CustomOutlinedIconButton(
    modifier: Modifier = Modifier,
    iconButtonType: String,
    color: Color,
    onClick: () -> Unit
) {
    OutlinedIconButton(
        modifier = modifier,
        onClick = { onClick() },
        border = BorderStroke(
            width = 1.dp,
            color = color
        ),
        colors = IconButtonDefaults.outlinedIconButtonColors(
            contentColor = color
        )
    ) {
        Icon(
            imageVector = when (iconButtonType) {
                IconButtonType.FAVORITE -> Icons.Outlined.Favorite
                IconButtonType.REMOVE -> Icons.Outlined.Clear
                else -> Icons.Outlined.Clear
            },
            contentDescription = when (iconButtonType) {
                IconButtonType.FAVORITE -> stringResource(id = R.string.icon_button_add_to_favorites)
                IconButtonType.REMOVE -> stringResource(id = R.string.icon_button_remove_banner)
                else -> stringResource(id = R.string.icon_button_remove_banner)
            }
        )
    }
}

@Preview
@Composable
fun CustomOutlinedIconButtonFavouritePreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
    ) {
        CustomOutlinedIconButton(
            modifier = Modifier.align(Alignment.Center),
            iconButtonType = IconButtonType.FAVORITE,
            color = md_theme_light_onSecondary,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun CustomOutlinedIconButtonRemovePreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Black)
    ) {
        CustomOutlinedIconButton(
            modifier = Modifier.align(Alignment.Center),
            iconButtonType = IconButtonType.REMOVE,
            color = md_theme_light_onSecondary,
            onClick = {}
        )
    }
}