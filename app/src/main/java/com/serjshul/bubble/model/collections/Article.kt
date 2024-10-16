package com.serjshul.bubble.model.collections

import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.model.subcollections.Like
import java.util.Date

data class Article (
    val aid: String? = null,

    val uid: String? = null,
    val title: String? = null,
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

    val lids: List<String> = emptyList(),
    val cids: List<String> = emptyList(),
    val aids: List<String> = emptyList(),
    val sids: List<String> = emptyList(),

    var owner: User? = null,
    val likes: List<Like> = emptyList(),
    val comments: List<Comment> = emptyList(),
    val reposts: List<String> = emptyList(),

    var isLiked: Boolean? = null,
    var isReposted: Boolean? = null
)

data class Paragraph (
    val title: String? = null,
    val imageUrl: String? = null,
    val text: String? = null
)