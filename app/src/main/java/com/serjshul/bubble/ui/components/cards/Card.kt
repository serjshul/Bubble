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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.data.model.Article
import com.serjshul.bubble.ui.components.buttons.TextOutlinedButton
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Card(
    modifier: Modifier = Modifier,
    article: Article.UI,
    openScreen: (String) -> Unit,
    onArticleClick: ((String) -> Unit, String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        modifier = modifier
            .width(screenWidth - 40.dp)
            .height(if (article.backgroundUri != null) screenWidth - 60.dp else screenWidth - 200.dp)
            .roundedCornerShape()
    ) {
        if (article.backgroundUri != null) {
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
            ) {
                BackgroundAsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    url = article.backgroundUri,
                    contentDescription = stringResource(id = R.string.image_background)
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth()
                .background(article.color.toColor())
                .padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(8f)
                        .padding(bottom = 15.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
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
                            append("  •  ${article.tags!!.joinToString()}")
                        },
                        color = md_theme_light_onSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Box(
                    modifier = Modifier.weight(3f)
                ) {
                    TextOutlinedButton(
                        text = stringResource(id = R.string.button_read),
                        onClick = { onArticleClick(openScreen, article.id!!) },
                        contentColor = md_theme_light_onSecondary,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }

            Text(
                text = article.description!!,
                color = md_theme_light_onSecondary,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun ArticleItemPreview() {
    Card(
        article = articlesUI[0],
        openScreen = { },
        onArticleClick = { _, _ -> }
    )
}