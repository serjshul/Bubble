package com.serjshul.bubble.ui.screens.main.home

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
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.cards.ArticleCard
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.utils.getColor
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Category(
    modifier: Modifier = Modifier,
    type: String,
    title: String,
    content: List<Article>
) {
    val pagerState = rememberPagerState(
        pageCount = { content.size }
    )

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(start = 25.dp, end = 15.dp, top = 15.dp, bottom =  15.dp)
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
            modifier = Modifier.padding(bottom = 15.dp),
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 25.dp),
        ) { page ->
            ArticleCard(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

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
                title = content[page].title!!,
                description = content[page].description!!,
                creator = content[page].creator!!,
                tags = content[page].tags.joinToString(),
                coverUrl = content[page].coverUrl!!,
                color = content[page].color!!.getColor
            )
        }
    }
}

@Preview
@Composable
fun CategoryPreview() {
    Category(
        type = "",
        title = "Demo articles",
        content = articles
    )
}