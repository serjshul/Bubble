package com.serjshul.bubble.ui.components.comments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.serjshul.bubble.model.Comment
import com.serjshul.bubble.model.User
import com.serjshul.bubble.ui.components.comments.items.CommentShortItem

@Composable
fun CommentsShortList(
    modifier: Modifier = Modifier,
    comments: List<Comment>
) {
    Column (
        modifier = modifier.fillMaxWidth(),
    ) {
        if (comments.size <= 3) {
            for (comment in comments) {
                CommentShortItem(
                    nickname = comment.owner?.nickname!!,
                    text = comment.text!!
                )
            }
        } else {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 1.dp),
                text = "View all ${comments.size} comments",
                overflow = TextOverflow.Ellipsis,
                lineHeight = 1.2.em,
                color = Gray,
                fontSize = 14.sp,
                maxLines = 1
            )
        }
    }
}

@Preview
@Composable
fun CommentsShortListExpandedPreview() {
    val comments = listOf(
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        )
    )

    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        CommentsShortList(
            comments = comments
        )
    }
}

@Preview
@Composable
fun CommentsShortListPreview() {
    val comments = listOf(
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        ),
        Comment(
            text = "preview  preview preview preview preview preview preview",
            owner = User(
                uid = "uid",
                photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                nickname = "serjshul"
            )
        )
    )

    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        CommentsShortList(
            comments = comments
        )
    }
}