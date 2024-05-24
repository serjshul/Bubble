package com.serjshul.bubble.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary

@Composable
fun CustomOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { onClick() },
        border = BorderStroke(
            width = 1.dp,
            color = color
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color
        )
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun CustomOutlinedButtonPreview() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Black)
    ) {
        CustomOutlinedButton(
            modifier = Modifier.align(Alignment.Center),
            text = "Read",
            color = md_theme_light_onSecondary,
            onClick = {}
        )
    }
}