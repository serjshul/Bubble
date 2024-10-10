package com.serjshul.bubble.ui.screens.common.article

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.serjshul.bubble.R
import com.serjshul.bubble.data.getArticleById
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleDestinationsArgs.ARTICLE_ID_ARG
import com.serjshul.bubble.ui.BubbleViewModel
import com.serjshul.bubble.ui.components.text.ErrorText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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

    var isCommentsOpened by mutableStateOf(false)
        private set

    init {
        launchCatching {
            val articleId = savedStateHandle.get<String>(ARTICLE_ID_ARG)
            val article = getArticleById(articleId)
            viewModelState.update {
                if (article == null) {
                    val errorTexts = it.errorTexts + ErrorText(
                        id = UUID.randomUUID().mostSignificantBits,
                        messageId = R.string.error_load
                    )
                    it.copy(
                        isLoading = false,
                        errorTexts = errorTexts
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

    fun showDevelopInfo(info: String, snackbarHostState: SnackbarHostState, scope: CoroutineScope) {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = info,
                withDismissAction = true
            )
        }
    }

    fun onLikeClick() {
        launchCatching {
            // TODO: add like to the article and the user
            viewModelState.update {
                it.copy(
                    isLoading = false,
                    article = it.article!!.copy(isLiked = !it.article.isLiked!!)
                )
            }
        }
    }

    fun onCommentsClick() {
        isCommentsOpened = !isCommentsOpened
        // TODO: open comments
    }

    fun onRepostClick() {
        launchCatching {
            // TODO: add repost to the article and the user
            viewModelState.update {
                it.copy(
                    isLoading = false,
                    article = it.article!!.copy(isReposted = !it.article.isReposted!!)
                )
            }
        }
    }
}

sealed interface ArticleUiState {
    val isLoading: Boolean
    val errorTexts: List<ErrorText>

    data class NoArticle(
        override val isLoading: Boolean,
        override val errorTexts: List<ErrorText>
    ) : ArticleUiState

    data class HasArticle(
        val article: Article,
        override val isLoading: Boolean,
        override val errorTexts: List<ErrorText>
    ) : ArticleUiState
}

private data class ArticleViewModelState(
    val article: Article? = null,
    val isLoading: Boolean = false,
    val errorTexts: List<ErrorText> = emptyList()
) {
    fun toUiState(): ArticleUiState =
        if (article == null) {
            ArticleUiState.NoArticle(
                isLoading = isLoading,
                errorTexts = errorTexts,
            )
        } else {
            ArticleUiState.HasArticle(
                article = article,
                isLoading = isLoading,
                errorTexts = errorTexts
            )
        }
}