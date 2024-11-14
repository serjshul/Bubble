package com.serjshul.bubble.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.ui.theme.md_theme_dark_gradient
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun AddParagraphButton(
    modifier: Modifier = Modifier,
    color: Color = md_theme_light_primary,
    onClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Box {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .blur(10.dp)
                .padding(15.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "A Hero in the Making, on Shifting Sands",
                color = color,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(screenHeight * 1 / 5)
                    .padding(top = 15.dp)
                    .roundedCornerShape()
                    .background(Brush.verticalGradient(md_theme_dark_gradient))
            )
            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = "Herbert had a lot to say — about religion, ecology, the fate of humanity — and drew from an astonishment of sources, from Greek mythology to Indigenous cultures. Inspired by government efforts to keep sand dunes at bay, he dreamed up a desert planet where water was the new petroleum.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        AddTextFilledButton(
            modifier = Modifier.align(Alignment.Center),
            text = "Add a paragraph",
            contentColor = md_theme_light_onPrimary,
            containerColor = color,
            onClick = onClick
        )
    }
}

@Preview
@Composable
fun AddParagraphButtonPreview() {
    AddParagraphButton(
        onClick = { }
    )
}