package com.serjshul.bubble.ui.screens.main.home

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.components.CustomAsyncImage
import com.serjshul.bubble.ui.components.CustomOutlinedButton
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.getColor
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun ArticleItem(
    title: String,
    description: String,
    creator: String,
    tags: String,
    backgroundLink: String,
    color: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .roundedCornerShape()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        ) {
            CustomAsyncImage(
                modifier = Modifier.fillMaxWidth(),
                link = backgroundLink,
                contentDescription = stringResource(id = R.string.image_background)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(color.getColor)
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
                    CustomOutlinedButton(
                        text = stringResource(id = R.string.button_read),
                        onClick = {},
                        color = md_theme_light_onSecondary,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }

            Text(
                text = description,
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
    ArticleItem(
        title = "HIT ME HARD AND SOFT",
        description = "The pop star teams with her brother Finneas for their third album together, expanding the cooly dark vision of their sound. It’s an honest and ambitious album when it’s not inert and repetitive.",
        creator = "Billie Eilish",
        tags = listOf("Pop", "R&B").joinToString(),
        backgroundLink = "http://lala.ru",
        color = "#46475c"
    )
}