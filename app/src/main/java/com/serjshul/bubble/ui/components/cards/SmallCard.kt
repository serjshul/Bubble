package com.serjshul.bubble.ui.components.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SmallCard(
    modifier: Modifier = Modifier,
    article: Article,
    onOpenClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = modifier
            .width(screenWidth - 50.dp)
            .height(100.dp)
            .roundedCornerShape()
            .background(article.color!!.toColor())
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            CoverAsyncImage(
                modifier = Modifier
                    .size(screenWidth * 1 / 2 - 60.dp, screenWidth * 1 / 2 - 100.dp)
                    .roundedCornerShape()
                    .clickable { onOpenClick() },
                url = article.coverUrl!!,
                contentDescription = "Cover URL"
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                        .basicMarquee(),
                    text = article.title!!,
                    color = md_theme_light_onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(),
                    text = buildAnnotatedString {
                        append("${article.type}  •  ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(article.creator!!)
                        }
                    },
                    color = md_theme_light_onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(),
                    text = article.tags.joinToString(),
                    color = md_theme_light_onSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }


}

@Preview
@Composable
fun SmallCardPreview() {
    SmallCard(
        article = articles[0],
        onOpenClick = { }
    )
}