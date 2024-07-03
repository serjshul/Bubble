package com.serjshul.bubble.model

import java.util.Date

data class Comment(
    val id: String? = null,
    val recommendationId: String? = null,
    val userId: String? = null,

    val repliedCommentId: String? = null,
    val repliedUserId: String? = null,
    val isReply: Boolean? = false,

    val text: String? = null,

    val date: Date? = null,
    val source: String? = null,
    val likedBy: List<String> = listOf(),

    var userItem: UserItem? = null
)