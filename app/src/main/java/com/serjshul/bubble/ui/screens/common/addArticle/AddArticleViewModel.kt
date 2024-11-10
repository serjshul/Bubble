package com.serjshul.bubble.ui.screens.common.addArticle

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.serjshul.bubble.data.searchTags
import com.serjshul.bubble.data.users
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.model.collections.Tag
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

    var isSelectTypeOpened by mutableStateOf(false)
        private set
    var isSelectTagsOpened by mutableStateOf(false)
        private set

    var title by mutableStateOf("")
        private set
    var type by mutableStateOf("")
        private set
    var creator by mutableStateOf("")
        private set
    var year by mutableStateOf("")
        private set
    var tags = mutableStateListOf<Tag>()
        private set
    var description by mutableStateOf("")
        private set
    var paragraphs = mutableStateListOf<Paragraph>()
        private set

    var backgroundUri by mutableStateOf<Uri?>(null)
    var coverUri by mutableStateOf<Uri?>(null)

    var isArticleValid by mutableStateOf(false)
        private set

    private fun checkArticleOnValid() {
//        isArticleValid = article.title != "" && article.description != "" &&
//                article.creator != "" && article.type != "" && article.color != "" &&
//                article.year != null && article.coverUrl != null && !article.content.isEmpty()
        isArticleValid = title != "" && type != "" && creator != "" && year != "" &&
                tags.isNotEmpty() && description != ""
    }

    fun setIsSelectTypeOpened(input: Boolean) {
        isSelectTypeOpened = input
    }

    fun setIsSelectTagsOpened(input: Boolean) {
        isSelectTagsOpened = input
    }

    fun onTitleValueChange(input: String) {
        title = input
        checkArticleOnValid()
    }

    fun onTypeValueChange(input: String) {
        type = input
        checkArticleOnValid()
    }

    fun onCreatorValueChange(input: String) {
        creator = input
        checkArticleOnValid()
    }

    fun onYearValueChange(input: String) {
        year = input
        checkArticleOnValid()
    }

    fun onTagsAdd(addingTags: List<Tag>) {
        tags.clear()
        tags.addAll(addingTags)
        checkArticleOnValid()
    }

    fun onSearchTag(query: String): List<Tag> {
        return searchTags(query)
    }

    fun onDescriptionValueChange(input: String) {
        description = input
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
}