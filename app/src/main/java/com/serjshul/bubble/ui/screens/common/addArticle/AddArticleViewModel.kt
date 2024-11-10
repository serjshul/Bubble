package com.serjshul.bubble.ui.screens.common.addArticle

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.serjshul.bubble.data.getAllTypes
import com.serjshul.bubble.data.searchTags
import com.serjshul.bubble.data.users
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
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

    var isSelectTypeOpened by mutableStateOf(false)
        private set
    var isSelectTagsOpened by mutableStateOf(false)
        private set

    var article by mutableStateOf(
        Article(
            id = UUID.randomUUID().toString(),
            userId = currentUser.id,
            title = "",
            description = "",
            creator = "",
            coverUrl = null,
            backgroundUrl = null,
        )
    )


    var paragraphs = mutableStateListOf<Paragraph>()
        private set

    var backgroundUri by mutableStateOf<Uri?>(null)
    var coverUri by mutableStateOf<Uri?>(null)





    init {
        val allTypes = getAllTypes()
        types.addAll(allTypes)
    }

    fun setIsSelectTypeOpened(input: Boolean) {
        isSelectTypeOpened = input
    }

    fun setIsSelectTagsOpened(input: Boolean) {
        isSelectTagsOpened = input
    }

    fun onTitleValueChange(input: String) {
        article = article.copy(title = input)
        checkArticleOnValid()
    }

    fun onTypeValueChange(input: Type) {
        article = article.copy(type = input, typeId = input.id)
        checkArticleOnValid()
    }

    fun onCreatorValueChange(input: String) {
        article = article.copy(creator = input)
        checkArticleOnValid()
    }

    fun onYearValueChange(input: String) {
        article = article.copy(year = input.toInt())
        checkArticleOnValid()
    }

    fun onTagsAdd(addingTags: List<Tag>) {
        article = article.copy(tags = addingTags, tagIds = addingTags.map { it.id!! })
        checkArticleOnValid()
    }

    fun onSearchTag(query: String): List<Tag> {
        return searchTags(query)
    }




    fun onDescriptionValueChange(input: String) {
        article = article.copy(description = input)
        checkArticleOnValid()
    }

    fun onBackgroundUriValueChange(uri: Uri?) {
        backgroundUri = uri
    }

    fun onCoverUriValueChange(uri: Uri?) {
        coverUri = uri
    }

    fun onParagraphTitleChangeValue(pid: String, input: String) {
        for (paragraph in paragraphs) {
            if (paragraph.id == pid) {
                val index = paragraphs.indexOf(paragraph)
                paragraphs[index] = paragraphs[index].copy(title = input)
            }
        }

    }

    fun onAddParagraph() {
        paragraphs.add(
            Paragraph(
                id = UUID.randomUUID().toString(),
                title = "",
                text = ""
            )
        )
    }

    fun onRemoveParagraph(index: Int) {
        paragraphs.removeAt(index)
    }




    private fun checkArticleOnValid() {
//        isArticleValid = article.title != "" && article.description != "" &&
//                article.creator != "" && article.type != "" && article.color != "" &&
//                article.year != null && article.coverUrl != null && !article.content.isEmpty()
//        isArticleValid = title != "" && type != "" && creator != "" && year != "" &&
//                tags.isNotEmpty() && description != ""
    }
}