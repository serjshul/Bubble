package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.serjshul.bubble.data.getAllTags
import com.serjshul.bubble.data.getAllTypes
import com.serjshul.bubble.data.searchTags
import com.serjshul.bubble.data.users
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.ArticleField
import com.serjshul.bubble.model.subcollections.Paragraph
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.subcollections.Type
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

    var isSelectTypeOpened by mutableStateOf(false)
        private set
    var isSelectTagsOpened by mutableStateOf(false)
        private set
    var errors = mutableStateListOf<ArticleField>()
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

    fun setIsSelectTypeOpened(input: Boolean) {
        isSelectTypeOpened = input
    }

    fun setIsSelectTagsOpened(input: Boolean) {
        isSelectTagsOpened = input
    }

    fun onArticleValueChange(field: ArticleField, input: String?) {
        when (field) {
            ArticleField.TITLE -> {
                article = article.copy(title = input ?: "")
                if (input == "") {
                    errors.add(ArticleField.TITLE)
                } else {
                    errors.remove(ArticleField.TITLE)
                }
            }
            ArticleField.CREATOR -> {
                article = article.copy(creator = input ?: "")
                if (input == "") {
                    errors.add(ArticleField.CREATOR)
                } else {
                    errors.remove(ArticleField.CREATOR)
                }
            }
            ArticleField.YEAR -> {
                article = article.copy(year = if (input == null || input == "") null else input.toInt())
                if (input == null || input == "") {
                    errors.add(ArticleField.YEAR)
                } else {
                    errors.remove(ArticleField.YEAR)
                }
            }
            ArticleField.DESCRIPTION -> {
                article = article.copy(description = input ?: "")
                if (input == "") {
                    errors.add(ArticleField.DESCRIPTION)
                } else {
                    errors.remove(ArticleField.DESCRIPTION)
                }
            }
            ArticleField.QUOTE -> {
                article = article.copy(quote = input)
                if (input == "") {
                    errors.add(ArticleField.QUOTE)
                } else {
                    errors.remove(ArticleField.QUOTE)
                }
            }
            ArticleField.COVER_URI -> {
                article = article.copy(coverUri = input)
                if (input == "") {
                    errors.add(ArticleField.COVER_URI)
                } else {
                    errors.remove(ArticleField.COVER_URI)
                }
            }
            ArticleField.BACKGROUND_URI -> article = article.copy(backgroundUri = input)
            else -> article = article.copy(color = input ?: md_theme_light_primary.toARGBString())
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
        article = article.copy(type = input, typeId = input.id)
        errors.remove(ArticleField.TYPE)
    }

    fun onAddTags(addingTags: List<Tag>) {
        article = article.copy(tags = addingTags, tagIds = addingTags.map { it.id!! })
        errors.remove(ArticleField.TAGS)
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

    fun onShareClick() {
        article = article.copy(date = Date())

        val currentErrors = article.whereIsError()
        errors.clear()
        errors.addAll(currentErrors)

        if (errors.isEmpty()) {
            triggerSnackbar("Well done!")
        } else {
            triggerSnackbar(errors.joinToString())
        }
    }
}