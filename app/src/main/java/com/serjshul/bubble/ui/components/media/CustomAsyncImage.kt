package com.serjshul.bubble.ui.components.media

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.serjshul.bubble.R

object ImageType {
    const val COVER = "cover"
}

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    imageType: String = ImageType.COVER,
    url: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        placeholder =
            when (imageType) {
                ImageType.COVER -> debugPlaceholder(R.drawable.article_cover)
                else -> debugPlaceholder(R.drawable.article_cover)
            }
    )
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }