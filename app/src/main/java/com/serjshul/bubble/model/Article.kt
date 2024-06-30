package com.serjshul.bubble.model

data class Article (
    val id: String,
    val title: String,
    val description: String,
    val creator: String,
    val tags: List<String>,
    val coverUrl: String,
    val color: String,
    val content: List<Paragraph> = emptyList()
)

data class Paragraph (
    val header: String,
    val imageUrl: String,
    val text: String
)