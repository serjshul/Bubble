package com.serjshul.bubble.ui.components.media

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.serjshul.bubble.R

@Composable
fun CoverAsyncImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        placeholder = debugPlaceholder(R.drawable.article_cover)
    )
}

@Composable
fun BackgroundAsyncImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        placeholder = debugPlaceholder(R.drawable.article_background)
    )
}

@Composable
fun ProfileAsyncImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        placeholder = debugPlaceholder(R.drawable.profile_photo)
    )
}

@Composable
fun ParagraphAsyncImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String
) {
    AsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        placeholder = debugPlaceholder(R.drawable.article_paragraph)
    )
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }