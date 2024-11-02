package com.serjshul.bubble.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.theme.md_theme_light_secondary

@Composable
fun TextFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(text)
    }
}

@Composable
fun AddTextFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            imageVector = Icons.Filled.Add,
            contentDescription = ""
        )
        Text(text)
    }
}

@Preview
@Composable
fun TextFilledButtonPreview() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Black)
    ) {
        TextFilledButton(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.button_read),
            containerColor = md_theme_light_secondary,
            contentColor = md_theme_light_onSecondary,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun AddTextFilledButtonPreview() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Black)
    ) {
        AddTextFilledButton(
            modifier = Modifier.align(Alignment.Center),
            text = "Add a background",
            containerColor = md_theme_light_secondary,
            contentColor = md_theme_light_onSecondary,
            onClick = {}
        )
    }
}