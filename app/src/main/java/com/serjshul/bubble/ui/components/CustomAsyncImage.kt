package com.serjshul.bubble.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.serjshul.bubble.R

@Composable
fun CustomAsyncImage(
    modifier: Modifier = Modifier,
    link: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = link,
        contentScale = ContentScale.Crop,
        placeholder = debugPlaceholder(R.drawable.article_background),
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