package com.serjshul.bubble.ui.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.components.buttons.CloseIconToggleButton
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun QuoteInput(
    modifier: Modifier = Modifier,
    quote: String,
    color: Color = md_theme_light_primary,
    onQuoteValueChange: (String) -> Unit,
    onRemoveClick: () -> Unit
) {
    Box {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(15.dp)
                .roundedCornerShape()
                .background(color)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 5.dp)
                    .basicMarquee(),
                text = stringResource(id = R.string.title_quote),
                color = md_theme_light_onSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            TextInput(
                text = quote,
                placeholderText = "Type quote's text here",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textColor = md_theme_light_onPrimary,
                placeholderTextColor = md_theme_transparent_gray,
                textAlign = TextAlign.Start,
                onValueChange = onQuoteValueChange
            )
        }
        CloseIconToggleButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 16.dp, end = 16.dp),
            backgroundColor = md_theme_light_onPrimary,
            tint = color,
            onClick = onRemoveClick
        )
    }
}

@Preview
@Composable
fun QuoteInputWithoutDataPreview() {
    QuoteInput(
        quote = "",
        onQuoteValueChange = { },
        onRemoveClick = { }
    )
}

@Preview
@Composable
fun QuoteInputWithDataPreview() {
    QuoteInput(
        quote = "Marion McPherson: I want you to be the very best version of yourself that you can be.\n\n" +
                "Christine 'Lady Bird' McPherson: What if this is the best version?",
        onQuoteValueChange = { },
        onRemoveClick = { }
    )
}