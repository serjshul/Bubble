package com.serjshul.bubble.ui.components.comments.items

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.serjshul.bubble.R
import com.serjshul.bubble.common.getCreatedTimeShort
import com.serjshul.bubble.data.comment
import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onLike
import com.serjshul.bubble.ui.theme.md_theme_light_primary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommentProfileItem(
    modifier: Modifier = Modifier,
    comment: Comment,
    openArticleScreen: () -> Unit,
    openOwnerScreen: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val createdTime = getCreatedTimeShort(comment.date!!)
    val isCurrentlyLiked = remember { mutableStateOf(false) }
    var isDropDownExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .padding(0.dp, 5.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(top = 25.dp, start = 30.dp)
                .width(2.dp)
                .height(220.dp)
                .background(md_theme_light_primary)
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
                    .clip(CircleShape)
                    .clickable { openOwnerScreen() },
                url = comment.article!!.owner!!.photoUrl!!,
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
                    text = comment.article.owner!!.nickname!!,
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
            modifier = Modifier.padding(start = 50.dp, top = 50.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp, 0.dp)
            ) {
                CoverAsyncImage(
                    modifier = Modifier
                        .size(screenWidth * 1 / 2 - 65.dp, screenWidth * 1 / 2 - 120.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable { openArticleScreen() },
                    url = comment.article!!.coverUrl!!,
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
                        text = "${comment.article.type}   /   ${
                            comment.article.tags.joinToString(
                                separator = " & "
                            )
                        }",
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
                        text = comment.article.title!!,
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
                        text = comment.article.creator!!,
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
                    text = comment.article!!.description!!,
                    color = md_theme_light_onBackground,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }


        Row(
            modifier = Modifier
                .padding(top = 225.dp)
                .padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            ProfileAsyncImage(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable { openOwnerScreen() },
                url = comment.photoUrl!!,
                contentDescription = "Owner photo URL"
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                        .clickable { openOwnerScreen() },
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(comment.nickname)
                        }
                        append(" ${comment.text}")
                    },
                    color = md_theme_light_onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = createdTime,
                        color = md_theme_light_onBackground,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Icon(
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .size(18.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.action_share),
                        contentDescription = "Reply",
                        tint = md_theme_light_onBackground
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "Reply",
                        color = md_theme_light_onBackground,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Column(
                modifier = Modifier.padding(top = 3.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconToggleButton(
                    modifier = Modifier.size(30.dp),
                    checked = isCurrentlyLiked.value,
                    onCheckedChange = {
                        // TODO: add onLikeClick function
                        isCurrentlyLiked.value = !isCurrentlyLiked.value
                    }
                ) {
                    val transition =
                        updateTransition(isCurrentlyLiked.value, label = "likeTransition")
                    val tint by transition.animateColor(label = "likeTint") { isLiked ->
                        if (isLiked) md_theme_light_onLike else md_theme_light_onBackground
                    }
                    val size by transition.animateDp(
                        transitionSpec = {
                            if (false isTransitioningTo true) {
                                keyframes {
                                    durationMillis = 250
                                    17.dp at 0 using LinearOutSlowInEasing
                                    19.dp at 15 using FastOutLinearInEasing
                                    21.dp at 75
                                    19.dp at 150
                                }
                            } else {
                                spring(stiffness = Spring.StiffnessVeryLow)
                            }
                        },
                        label = "likeSize"
                    ) { if (it) 17.dp else 17.dp }

                    Icon(
                        imageVector = if (isCurrentlyLiked.value) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "like",
                        tint = tint,
                        modifier = Modifier.size(size)
                    )
                }

                if (comment.likedBy.isNotEmpty()) {
                    Text(
                        text = comment.likedBy.size.toString(),
                        color = Color.Gray,
                        fontSize = 10.sp,
                        lineHeight = 1.2.em
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CommentProfileItemPreview() {
    val demoComment = comment

    CommentProfileItem(
        comment = demoComment,
        openArticleScreen = { },
        openOwnerScreen = { }
    )
}