package com.serjshul.bubble.ui.screens.main.profile

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.data.users
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    logService: LogService
) : BubbleViewModel(logService) {

    var tabIndex by mutableIntStateOf(0)

    val user = users[0]
    val posts = articles
    var postssIndex by mutableIntStateOf(2)
    val comments = listOf(articles[1], articles[1], articles[1], articles[1])
    var commentsIndex by mutableIntStateOf(2)
    val likes = listOf(articles[2], articles[2], articles[2], articles[2])
    var likesIndex by mutableIntStateOf(2)

    fun onTabClick(index: Int, isProfileHidden: Boolean, lazyListState: LazyListState, scope: CoroutineScope) {
        when (tabIndex) {
            0 -> postssIndex = if (lazyListState.firstVisibleItemIndex < 2) 2 else  lazyListState.firstVisibleItemIndex
            1 -> commentsIndex = if (lazyListState.firstVisibleItemIndex < 2) 2 else  lazyListState.firstVisibleItemIndex
            2 -> likesIndex = if (lazyListState.firstVisibleItemIndex < 2) 2 else  lazyListState.firstVisibleItemIndex
        }
        scope.launch {
            if (isProfileHidden) {
                when (index) {
                    0 -> lazyListState.scrollToItem(postssIndex)
                    1 -> lazyListState.scrollToItem(commentsIndex)
                    2 -> lazyListState.scrollToItem(likesIndex)
                }
            }
        }
        tabIndex = index
    }

    fun showDevelopInfo(info: String, snackbarHostState: SnackbarHostState, scope: CoroutineScope) {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = info,
                withDismissAction = true
            )
        }
    }
}