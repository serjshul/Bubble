package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.serjshul.bubble.data.users
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddArticleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    logService: LogService
) : BubbleViewModel(logService) {

    val currentUser = users[0]

    var title by mutableStateOf("")
        private set
    var type by mutableStateOf("")
        private set
    var creator by mutableStateOf("")
        private set
    var year by mutableStateOf("")
        private set
    var isArticleValid by mutableStateOf(false)
        private set

    private fun checkArticleOnValid() {
//        isArticleValid = article.title != "" && article.description != "" &&
//                article.creator != "" && article.type != "" && article.color != "" &&
//                article.year != null && article.coverUrl != null && !article.content.isEmpty()
        isArticleValid = title != "" && creator != "" && year != ""
    }

    fun onTitleValueChange(input: String) {
        title = input
        checkArticleOnValid()
    }

    fun onTypeSelect(input: String) {
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
}