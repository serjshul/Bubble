package com.serjshul.bubble.ui.components.posts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.serjshul.bubble.common.getCreatedTime
import com.serjshul.bubble.data.articleDemo
import com.serjshul.bubble.model.Article
import com.serjshul.bubble.ui.components.buttons.CommentIconButton
import com.serjshul.bubble.ui.components.buttons.LikeIconButton
import com.serjshul.bubble.ui.components.buttons.RepostIconButton
import com.serjshul.bubble.ui.components.buttons.SaveIconButton
import com.serjshul.bubble.ui.components.comments.CommentsShortList
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Post(
    modifier: Modifier = Modifier,
    article: Article,
    onLikeCLick: () -> Unit,
    onCommentCLick: () -> Unit,
    onRepostCLick: () -> Unit,
    onSaveCLick: () -> Unit,
    currentUid: String?,
    openScreen: (String) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val isLiked by remember { mutableStateOf(currentUid in article.likes) }
    var isCommented by remember { mutableStateOf(false) }
    val isReposted by remember { mutableStateOf(currentUid in article.reposts) }
    val isSaved by remember { mutableStateOf(currentUid in article.saves) }

    var isDropDownExpanded by remember { mutableStateOf(false) }

    val createdTime = getCreatedTime(article.date)

    Box(
        modifier = modifier
            .padding(0.dp, 5.dp)
            .fillMaxWidth()
    ) {
        BackgroundAsyncImage(
            modifier = Modifier
                .padding(top = 55.dp)
                .fillMaxWidth()
                .height(screenWidth * 1 / 2),
            url = article.backgroundUrl,
            contentDescription = "Background URL"
        )

        Row(
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileAsyncImage(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                url = article.owner!!.photoUrl!!,
                contentDescription = "Owner photo URL"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(8f)
                        .padding(start = 15.dp),
                    text = article.owner!!.nickname!!,
                    color = Color.Black,
                    maxLines = 1,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = createdTime,
                    color = Color.Black,
                    fontSize = 14.sp
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    IconButton(
                        onClick = { isDropDownExpanded = true }
                    ) {
                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = "Show the menu",
                            tint = Color.Black
                        )
                    }

                    DropdownMenu(
                        expanded = isDropDownExpanded,
                        onDismissRequest = { isDropDownExpanded = false }
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable(onClick = { }),
                            text = "Add to bookmarks",
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 220.dp
                )
        ) {
            CoverAsyncImage(
                modifier = Modifier
                    .size(screenWidth * 1 / 2 - 30.dp, screenWidth * 1 / 2 - 100.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .clickable { },
                url = article.coverUrl,
                contentDescription = "Cover URL"
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.Bottom)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                        .basicMarquee(),
                    text = "${article.type}   /   ${article.tags.joinToString(separator = " & ")}",
                    color = Color.Red,
                    maxLines = 1,
                    fontSize = 12.sp,
                    lineHeight = 1.2.em,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )

                Text(
                    modifier = Modifier
                        .clickable {

                        },
                    text = article.title,
                    color = Color.Black,
                    maxLines = 1,
                    fontSize = 14.sp,
                    lineHeight = 1.2.em,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = article.creator,
                    color = Color.Black,
                    maxLines = 1,
                    fontSize = 14.sp,
                    lineHeight = 1.2.em,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 325.dp
                )
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
                    .fillMaxWidth(),
                text = article.description,
                color = md_theme_light_onBackground,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )

            if (article.comments.isNotEmpty()) {
                CommentsShortList(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth()
                        .clickable { isCommented = true },
                    comments = article.comments
                )
            }

            Row(
                modifier = Modifier.padding(top = 2.dp)
            ) {
                LikeIconButton(
                    modifier = Modifier.weight(1f),
                    isLiked = isLiked,
                    onClick = onLikeCLick
                )
                CommentIconButton(
                    modifier = Modifier.weight(1f),
                    isCommented = isCommented,
                    onClick = onCommentCLick
                )
                RepostIconButton(
                    modifier = Modifier.weight(1f),
                    isReposted = isReposted,
                    onClick = onRepostCLick
                )
                Spacer(modifier = Modifier.weight(4f))
                SaveIconButton(
                    modifier = Modifier.weight(1f),
                    isSaved = isSaved,
                    onClick = onSaveCLick
                )
            }
        }
    }
}

@Preview
@Composable
fun PostPreview() {
    Post(
        modifier = Modifier.background(Color.White),
        article = articleDemo,
        currentUid = "",
        onLikeCLick = { },
        onCommentCLick = { },
        onRepostCLick = { },
        onSaveCLick = { },
        openScreen = { }
    )
}