package com.serjshul.bubble.model

import java.util.Date

data class Article (
    val id: String? = null,
    val uid: String? = null,

    val title: String? = null,
    val description: String? = null,
    val creator: String? = null,
    val type: String? = null,
    val tags: List<String> = emptyList(),
    val color: String? = null,
    val content: List<Paragraph> = emptyList(),

    val coverUrl: String? = null,
    val backgroundUrl: String? = null,

    var owner: User? = null,
    val date: Date? = null,
    val likes: List<String> = emptyList(),
    val comments: List<Comment> = emptyList(),
    val reposts: List<String> = emptyList(),
    val saves: List<String> = emptyList()
)

data class Paragraph (
    val header: String? = null,
    val imageUrl: String? = null,
    val text: String? = null
)