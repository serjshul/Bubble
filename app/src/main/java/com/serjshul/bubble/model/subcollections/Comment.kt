package com.serjshul.bubble.model.subcollections

import com.serjshul.bubble.model.collections.Article
import java.util.Date

data class Comment(
    val id: String? = null,

    val articleId: String? = null,
    val article: Article.UI? = null,

    val userId: String? = null,
    val nickname: String? = null,
    val photoUrl: String? = null,

    val text: String? = null,
    val repliedCid: String? = null,

    val date: Date? = null,
    val likedBy: List<String> = emptyList()
)