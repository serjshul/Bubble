package com.serjshul.bubble.model.subcollections

import com.serjshul.bubble.model.collections.Article
import java.util.Date

data class Comment(
    val cid: String? = null,

    val aid: String? = null,
    val article: Article? = null,

    val uid: String? = null,
    val nickname: String? = null,
    val photoUrl: String? = null,

    val text: String? = null,
    val repliedCid: String? = null,

    val date: Date? = null,
    val likedBy: List<String> = emptyList()
)