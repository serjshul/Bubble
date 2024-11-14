package com.serjshul.bubble.model.collections

import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.model.subcollections.Like
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.toARGBString
import java.util.Date

object ArticleFields {
    const val TITLE = "title"
    const val TYPE = "type"
    const val CREATOR = "creator"
    const val YEAR = "year"
    const val TAGS = "tags"
    const val DESCRIPTION = "description"
    const val COVER_URI = "coverUri"
    const val BACKGROUND_URI = "backgroundUri"
    const val COLOR = "color"
    const val PARAGRAPH_TITLE = "paragraphTitle"
    const val PARAGRAPH_TEXT = "paragraphText"
    const val PARAGRAPH_IMAGE_URI = "imageUri"
}

data class Article (
    val id: String? = null,

    val userId: String? = null,
    var title: String? = null,
    var description: String? = null,
    var creator: String? = null,
    var typeId: String? = null,
    var year: Int? = null,
    val tagIds: List<String> = emptyList(),
    var color: String = md_theme_light_primary.toARGBString(),
    val content: List<Paragraph> = emptyList(),
    var quote: String? = null,

    val coverUri: String? = null,
    val backgroundUri: String? = null,

    val date: Date? = null,

    val likeIds: List<String> = emptyList(),
    val commentIds: List<String> = emptyList(),
    val repostIds: List<String> = emptyList(),
    // TODO: val sids: List<String> = emptyList(),

    var type: Type? = null,
    val tags: List<Tag> = emptyList(),

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