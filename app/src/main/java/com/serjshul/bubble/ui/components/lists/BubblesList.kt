package com.serjshul.bubble.ui.components.lists

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.data.model.Article
import com.serjshul.bubble.ui.components.cards.Bubble
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BubblesList(
    modifier: Modifier = Modifier,
    title: String,
    content: List<Article.UI>
) {
    val filteredContent = content.filter { it.backgroundUri != null }
    val pagerState = rememberPagerState(
        pageCount = { filteredContent.size }
    )

    Column(
        modifier = modifier.padding(start = 0.dp, end = 0.dp, top = 15.dp, bottom = 25.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 20.dp, end = 5.dp, bottom =  5.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(6f)
                    .align(Alignment.CenterVertically),
                text = title,
                color = md_theme_light_onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )

            IconButton(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                onClick = { /* do something */ }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Favorite",
                    tint = md_theme_light_onBackground,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 30.dp)
        ) { page ->
            Bubble(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                                .absoluteValue

                        cameraDistance = 8 * density
                        rotationY = lerp(
                            start = 0f,
                            stop = 0f,
                            fraction = pageOffset.coerceIn(-1f, 1f)
                        )
                        lerp(
                            start = 0.9f,
                            stop = 1f,
                            fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f),
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    },
                article = filteredContent[page],
                onOpenClick = { }
            )
        }
    }
}

@Preview
@Composable
fun BubblesListPreview() {
    BubblesList(
        title = "Demo articles",
        content = articlesUI
    )
}