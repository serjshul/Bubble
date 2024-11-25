package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.serjshul.bubble.data.getAllTags
import com.serjshul.bubble.data.getAllTypes
import com.serjshul.bubble.data.searchTags
import com.serjshul.bubble.data.users
import com.serjshul.bubble.data.model.Article
import com.serjshul.bubble.data.model.ArticleField
import com.serjshul.bubble.data.model.Paragraph
import com.serjshul.bubble.data.model.subcollections.Tag
import com.serjshul.bubble.data.model.subcollections.Type
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.toARGBString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddArticleViewModel @Inject constructor(
    logService: LogService
) : BubbleViewModel(logService) {

    val currentUser by mutableStateOf(users[0])
    var article by mutableStateOf(
        Article.Draft(
            ownerId = currentUser.id
        )
    )
    var types = mutableStateListOf<Type>()
        private set
    var tags = mutableStateListOf<Tag>()
        private set

    var isCoverOpened by mutableStateOf(false)
        private set
    var isSelectTypeOpened by mutableStateOf(false)
        private set
    var isSelectTagsOpened by mutableStateOf(false)
        private set
    var snackbarMessage by mutableStateOf<String?>(null)

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

    fun setIsCoverOpened(input: Boolean) {
        isCoverOpened = input
    }

    fun setIsSelectTypeOpened(input: Boolean) {
        isSelectTypeOpened = input
    }

    fun setIsSelectTagsOpened(input: Boolean) {
        isSelectTagsOpened = input
    }

    fun onArticleValueChange(field: ArticleField, input: String?) {
        article = when (field) {
            ArticleField.TITLE -> article.copyWithErrorsCheck(title = input ?: "")
            ArticleField.CREATOR -> article.copyWithErrorsCheck(creator = input ?: "")
            ArticleField.YEAR -> article.copyWithErrorsCheck(year = if (input == null || input == "") null else input.toInt())
            ArticleField.DESCRIPTION -> article.copyWithErrorsCheck(description = input ?: "")
            ArticleField.QUOTE -> article.copyWithErrorsCheck(quote = input)
            ArticleField.COVER_URI -> article.copyWithErrorsCheck(coverUri = input)
            ArticleField.BACKGROUND_URI -> article.copyWithErrorsCheck(backgroundUri = input)
            else -> article.copyWithErrorsCheck(color = input ?: md_theme_light_primary.toARGBString())
        }
    }

    fun onParagraphValueChange(field: ArticleField, id: String, input: String?) {
        val updatedParagraphs = article.content.map { paragraph ->
            if (paragraph.id == id) {
                when (field) {
                    ArticleField.PARAGRAPH_TITLE -> paragraph.copyWithErrorsCheck(title = input ?: "")
                    ArticleField.PARAGRAPH_TEXT -> paragraph.copyWithErrorsCheck(text = input ?: "")
                    ArticleField.PARAGRAPH_IMAGE_URI -> paragraph.copyWithErrorsCheck(imageUri = input)
                    else -> paragraph
                }
            } else {
                paragraph
            }
        }
        article = article.copy(content = updatedParagraphs)
    }

    fun onTypeValueChange(input: Type) {
        article = article.copyWithErrorsCheck(type = input, typeId = input.id)
    }

    fun onAddTags(addingTags: List<Tag>) {
        article = article.copyWithErrorsCheck(tags = addingTags, tagIds = addingTags.map { it.id!! })
    }

    fun onSearchTag(query: String) {
        tags.clear()
        tags.addAll(searchTags(query))
    }

    fun onAddParagraph() {
        val newParagraph = Paragraph.Draft()
        val updatedParagraphs = article.content + newParagraph
        article = article.copy(content = updatedParagraphs)
    }

    fun onRemoveParagraph(id: String) {
        val updatedParagraphs = article.content.filter { it.id != id }
        article = article.copy(content = updatedParagraphs)
    }

    fun onAddQuote() {
        article = article.copy(quote = "")
    }

    fun onRemoveQuote() {
        article = article.copy(quote = null)
    }

    fun onShareClick() {
        article = article.copy(date = Date())
        article = article.checkError()

        if (article.errors.isEmpty()) {
            triggerSnackbar("Well done!")
        } else {
            triggerSnackbar(article.errors.joinToString())
        }
    }
}