package com.serjshul.bubble.ui.components.interaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.common.getCreatedTimeLong
import com.serjshul.bubble.ui.components.buttons.CommentIconToggleButton
import com.serjshul.bubble.ui.components.buttons.LikeIconToggleButton
import com.serjshul.bubble.ui.components.buttons.RepostIconToggleButton
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import java.util.Date

@Composable
fun InteractionPanelArticle(
    modifier: Modifier = Modifier,
    isLiked: Boolean,
    isCommentsOpened: Boolean,
    isReposted: Boolean,
    date: Date,
    onLikeCLick: () -> Unit,
    onCommentsCLick: () -> Unit,
    onRepostCLick: () -> Unit,
) {
    val createdTime = getCreatedTimeLong(date)

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            LikeIconToggleButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                isLiked = isLiked,
                onClick = onLikeCLick
            )
            CommentIconToggleButton(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .align(Alignment.CenterVertically),
                isCommented = isCommentsOpened,
                onClick = onCommentsCLick
            )
            RepostIconToggleButton(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .align(Alignment.CenterVertically),
                isReposted = isReposted,
                onClick = onRepostCLick
            )
        }
        Text(
            modifier = Modifier.padding(start = 11.dp, top = 5.dp),
            text = createdTime,
            color = md_theme_light_onBackgroundVariant,
            style = MaterialTheme.typography.bodyMedium
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
        date = Date(),
        onLikeCLick = { },
        onCommentsCLick = { },
        onRepostCLick = { }
    )
}