package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.data.articleDemo
import com.serjshul.bubble.ui.components.buttons.CustomFilledButton
import com.serjshul.bubble.ui.components.buttons.CustomOutlinedIconButton
import com.serjshul.bubble.ui.components.buttons.IconButtonType
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.getColor

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    color: Color,
    coverUrl: String,
    onReadClick: () -> Unit,
    onAddToFavoritesClick: () -> Unit,
    onNotInterestedClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        listOf(Color(0x00000000), Color(0xFFFFFFFF)),
        startY = sizeImage.height.toFloat() / 2,
        endY = sizeImage.height.toFloat()
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(screenHeight * 3 / 5)
    ) {
        CoverAsyncImage(
            modifier = Modifier.fillMaxSize(),
            url = coverUrl,
            contentDescription = stringResource(id = R.string.image_background)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x15000000))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned {
                    sizeImage = it.size
                }
                .background(gradient)
        )

        Column(
            modifier = Modifier
                .width(screenWidth - 40.dp)
                .align(Alignment.Center)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = md_theme_light_onSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp),
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = md_theme_light_onSecondary,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                CustomFilledButton(
                    modifier = Modifier.padding(end = 5.dp),
                    text = stringResource(id = R.string.button_read),
                    onClick = onReadClick,
                    contentColor = color,
                    containerColor = md_theme_light_onSecondary
                )

                CustomOutlinedIconButton(
                    iconButtonType = IconButtonType.FAVORITE,
                    color = md_theme_light_onSecondary,
                    onClick = onAddToFavoritesClick
                )

                CustomOutlinedIconButton(
                    iconButtonType = IconButtonType.REMOVE,
                    color = md_theme_light_onSecondary,
                    onClick = onNotInterestedClick
                )
            }
        }
    }
}

@Preview
@Composable
fun BannerPreview() {
    Banner(
        title = articleDemo.title,
        description = articleDemo.description,
        color = articleDemo.color.getColor,
        coverUrl = articleDemo.coverUrl,
        onReadClick = {},
        onAddToFavoritesClick = {},
        onNotInterestedClick = {}
    )
}