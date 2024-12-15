package com.serjshul.bubble.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun Quote(
    modifier: Modifier = Modifier,
    article: Article,
    onOpenClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp, 15.dp)
            .roundedCornerShape()
            .background(article.color.toColor())
            .clickable { onOpenClick() }
            .padding(15.dp)
    ) {
        val paragraphs = article.quote!!.split("\n")

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .basicMarquee(),
            text = stringResource(id = R.string.title_quote),
            color = md_theme_light_onSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .basicMarquee(),
            text = article.title!!,
            color = md_theme_light_onSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        for (paragraph in paragraphs) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = paragraph,
                color = md_theme_light_onSecondary,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
fun QuotePreview() {
    Quote(
        article = articlesUI[0],
        onOpenClick = { }
    )
}