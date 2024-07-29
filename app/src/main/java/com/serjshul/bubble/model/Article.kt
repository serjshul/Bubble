package com.serjshul.bubble.model

import java.util.Date

data class Article (
    val id: String,
    val uid: String,

    val title: String,
    val description: String,
    val creator: String,
    val type: String,
    val tags: List<String>,
    val color: String,
    val content: List<Paragraph> = emptyList(),

    val coverUrl: String,
    val backgroundUrl: String,

    var owner: User?,
    val date: Date,
    val likes: List<String> = emptyList(),
    val comments: List<Comment> = emptyList(),
    val reposts: List<String> = emptyList(),
    val saves: List<String> = emptyList()
)

data class Paragraph (
    val header: String,
    val imageUrl: String,
    val text: String
)