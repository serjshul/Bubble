package com.serjshul.bubble.ui.components.buttons

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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun AddQuoteButton(
    modifier: Modifier = Modifier,
    color: Color = md_theme_light_primary,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .blur(10.dp)
                .padding(15.dp)
                .roundedCornerShape()
                .background(color)
                .padding(15.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .basicMarquee(),
                text = stringResource(id = R.string.title_quote),
                color = md_theme_light_onSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Marion McPherson: I want you to be the very best version of yourself that you can be.\n\n" +
                        "Christine 'Lady Bird' McPherson: What if this is the best version?",
                color = md_theme_light_onSecondary,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }
        AddTextFilledButton(
            modifier = Modifier.align(Alignment.Center),
            text = "Add a quote",
            contentColor = color,
            containerColor = md_theme_light_onPrimary,
            onClick = onClick
        )
    }
}

@Preview
@Composable
fun AddQuoteButtonPreview() {
    AddQuoteButton(
        onClick = { }
    )
}