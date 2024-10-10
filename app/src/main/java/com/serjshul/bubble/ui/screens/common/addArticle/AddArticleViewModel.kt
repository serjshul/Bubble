package com.serjshul.bubble.ui.screens.common.addArticle

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

    // state with current user
}