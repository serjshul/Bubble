package com.serjshul.bubble.ui.components.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.ui.components.cards.Card
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground

@Composable
fun CardsList(
    modifier: Modifier = Modifier,
    title: String,
    content: List<Article.UI>,
    openScreen: (String) -> Unit,
    onArticleClick: ((String) -> Unit, String) -> Unit
) {
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

        LazyRow {
            items(content) { article ->
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    article = article,
                    openScreen = openScreen,
                    onArticleClick = onArticleClick
                )
            }
            item {
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Preview
@Composable
fun CardsCategoryPreview() {
    CardsList(
        title = "Demo articles",
        content = articlesUI,
        openScreen = { },
        onArticleClick = { _, _ -> }
    )
}