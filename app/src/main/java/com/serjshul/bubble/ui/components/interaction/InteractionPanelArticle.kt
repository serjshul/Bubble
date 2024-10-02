package com.serjshul.bubble.ui.components.interaction

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.components.buttons.CommentIconToggleButton
import com.serjshul.bubble.ui.components.buttons.LikeIconToggleButton
import com.serjshul.bubble.ui.components.buttons.RepostIconToggleButton
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onLike
import com.serjshul.bubble.ui.theme.md_theme_light_primary

@Composable
fun InteractionPanelArticle(
    modifier: Modifier = Modifier,
    isLiked: Boolean,
    isCommentsOpened: Boolean,
    isReposted: Boolean,
    onLikeCLick: () -> Unit,
    onCommentsCLick: () -> Unit,
    onRepostCLick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        LikeIconToggleButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            isLiked = isLiked,
            onClick = onLikeCLick
        )
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = stringResource(id = R.string.button_like),
            color = if (isLiked) md_theme_light_onLike else md_theme_light_onBackground,
            style = MaterialTheme.typography.bodySmall
        )
        CommentIconToggleButton(
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterVertically),
            isCommented = isCommentsOpened,
            onClick = onCommentsCLick
        )
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = stringResource(id = R.string.button_comment),
            style = MaterialTheme.typography.bodySmall
        )
        RepostIconToggleButton(
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterVertically),
            isReposted = isReposted,
            onClick = onRepostCLick
        )
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = stringResource(id = R.string.button_repost),
            color = if (isReposted) md_theme_light_primary else md_theme_light_onBackground,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun InteractionPanelArticlePreview() {
    InteractionPanelArticle(
        isLiked = false,
        isCommentsOpened = false,
        isReposted = false,
        onLikeCLick = { },
        onCommentsCLick = { },
        onRepostCLick = { }
    )
}