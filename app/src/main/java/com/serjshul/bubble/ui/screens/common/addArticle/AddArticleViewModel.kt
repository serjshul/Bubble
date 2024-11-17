package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.serjshul.bubble.data.getAllTags
import com.serjshul.bubble.data.getAllTypes
import com.serjshul.bubble.data.searchTags
import com.serjshul.bubble.data.users
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.ArticleField
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.toARGBString
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AddArticleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    logService: LogService
) : BubbleViewModel(logService) {

    val currentUser = users[0]
    var types = mutableStateListOf<Type>()
        private set
    var tags = mutableStateListOf<Tag>()
        private set

    var isSelectTypeOpened by mutableStateOf(false)
        private set
    var isSelectTagsOpened by mutableStateOf(false)
        private set

    var article by mutableStateOf(
        Article.Draft(
            id = UUID.randomUUID().toString(),
            ownerId = currentUser.id
        )
    )

    init {
        val allTypes = getAllTypes()
        types.addAll(allTypes)

        val allTags = getAllTags()
        tags.addAll(allTags)
    }

    fun setIsSelectTypeOpened(input: Boolean) {
        isSelectTypeOpened = input
    }

    fun setIsSelectTagsOpened(input: Boolean) {
        isSelectTagsOpened = input
    }

    fun onArticleValueChange(field: ArticleField, input: String?) {
        article = when (field) {
            ArticleField.TITLE -> article.copy(title = input ?: "")
            ArticleField.CREATOR -> article.copy(creator = input ?: "")
            ArticleField.YEAR -> article.copy(year = if (input == null || input == "") null else input.toInt())
            ArticleField.DESCRIPTION -> article.copy(description = input ?: "")
            ArticleField.QUOTE -> article.copy(quote = input)
            ArticleField.COVER_URI -> article.copy(coverUri = input)
            ArticleField.BACKGROUND_URI -> article.copy(backgroundUri = input)
            ArticleField.COLOR -> article.copy(color = input ?: md_theme_light_primary.toARGBString())
            else -> article
        }
        checkArticleOnValid()
    }

    fun onParagraphValueChange(field: ArticleField, id: String, input: String?) {
        val updatedParagraphs = article.content.map { paragraph ->
            if (paragraph.id == id) {
                when (field) {
                    ArticleField.PARAGRAPH_TITLE -> paragraph.copy(title = input ?: "")
                    ArticleField.PARAGRAPH_TEXT -> paragraph.copy(text = input ?: "")
                    ArticleField.PARAGRAPH_IMAGE_URI -> paragraph.copy(imageUri = input)
                    else -> paragraph
                }
            } else {
                paragraph
            }
        }
        article = article.copy(content = updatedParagraphs)
    }

    fun onTypeValueChange(input: Type) {
        article = article.copy(type = input, typeId = input.id)
        checkArticleOnValid()
    }

    fun onAddTags(addingTags: List<Tag>) {
        article = article.copy(tags = addingTags, tagIds = addingTags.map { it.id!! })
        checkArticleOnValid()
    }

    fun onSearchTag(query: String) {
        tags.clear()
        tags.addAll(searchTags(query))
    }

    fun onAddParagraph() {
        val newParagraph = Paragraph(
            id = UUID.randomUUID().toString(),
            title = "",
            text = ""
        )
        val updatedParagraphs = article.content + newParagraph
        article = article.copy(content = updatedParagraphs)
    }

    fun onRemoveParagraph(id: String) {
        val updatedParagraphs = article.content.filter { it.id != id }
        article = article.copy(content = updatedParagraphs)
    }










    private fun checkArticleOnValid() {
//        isArticleValid = article.title != "" && article.description != "" &&
//                article.creator != "" && article.type != "" && article.color != "" &&
//                article.year != null && article.coverUrl != null && !article.content.isEmpty()
//        isArticleValid = title != "" && type != "" && creator != "" && year != "" &&
//                tags.isNotEmpty() && description != ""
    }
}