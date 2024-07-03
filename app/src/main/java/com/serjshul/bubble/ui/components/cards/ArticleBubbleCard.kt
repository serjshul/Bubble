package com.serjshul.bubble.ui.components.cards

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.data.articleDemo
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.getColor
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun ArticleBubbleCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    coverUrl: String,
    color: Color,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val brush = Brush.horizontalGradient(listOf(Color(0x30000000), Color(0x30000000)))

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(screenWidth + 15.dp)
    ) {
        CoverAsyncImage(
            modifier = Modifier
                .size(screenWidth - 30.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter),
            url = coverUrl,
            contentDescription = ""
        )
        Box(
            modifier = Modifier
                .size(screenWidth - 30.dp)
                .clip(CircleShape)
                .background(brush)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = screenWidth - 40.dp - 100.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                modifier = Modifier
                    .width(250.dp)
                    .padding(bottom = 15.dp)
                    .align(Alignment.CenterHorizontally),
                text = title,
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .roundedCornerShape()
                    .background(color)
                    .padding(top = 15.dp, start = 15.dp, end = 5.dp, bottom = 15.dp)
            ) {
                Text(
                    modifier = Modifier
                        .weight(8f),
                    text = description,
                    color = md_theme_light_onSecondary,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
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
    ArticleBubbleCard(
        title = articleDemo.title,
        description = articleDemo.description,
        coverUrl = articleDemo.coverUrl,
        color = articleDemo.color.getColor
    )
}