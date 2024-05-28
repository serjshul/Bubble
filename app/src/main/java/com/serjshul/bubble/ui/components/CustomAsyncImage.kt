package com.serjshul.bubble.ui.components

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
    const val BACKGROUND = "background"
}

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    imageType: String = ImageType.BACKGROUND,
    link: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = link,
        contentScale = ContentScale.Crop,
        placeholder =
            if (imageType == ImageType.COVER)
                debugPlaceholder(R.drawable.article_cover)
            else
                debugPlaceholder(R.drawable.article_background),
        contentDescription = contentDescription
    )
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }