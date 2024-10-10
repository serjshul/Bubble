package com.serjshul.bubble.ui.screens.main.feed

import androidx.lifecycle.SavedStateHandle
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleDestinations
import com.serjshul.bubble.ui.BubbleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    logService: LogService
) : BubbleViewModel(logService) {

    fun onAddArticleClick(openScreen: (String) -> Unit) {
        openScreen(BubbleDestinations.ADD_ARTICLE_ROUTE)
    }
}