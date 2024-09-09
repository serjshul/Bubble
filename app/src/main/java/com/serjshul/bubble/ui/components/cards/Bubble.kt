package com.serjshul.bubble.ui.components.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Bubble(
    modifier: Modifier = Modifier,
    article: Article,
    onOpenClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val brush = Brush.verticalGradient(listOf(Color(0x20000000), Color(0x05000000)))

    Box(
        modifier = modifier
            .width(screenWidth - 60.dp)
    ) {
        BackgroundAsyncImage(
            modifier = Modifier
                .size(screenWidth - 60.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter),
            url = article.backgroundUrl!!,
            contentDescription = stringResource(id = R.string.image_background)
        )
        Box(
            modifier = Modifier
                .size(screenWidth - 60.dp)
                .clip(CircleShape)
                .background(brush)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .width(screenWidth - 80.dp)
                .padding(top = screenWidth - 170.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                modifier = Modifier
                    .width(screenWidth - 80.dp)
                    .align(Alignment.CenterHorizontally)
                    .basicMarquee(),
                text = article.title!!,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                modifier = Modifier
                    .width(screenWidth - 80.dp)
                    .padding(bottom = 15.dp)
                    .align(Alignment.CenterHorizontally),
                text = article.type!!,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall,
            )

            Row(
                modifier = Modifier
                    .width(screenWidth - 60.dp)
                    .height(95.dp)
                    .roundedCornerShape()
                    .background(article.color!!.toColor())
                    .padding(top = 15.dp, start = 15.dp, end = 5.dp, bottom = 15.dp)
            ) {
                Text(
                    modifier = Modifier
                        .weight(8f),
                    text = article.description!!,
                    color = md_theme_light_onSecondary,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )

                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    onClick = { onOpenClick() }
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Favorite",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BubbleItemPreview() {
    Bubble(
        article = articles[0],
        onOpenClick = { }
    )
}