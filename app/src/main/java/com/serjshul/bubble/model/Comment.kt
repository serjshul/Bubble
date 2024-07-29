package com.serjshul.bubble.model

import java.util.Date

data class Comment(
    val id: String? = null,
    val rid: String? = null,
    val uid: String? = null,

    val text: String? = null,

    val repliedCid: String? = null,
    val repliedUid: String? = null,
    val isReply: Boolean? = false,

    val date: Date? = null,
    var owner: User? = null,
    val likedBy: List<String> = emptyList()
)