package com.serjshul.bubble.ui.components.cards

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.ui.components.buttons.LikeOutlinedIconButton
import com.serjshul.bubble.ui.components.buttons.RemoveOutlinedIconButton
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    article: Article,
    onReadClick: () -> Unit,
    onAddToFavoritesClick: () -> Unit,
    onNotInterestedClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(screenHeight * 1 / 2)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 15.dp)
                .roundedCornerShape()
        ) {
            if (article.backgroundUri != null) {
                BackgroundAsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    url = article.backgroundUri,
                    contentDescription = stringResource(id = R.string.image_background)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(article.color.toColor())
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x15000000))
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
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
                    text = article.title!!,
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
                    text = article.description!!,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = md_theme_light_onSecondary,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                )

                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    TextFilledButton(
                        modifier = Modifier.padding(end = 5.dp),
                        text = stringResource(id = R.string.button_read),
                        onClick = onReadClick,
                        contentColor = article.color.toColor(),
                        containerColor = md_theme_light_onSecondary
                    )

                    LikeOutlinedIconButton(
                        color = md_theme_light_onSecondary,
                        onClick = onAddToFavoritesClick
                    )

                    RemoveOutlinedIconButton(
                        color = md_theme_light_onSecondary,
                        onClick = onNotInterestedClick
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BannerPreview() {
    Banner(
        article = articlesUI[0],
        onReadClick = {},
        onAddToFavoritesClick = {},
        onNotInterestedClick = {}
    )
}