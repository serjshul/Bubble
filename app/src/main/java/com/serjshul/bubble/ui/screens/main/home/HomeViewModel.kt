package com.serjshul.bubble.ui.screens.main.home

import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleDestinations
import com.serjshul.bubble.ui.BubbleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    logService: LogService
) : BubbleViewModel(logService) {

    val banner = articlesUI.random()

    fun onArticleClick(openScreen: (String) -> Unit, articleId: String) {
        openScreen("${BubbleDestinations.ARTCILE_ROUTE}/$articleId")
    }
}