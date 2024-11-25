package com.serjshul.bubble.data.model

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
                return if (title.isEmpty()) {
                    Draft(id, title, imageUri, text, errors + ParagraphField.TITLE)
                } else {
                    Draft(id, title, imageUri, text, errors - ParagraphField.TITLE)
                }
            }
            if (text != this.text) {
                return if (text.isEmpty()) {
                    Draft(id, title, imageUri, text, errors + ParagraphField.TEXT)
                } else {
                    Draft(id, title, imageUri, text, errors - ParagraphField.TEXT)
                }
            }

            return Draft(id, title, imageUri, text, errors)
        }

        fun checkError(): Draft {
            val currentErrors = mutableListOf<ParagraphField>()

            if (title.isEmpty()) currentErrors.add(ParagraphField.TITLE)
            if (text.isEmpty()) currentErrors.add(ParagraphField.TEXT)

            return this.copy(errors = currentErrors)
        }
    }
}