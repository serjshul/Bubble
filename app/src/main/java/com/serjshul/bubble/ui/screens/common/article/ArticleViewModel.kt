package com.serjshul.bubble.ui.screens.common.article

import com.serjshul.bubble.data.articles
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    logService: LogService
) : BubbleViewModel(logService) {

    val article = articles[0]

}