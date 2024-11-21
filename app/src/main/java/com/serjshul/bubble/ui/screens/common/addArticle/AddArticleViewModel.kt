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
import kotlinx.coroutines.delay
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AddArticleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    logService: LogService
) : BubbleViewModel(logService) {

    var snackbarMessage by mutableStateOf<String?>(null)

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

    var errors = mutableStateListOf<ArticleField>()
        private set

    init {
        // TODO: types init
        val allTypes = getAllTypes()
        types.addAll(allTypes)

        // TODO: tags init
        val allTags = getAllTags()
        tags.addAll(allTags)
    }

    private fun triggerSnackbar(message: String) {
        snackbarMessage = message
        launchCatching {
            delay(3000)
            snackbarMessage = null
        }
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
    }

    fun onAddTags(addingTags: List<Tag>) {
        article = article.copy(tags = addingTags, tagIds = addingTags.map { it.id!! })
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

    fun onShareClick() {
        val currentErrors = article.whereIsError()
        errors.clear()
        errors.addAll(currentErrors)


        if (errors.isEmpty()) {

        } else {
            triggerSnackbar(errors.joinToString())
        }
    }
}