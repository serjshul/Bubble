package com.serjshul.bubble.ui.screens.common.article

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.serjshul.bubble.R
import com.serjshul.bubble.data.getArticleById
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleDestinationsArgs.ARTICLE_ID_ARG
import com.serjshul.bubble.ui.BubbleViewModel
import com.serjshul.bubble.ui.components.messages.ErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    logService: LogService
) : BubbleViewModel(logService) {
    private val viewModelState = MutableStateFlow(
        ArticleViewModelState(
            isLoading = true
        )
    )

    val uiState = viewModelState
        .map(ArticleViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        launchCatching {
            val articleId = savedStateHandle.get<String>(ARTICLE_ID_ARG)
            val article = getArticleById(articleId)
            viewModelState.update {
                if (article == null) {
                    val errorMessages = it.errorMessages + ErrorMessage(
                        id = UUID.randomUUID().mostSignificantBits,
                        messageId = R.string.error_load
                    )
                    it.copy(
                        isLoading = false,
                        errorMessages = errorMessages
                    )
                } else {
                    it.copy(
                        isLoading = false,
                        article = article
                    )
                }
            }
        }
    }
}

sealed interface ArticleUiState {
    val isLoading: Boolean
    val errorMessages: List<ErrorMessage>

    data class NoArticle(
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>
    ) : ArticleUiState

    data class HasArticle(
        val article: Article,
        override val isLoading: Boolean,
        override val errorMessages: List<ErrorMessage>
    ) : ArticleUiState
}

private data class ArticleViewModelState(
    val article: Article? = null,
    val isLoading: Boolean = false,
    val errorMessages: List<ErrorMessage> = emptyList()
) {
    fun toUiState(): ArticleUiState =
        if (article == null) {
            ArticleUiState.NoArticle(
                isLoading = isLoading,
                errorMessages = errorMessages,
            )
        } else {
            ArticleUiState.HasArticle(
                article = article,
                isLoading = isLoading,
                errorMessages = errorMessages
            )
        }
}