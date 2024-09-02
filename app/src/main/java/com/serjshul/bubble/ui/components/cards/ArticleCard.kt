package com.serjshul.bubble.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.ui.components.buttons.TextOutlinedButton
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.getColor
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    creator: String,
    tags: String,
    coverUrl: String,
    color: Color
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .roundedCornerShape()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ) {
            CoverAsyncImage(
                modifier = Modifier.fillMaxWidth(),
                url = coverUrl,
                contentDescription = stringResource(id = R.string.image_background)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .background(color)
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
                        text = title,
                        color = md_theme_light_onSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(creator)
                            }
                            append("  •  $tags")
                        },
                        color = md_theme_light_onSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Box(
                    modifier = Modifier.weight(3f)
                ) {
                    TextOutlinedButton(
                        text = stringResource(id = R.string.button_read),
                        onClick = {},
                        contentColor = md_theme_light_onSecondary,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }

            Text(
                text = description,
                color = md_theme_light_onSecondary,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun ArticleItemPreview() {
    val articleDemo = articles.random()

    ArticleCard(
        title = articleDemo.title!!,
        description = articleDemo.description!!,
        creator = articleDemo.creator!!,
        tags = articleDemo.tags.joinToString(),
        coverUrl = articleDemo.coverUrl!!,
        color = articleDemo.color!!.getColor
    )
}