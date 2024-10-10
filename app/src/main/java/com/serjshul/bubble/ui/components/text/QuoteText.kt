package com.serjshul.bubble.ui.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
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
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun QuoteText(
    modifier: Modifier = Modifier,
    quote: String,
    color: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .roundedCornerShape()
            .background(color.toColor())
            .padding(15.dp)
    ) {
        val paragraphs = quote.split("\n")

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
                .basicMarquee(),
            text = stringResource(id = R.string.title_quote),
            color = md_theme_light_onSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
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
fun QuoteTextPreview() {
    QuoteText(
        quote = "Marion McPherson: I want you to be the very best version of yourself that you can be.\n" +
                "Christine 'Lady Bird' McPherson: What if this is the best version?",
        color = "#c22f2f"
    )
}