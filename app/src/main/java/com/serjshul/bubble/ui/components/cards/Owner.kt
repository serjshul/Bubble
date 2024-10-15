package com.serjshul.bubble.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary

@Composable
fun Owner(
    modifier: Modifier = Modifier,
    nickname: String,
    photoUrl: String,
    onOwnerClick: () -> Unit
) {
    Row(
        modifier = modifier
    ) {
        ProfileAsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable { onOwnerClick() },
            url = photoUrl,
            contentDescription = stringResource(id = R.string.image_user_photo)
        )
        Text(
            modifier = Modifier
                .padding(start = 15.dp)
                .align(Alignment.CenterVertically)
                .clickable { onOwnerClick() },
            text = buildAnnotatedString {
                append("by ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("@${nickname}")
                }
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = md_theme_light_onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun OwnerPreview() {
    Owner(
        modifier = Modifier.background(Color.Gray),
        nickname = "serjshul",
        photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
        onOwnerClick = { }
    )
}