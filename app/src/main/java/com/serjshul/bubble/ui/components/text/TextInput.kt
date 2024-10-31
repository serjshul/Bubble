package com.serjshul.bubble.ui.components.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_transparent
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    text: String,
    placeholderText: String,
    enabled: Boolean = true,
    textColor: Color = md_theme_light_onPrimary,
    placeholderTextColor: Color = md_theme_transparent_gray,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    fontWeight: FontWeight? = null,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Center,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        value = text,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = placeholderText,
                textAlign = textAlign,
                style = style,
                fontWeight = fontWeight
            )
        },
        textStyle = TextStyle(
            fontSize = style.fontSize,
            textAlign = textAlign,
            fontWeight = fontWeight,
            lineHeight = style.lineHeight
        ),
        maxLines = maxLines,
        singleLine = maxLines == 1,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = md_theme_transparent,
            unfocusedContainerColor = md_theme_transparent,
            disabledContainerColor = md_theme_transparent,
            errorContainerColor = md_theme_transparent,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor,
            errorTextColor = textColor,
            focusedPlaceholderColor = placeholderTextColor,
            unfocusedPlaceholderColor = placeholderTextColor,
            disabledPlaceholderColor = placeholderTextColor,
            errorCursorColor = placeholderTextColor,
            unfocusedIndicatorColor = md_theme_transparent,
            focusedIndicatorColor = md_theme_transparent,
            disabledIndicatorColor = md_theme_transparent
        )
    )
}

@Preview
@Composable
fun TextInputTextPreview() {
    TextInput(
        modifier = Modifier.background(Color.Gray),
        text = "The White Lotus",
        enabled = true,
        placeholderText = "Title",
        maxLines = 1,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        onValueChange = { }
    )
}

@Preview
@Composable
fun TextInputPlaceholderPreview() {
    TextInput(
        modifier = Modifier.background(Color.Gray),
        text = "",
        enabled = true,
        placeholderText = "Title",
        maxLines = 1,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        onValueChange = { }
    )
}