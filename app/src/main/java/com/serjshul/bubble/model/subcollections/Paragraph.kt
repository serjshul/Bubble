package com.serjshul.bubble.model.subcollections

import java.util.UUID

enum class ParagraphField {
    ID, TITLE, IMAGE_URI, TEXT
}

sealed interface Paragraph {
    val id: String?
    val title: String?
    val imageUri: String?
    val text: String?

    fun isValid(): Boolean

    data class Doc(
        override val id: String? = null,
        override val title: String? = null,
        override val imageUri: String? = null,
        override val text: String? = null
    ) : Paragraph {
        override fun isValid(): Boolean = id != null && title != null && text != null
    }

    data class UI(
        override val id: String? = null,
        override val title: String? = null,
        override val imageUri: String? = null,
        override val text: String? = null
    ) : Paragraph {
        override fun isValid(): Boolean = id != null && title != null && text != null
    }

    data class Draft(
        override val id: String = UUID.randomUUID().toString(),
        override var title: String = "",
        override var imageUri: String? = null,
        override var text: String = "",
        val errors: List<ParagraphField> = emptyList()
    ) : Paragraph {
        override fun isValid(): Boolean = title.isEmpty() && text.isEmpty()

        fun copyWithErrorsCheck(
            id: String = this.id,
            title: String = this.title,
            imageUri: String? = this.imageUri,
            text: String = this.text,
            errors: List<ParagraphField> = this.errors
        ): Draft {
            if (title != this.title) {
                if (title.isEmpty()) {
                    return Draft(id, title, imageUri, text, errors + ParagraphField.TITLE)
                } else {
                    return Draft(id, title, imageUri, text, errors - ParagraphField.TITLE)
                }
            }
            if (text != this.text) {
                if (text.isEmpty()) {
                    return Draft(id, title, imageUri, text, errors + ParagraphField.TEXT)
                } else {
                    return Draft(id, title, imageUri, text, errors - ParagraphField.TEXT)
                }
            }
            return Draft(id, title, imageUri, text, errors)
        }
    }
}