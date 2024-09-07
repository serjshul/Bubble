package com.serjshul.bubble.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
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
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground

@Composable
fun LikeOutlinedIconButton(
    modifier: Modifier = Modifier,
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
            imageVector = Icons.Outlined.Favorite,
            contentDescription = stringResource(id = R.string.icon_button_add_to_favorites)
        )
    }
}

@Composable
fun RemoveOutlinedIconButton(
    modifier: Modifier = Modifier,
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
            imageVector = Icons.Outlined.Clear,
            contentDescription = stringResource(id = R.string.icon_button_remove_banner)
        )
    }
}

@Composable
fun SimilarProfilesOutlinedIconButton(
    modifier: Modifier = Modifier,
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
            imageVector = Icons.Outlined.Person,
            contentDescription = stringResource(id = R.string.icon_button_similar_profiles)
        )
    }
}

@Preview
@Composable
fun LikeOutlinedIconButtonPreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(md_theme_light_background)
    ) {
        LikeOutlinedIconButton(
            modifier = Modifier.align(Alignment.Center),
            color = md_theme_light_onBackground,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun RemoveOutlinedIconButtonPreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(md_theme_light_background)
    ) {
        RemoveOutlinedIconButton(
            modifier = Modifier.align(Alignment.Center),
            color = md_theme_light_onBackground,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun SimilarProfilesOutlinedIconButtonPreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(md_theme_light_background)
    ) {
        SimilarProfilesOutlinedIconButton(
            modifier = Modifier.align(Alignment.Center),
            color = md_theme_light_onBackground,
            onClick = {}
        )
    }
}