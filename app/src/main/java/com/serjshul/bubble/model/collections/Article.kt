package com.serjshul.bubble.model.collections

import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.model.subcollections.Like
import java.util.Date

data class Article (
    val id: String? = null,

    val userId: String? = null,
    var title: String? = null,
    val description: String? = null,
    val creator: String? = null,
    val type: String? = null,
    val year: Int? = null,
    val tags: List<String> = emptyList(),
    val color: String? = null,
    val content: List<Paragraph> = emptyList(),
    val quote: String? = null,

    val coverUrl: String? = null,
    val backgroundUrl: String? = null,

    val date: Date? = null,

    val likeIds: List<String> = emptyList(),
    val commentIds: List<String> = emptyList(),
    val repostIds: List<String> = emptyList(),
    // TODO: val sids: List<String> = emptyList(),

    var owner: User? = null,
    val likes: List<Like> = emptyList(),
    val comments: List<Comment> = emptyList(),
    val reposts: List<String> = emptyList(),

    var isLiked: Boolean? = null,
    var isReposted: Boolean? = null
)

data class Paragraph (
    val id: String? = null,
    var title: String? = null,
    var imageUri: String? = null,
    var text: String? = null
)