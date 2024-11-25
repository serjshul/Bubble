package com.serjshul.bubble.data.model

import com.serjshul.bubble.data.model.collections.User
import com.serjshul.bubble.data.model.subcollections.Comment
import com.serjshul.bubble.data.model.subcollections.Like
import com.serjshul.bubble.data.model.subcollections.Tag
import com.serjshul.bubble.data.model.subcollections.Type
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.toARGBString
import java.util.Date
import java.util.UUID

enum class ArticleField {
    ID, OWNER_ID, TITLE, TYPE, CREATOR, YEAR, TAGS, DESCRIPTION, QUOTE, COVER_URI, BACKGROUND_URI,
    DATE, COLOR, PARAGRAPH_TITLE, PARAGRAPH_TEXT, PARAGRAPH_IMAGE_URI, CONTENT
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
        val content: List<Paragraph.UI>? = null,
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
        override val id: String = UUID.randomUUID().toString(),
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
        val content: List<Paragraph.Draft> = emptyList(),
        val owner: User? = null,
        val likes: List<Like> = emptyList(),
        val comments: List<Like> = emptyList(),
        val reposts: List<Like> = emptyList(),
        val errors: List<ArticleField> = emptyList()
    ) : Article {
        override fun isValid(): Boolean =
                ownerId != null && title.isEmpty() && description.isEmpty() &&
                creator.isEmpty() && typeId != null && year != null && tagIds.isNotEmpty() &&
                coverUri != null && date != null && type != null && tags.isNotEmpty() &&
                owner != null && content.all { it.isValid() }

        fun copyWithErrorsCheck(
            id: String = this.id,
            ownerId: String? = this.ownerId,
            title: String = this.title,
            description: String = this.description,
            creator: String = this.creator,
            typeId: String? = this.typeId,
            year: Int? = this.year,
            tagIds: List<String> = this.tagIds,
            color: String = this.color,
            contentIds: List<String> = this.contentIds,
            quote: String? = this.quote,
            coverUri: String? = this.coverUri,
            backgroundUri: String? = this.backgroundUri,
            date: Date? = this.date,
            likeIds: List<String> = this.likeIds,
            commentIds: List<String> = this.commentIds,
            repostIds: List<String> = this.repostIds,
            type: Type? = this.type,
            tags: List<Tag> = this.tags,
            content: List<Paragraph.Draft> = this.content,
            owner: User? = this.owner,
            likes: List<Like> = this.likes,
            comments: List<Like> = this.comments,
            reposts: List<Like> = this.reposts,
            errors: List<ArticleField> = this.errors
        ): Draft {
            val article = Draft(
                id, ownerId, title, description, creator, typeId, year, tagIds, color,
                contentIds, quote, coverUri, backgroundUri, date, likeIds, commentIds,
                repostIds, type, tags, content, owner, likes, comments, reposts, errors
            )

            if (title != this.title) {
                return if (title.isEmpty()) {
                    article.copy(errors = errors + ArticleField.TITLE)
                } else {
                    article.copy(errors = errors - ArticleField.TITLE)
                }
            }
            if (creator != this.creator) {
                return if (creator.isEmpty()) {
                    article.copy(errors = errors + ArticleField.CREATOR)
                } else {
                    article.copy(errors = errors - ArticleField.CREATOR)
                }
            }
            if (year != this.year) {
                return if (year == null) {
                    article.copy(errors = errors + ArticleField.YEAR)
                } else {
                    article.copy(errors = errors - ArticleField.YEAR)
                }
            }
            if (description != this.description) {
                return if (description.isEmpty()) {
                    article.copy(errors = errors + ArticleField.DESCRIPTION)
                } else {
                    article.copy(errors = errors - ArticleField.DESCRIPTION)
                }
            }
            if (quote != this.quote) {
                return if (quote == "") {
                    article.copy(errors = errors + ArticleField.QUOTE)
                } else {
                    article.copy(errors = errors - ArticleField.QUOTE)
                }
            }
            if (coverUri != this.coverUri) {
                return if (coverUri == null) {
                    article.copy(errors = errors + ArticleField.COVER_URI)
                } else {
                    article.copy(errors = errors - ArticleField.COVER_URI)
                }
            }
            if (type != this.type) {
                return if (type == null) {
                    article.copy(errors = errors + ArticleField.TYPE)
                } else {
                    article.copy(errors = errors - ArticleField.TYPE)
                }
            }
            if (tags != this.tags) {
                return if (tags.isEmpty()) {
                    article.copy(errors = errors + ArticleField.TAGS)
                } else {
                    article.copy(errors = errors - ArticleField.TAGS)
                }
            }

            return article
        }

        fun checkError(): Draft {
            val currentErrors = mutableListOf<ArticleField>()

            if (ownerId == null) currentErrors.add(ArticleField.OWNER_ID)
            if (title.isEmpty()) currentErrors.add(ArticleField.TITLE)
            if (description.isEmpty()) currentErrors.add(ArticleField.DESCRIPTION)
            if (creator.isEmpty()) currentErrors.add(ArticleField.CREATOR)
            if (typeId == null) currentErrors.add(ArticleField.TYPE)
            if (year == null) currentErrors.add(ArticleField.YEAR)
            if (tagIds.isEmpty()) currentErrors.add(ArticleField.TAGS)
            if (coverUri == null) currentErrors.add(ArticleField.COVER_URI)
            if (quote != null && quote == "") currentErrors.add(ArticleField.QUOTE)
            if (date == null) currentErrors.add(ArticleField.DATE)

            val contentWithErrors = mutableListOf<Paragraph.Draft>()
            for (paragraph in content) {
                val paragraphWithError = paragraph.checkError()
                if (paragraphWithError.errors.isNotEmpty()) {
                    currentErrors.add(ArticleField.CONTENT)
                }
                contentWithErrors.add(paragraphWithError)
            }

            return this.copy(
                content = contentWithErrors,
                errors = currentErrors
            )
        }
    }
}
