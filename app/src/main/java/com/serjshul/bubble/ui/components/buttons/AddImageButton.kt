package com.serjshul.bubble.ui.components.buttons

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_dark_gradient
import com.serjshul.bubble.ui.theme.md_theme_light_errorContainer
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary

@Composable
fun AddImageButton(
    modifier: Modifier = Modifier,
    imageUri: Any?,
    color: Color = md_theme_light_primary,
    isError: Boolean = false,
    onCoverClick: () -> Unit,
    onAddCoverClick: () -> Unit,
) {
    if (imageUri != null) {
        CoverAsyncImage(
            modifier = modifier.clickable { onCoverClick() },
            url = imageUri,
            contentDescription = "Cover URL"
        )
    } else {
        Box(
            modifier =
                if (isError) {
                    modifier.background(md_theme_light_errorContainer)
                } else {
                    modifier.background(Brush.verticalGradient(md_theme_dark_gradient))
                }
        ) {
            AddIconToggleButton(
                modifier = Modifier.align(Alignment.Center),
                backgroundColor = md_theme_light_onPrimary,
                tint = color,
                onClick = onAddCoverClick
            )
        }
    }
}

@Preview
@Composable
fun AddCoverButtonWithImagePreview() {
    val coverWidth = 90.dp
    val coverHeight = coverWidth * 10 / 19

    AddImageButton(
        modifier = Modifier
            .size(coverWidth, coverHeight)
            .clip(RoundedCornerShape(5.dp)),
        imageUri = Uri.EMPTY,
        onCoverClick = { },
        onAddCoverClick = { }
    )
}

@Preview
@Composable
fun AddCoverButtonWithoutImagePreview() {
    val coverWidth = 90.dp
    val coverHeight = coverWidth * 10 / 19

    AddImageButton(
        modifier = Modifier
            .size(coverWidth, coverHeight)
            .clip(RoundedCornerShape(5.dp)),
        imageUri = null,
        onCoverClick = { },
        onAddCoverClick = { }
    )
}

@Preview
@Composable
fun AddCoverButtonErrorPreview() {
    val coverWidth = 90.dp
    val coverHeight = coverWidth * 10 / 19

    AddImageButton(
        modifier = Modifier
            .size(coverWidth, coverHeight)
            .clip(RoundedCornerShape(5.dp)),
        imageUri = null,
        isError = true,
        onCoverClick = { },
        onAddCoverClick = { }
    )
}