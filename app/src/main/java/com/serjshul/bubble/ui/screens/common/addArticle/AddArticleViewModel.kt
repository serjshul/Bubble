package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import com.serjshul.bubble.data.users
import com.serjshul.bubble.model.collections.Article
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

    var article by mutableStateOf(
        Article(
            title = "",
            description = "",
            creator = "",
            type = "",
            color = ""
        )
    )
        private set
    var isArticleValid by mutableStateOf(false)
        private set

    private fun checkArticleOnValid() {
        isArticleValid = article.title != "" && article.description != "" &&
                article.creator != "" && article.type != "" && article.color != "" &&
                article.year != null && article.coverUrl != null && !article.content.isEmpty()
    }
}