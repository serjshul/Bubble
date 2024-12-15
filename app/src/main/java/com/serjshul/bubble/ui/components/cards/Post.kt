package com.serjshul.bubble.ui.components.cards

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
import com.serjshul.bubble.common.getCreatedTimeShort
import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.ui.components.buttons.CommentIconToggleButton
import com.serjshul.bubble.ui.components.buttons.LikeIconToggleButton
import com.serjshul.bubble.ui.components.buttons.RepostIconToggleButton
import com.serjshul.bubble.ui.components.comments.CommentsShortList
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_primary

@Composable
fun Post(
    modifier: Modifier = Modifier,
    article: Article.UI,
    onLikeCLick: () -> Unit,
    onCommentCLick: () -> Unit,
    onRepostCLick: () -> Unit,
    onSaveCLick: () -> Unit,
    currentUid: String?,
    openArticleScreen: () -> Unit,
    openOwnerScreen: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val isLiked by remember { mutableStateOf(currentUid in article.likeIds!!) }
    var isCommented by remember { mutableStateOf(currentUid in article.commentIds!!) }
    val isReposted by remember { mutableStateOf(currentUid in article.repostIds!!) }
    // TODO: val isSaved by remember { mutableStateOf(currentUid in article.sids) }

    var isDropDownExpanded by remember { mutableStateOf(false) }

    val createdTime = getCreatedTimeShort(article.date!!)

    Box(
        modifier = modifier
            .padding(0.dp, 5.dp)
            .fillMaxWidth()
    ) {
        if (article.backgroundUri != null) {
            BackgroundAsyncImage(
                modifier = Modifier
                    .padding(top = 55.dp)
                    .fillMaxWidth()
                    .height(screenWidth * 1 / 2)
                    .clickable { openArticleScreen() },
                url = article.backgroundUri,
                contentDescription = "Background URL"
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileAsyncImage(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable { openOwnerScreen() },
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
                        .padding(start = 15.dp)
                        .clickable { openOwnerScreen() },
                    text = article.owner.nickname!!,
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
                        modifier = Modifier
                            .background(md_theme_light_background),
                        expanded = isDropDownExpanded,
                        onDismissRequest = { isDropDownExpanded = false }
                    ) {
                        // TODO: create the options
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

        Column(
            modifier = Modifier.padding(top = if (article.backgroundUri != null) 220.dp else 55.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                CoverAsyncImage(
                    modifier = Modifier
                        .size(screenWidth * 1 / 2 - 30.dp, screenWidth * 1 / 2 - 100.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable { openArticleScreen() },
                    url = article.coverUri!!,
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
                            .basicMarquee()
                            .clickable {
                                // TODO: open type and tags screen
                            },
                        text = "${article.type}   /   ${article.tags!!.joinToString(separator = " & ")}",
                        color = md_theme_light_primary,
                        maxLines = 1,
                        fontSize = 12.sp,
                        lineHeight = 1.2.em,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        modifier = Modifier
                            .basicMarquee()
                            .clickable { openArticleScreen() },
                        text = article.title!!,
                        color = Color.Black,
                        maxLines = 1,
                        fontSize = 14.sp,
                        lineHeight = 1.2.em,
                        fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        modifier = Modifier
                            .basicMarquee()
                            .clickable {
                                // TODO: open creator screen
                            },
                        text = article.creator!!,
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
                    .padding(start = 10.dp, top = 5.dp, end = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(),
                    text = article.description!!,
                    color = md_theme_light_onBackground,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )

                if (article.comments!!.isNotEmpty()) {
                    CommentsShortList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { isCommented = true },
                        comments = article.comments
                    )
                }
            }

            Row(
                modifier = Modifier.padding(start = 2.dp, top = 2.dp, end = 2.dp)
            ) {
                LikeIconToggleButton(
                    modifier = Modifier.weight(1f),
                    isLiked = isLiked,
                    onClick = onLikeCLick
                )
                CommentIconToggleButton(
                    modifier = Modifier.weight(1f),
                    isCommented = isCommented,
                    onClick = onCommentCLick
                )
                RepostIconToggleButton(
                    modifier = Modifier.weight(1f),
                    isReposted = isReposted,
                    onClick = onRepostCLick
                )
                Spacer(modifier = Modifier.weight(5f))
                /*
                TODO:
                SaveIconToggleButton(
                    modifier = Modifier.weight(1f),
                    isSaved = isSaved,
                    onClick = onSaveCLick
                )
                 */
            }
        }
    }
}

@Preview
@Composable
fun PostPreview() {
    val articleDemo = articlesUI.random()

    Post(
        modifier = Modifier.background(Color.White),
        article = articleDemo,
        currentUid = "",
        onLikeCLick = { },
        onCommentCLick = { },
        onRepostCLick = { },
        onSaveCLick = { },
        openArticleScreen = { },
        openOwnerScreen = { }
    )
}