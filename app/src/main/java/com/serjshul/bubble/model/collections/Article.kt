package com.serjshul.bubble.model.collections

import com.serjshul.bubble.model.subcollections.Comment
import com.serjshul.bubble.model.subcollections.Like
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.toARGBString
import java.util.Date

enum class ArticleField {
    ID, OWNER_ID, TITLE, TYPE, CREATOR, YEAR, TAGS, DESCRIPTION, QUOTE, COVER_URI, BACKGROUND_URI,
    DATE, COLOR, PARAGRAPH_TITLE, PARAGRAPH_TEXT, PARAGRAPH_IMAGE_URI
}

sealed interface Article {
    val id: String?
    val ownerId: String?
    val title: String?
    val description: String?
    val creator: String?
    val typeId: String?
    val year: Int?
    val tagIds: List<String>?
    val color: String
    val contentIds: List<String>?
    val quote: String?
    val coverUri: String?
    val backgroundUri: String?
    val date: Date?
    val likeIds: List<String>?
    val commentIds: List<String>?
    val repostIds: List<String>?

    fun isValid(): Boolean

    data class Doc(
        override val id: String? = null,
        override val ownerId: String? = null,
        override val title: String? = null,
        override val description: String? = null,
        override val creator: String? = null,
        override val typeId: String? = null,
        override val year: Int? = null,
        override val tagIds: List<String>? = null,
        override val color: String = md_theme_light_primary.toARGBString(),
        override val contentIds: List<String>? = null,
        override val quote: String? = null,
        override val coverUri: String? = null,
        override val backgroundUri: String? = null,
        override val date: Date? = null,
        override val likeIds: List<String>? = null,
        override val commentIds: List<String>? = null,
        override val repostIds: List<String>? = null
    ) : Article {
        override fun isValid(): Boolean = id != null && ownerId != null && title != null &&
                description != null && creator != null && typeId != null && year != null &&
                tagIds != null && contentIds != null  && coverUri != null && date != null &&
                likeIds != null && commentIds != null && repostIds != null
    }

    data class UI(
        override val id: String? = null,
        override val ownerId: String? = null,
        override val title: String? = null,
        override val description: String? = null,
        override val creator: String? = null,
        override val typeId: String? = null,
        override val year: Int? = null,
        override val tagIds: List<String>? = null,
        override val color: String = md_theme_light_primary.toARGBString(),
        override val contentIds: List<String>? = null,
        override val quote: String? = null,
        override val coverUri: String? = null,
        override val backgroundUri: String? = null,
        override val date: Date? = null,
        override val likeIds: List<String>? = null,
        override val commentIds: List<String>? = null,
        override val repostIds: List<String>? = null,
        val type: Type? = null,
        val tags: List<Tag>? = null,
        val content: List<Paragraph>? = null,
        val owner: User? = null,
        val likes: List<Like>? = null,
        val comments: List<Comment>? = null,
        val reposts: List<Like>? = null,
        var isLiked: Boolean? = null,
        var isReposted: Boolean? = null
    ) : Article {
        override fun isValid(): Boolean = id != null && ownerId != null && title != null &&
                description != null && creator != null && typeId != null && year != null &&
                tagIds != null && contentIds != null  && coverUri != null && date != null &&
                likeIds != null && commentIds != null && repostIds != null && type != null &&
                tags != null && content != null && owner != null && likes != null &&
                comments != null && reposts != null && isLiked != null && isReposted != null
    }

    data class Draft(
        override val id: String? = null,
        override val ownerId: String? = null,
        override var title: String = "",
        override var description: String = "",
        override var creator: String = "",
        override var typeId: String? = null,
        override var year: Int? = null,
        override val tagIds: List<String> = emptyList(),
        override var color: String = md_theme_light_primary.toARGBString(),
        override val contentIds: List<String> = emptyList(),
        override var quote: String? = null,
        override var coverUri: String? = null,
        override var backgroundUri: String? = null,
        override var date: Date? = null,
        override val likeIds: List<String> = emptyList(),
        override val commentIds: List<String> = emptyList(),
        override val repostIds: List<String> = emptyList(),
        var type: Type? = null,
        val tags: List<Tag> = emptyList(),
        val content: List<Paragraph> = emptyList(),
        val owner: User? = null,
        val likes: List<Like> = emptyList(),
        val comments: List<Like> = emptyList(),
        val reposts: List<Like> = emptyList()
    ) : Article {
        override fun isValid(): Boolean =
                id != null && ownerId != null && title.isEmpty() && description.isEmpty() &&
                creator.isEmpty() && typeId != null && year != null && tagIds.isNotEmpty() &&
                coverUri != null && date != null && type != null && tags.isNotEmpty() &&
                owner != null

        fun whereIsError(): List<ArticleField> {
            val errorFields = mutableListOf<ArticleField>()
            when {
                id == null -> errorFields.add(ArticleField.ID)
                ownerId == null -> errorFields.add(ArticleField.OWNER_ID)
                title.isEmpty() -> errorFields.add(ArticleField.TITLE)
                description.isEmpty() -> errorFields.add(ArticleField.DESCRIPTION)
                creator.isEmpty() -> errorFields.add(ArticleField.CREATOR)
                typeId == null -> ArticleField.TYPE
                year == null -> ArticleField.YEAR
                tagIds.isEmpty() -> ArticleField.TAGS
                coverUri == null -> ArticleField.COVER_URI
                date == null -> ArticleField.DATE
            }
            return errorFields
        }
    }
}

data class Paragraph (
    val id: String? = null,
    var title: String? = null,
    var imageUri: String? = null,
    var text: String? = null
)





