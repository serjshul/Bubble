package com.serjshul.bubble.ui.components.posts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.serjshul.bubble.common.getCreatedTime
import com.serjshul.bubble.model.Comment
import com.serjshul.bubble.model.UserItem
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.components.media.CoverAsyncImage
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import java.util.Date

@Composable
fun Post(
    modifier: Modifier = Modifier,
    user: UserItem?,
    date: Date?,
    description: String?,
    coverReference: String,
    backgroundImageReference: String,
    title: String?,
    creator: String?,
    type: String?,
    tags: List<String>,
    isLiked: Boolean,
    comments: List<Comment>,
    recommendationId: String?,
    currentUserUid: String?,
    openScreen: (String) -> Unit,
) {
    val isCommentClicked = remember { mutableStateOf(false) }
    var isDropDownExpanded by remember { mutableStateOf(false) }

    if (user?.nickname != null && date != null && description != null &&
        title != null && creator != null) {
        val createdTime = getCreatedTime(date)

        Box(
            modifier = modifier
                .padding(0.dp, 5.dp)
                .fillMaxWidth()
        ) {
            BackgroundAsyncImage(
                modifier = Modifier
                    .padding(top = 55.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                url = "backgroundImageReference",
                contentDescription = ""
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
                    url = "user.photoUrl!!",
                    contentDescription = ""
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .weight(8f)
                            .padding(start = 15.dp),
                        text = user.nickname,
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

            Box(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 220.dp
                    )
            ) {
                Row {
                    CoverAsyncImage(
                        modifier = Modifier
                            .size(170.dp, 100.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .clickable { },
                        url = "coverReference",
                        contentDescription = ""
                    )

                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .align(Alignment.Bottom)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 2.dp),
                            text = "$type   /   ${tags.joinToString(separator = " & ")}",
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
                            text = title,
                            color = Color.Black,
                            maxLines = 1,
                            fontSize = 14.sp,
                            lineHeight = 1.2.em,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = creator,
                            color = Color.Black,
                            maxLines = 1,
                            fontSize = 14.sp,
                            lineHeight = 1.2.em,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 330.dp
                    )
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
                        .fillMaxWidth(),
                    text = description,
                    color = Color.Black,
                    fontSize = 14.sp,
                    lineHeight = 1.4.em
                )

//                if (comments.isNotEmpty()) {
//                    CommentsShortList(
//                        modifier = Modifier
//                            .padding(10.dp, 0.dp)
//                            .fillMaxWidth()
//                            .clickable { isCommentClicked.value = true },
//                        comments = comments
//                    )
//                }

//                InteractionPanelPost(
//                    isLiked = isLiked,
//                    isCommentClicked = isCommentClicked,
//                    comments = comments,
//                    recommendationId = recommendationId,
//                    currentUserUid = currentUserUid,
//                    onLikeClick = onLikeClick,
//                    onCommentClick = onCommentIconClick
//                )
            }
        }
    }
}

@Preview
@Composable
fun PostPreview() {
    val comments = listOf(
        Comment(
            text = "preview  preview preview preview preview preview preview",
            userItem = UserItem(nickname = "preview")
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            userItem = UserItem(nickname = "preview")
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            userItem = UserItem(nickname = "preview")
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            userItem = UserItem(nickname = "preview")
        )
    )

    Post(
        modifier = Modifier.background(Color.White),
        user = UserItem(
            nickname = "serjshul"
        ),
        date = Date(0),
        description = "text text text text text text text text text text text text text text text " +
                "text text text text text text text text text text text text text text text " +
                "text text text text text text text text text text text text text text",
        coverReference = "null",
        backgroundImageReference = "null",
        title = "title title title title title title title title",
        creator = "creator creator creator creator creator",
        type = "type",
        tags = listOf("tag", "tag", "tag", "tag"),
        comments = comments,
        isLiked = true,
        recommendationId = "",
        currentUserUid = "",
        openScreen = { }
    )
}