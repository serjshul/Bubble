package com.serjshul.bubble.ui.screens.main.profile

import androidx.compose.material3.SnackbarHostState
import com.serjshul.bubble.data.articlesDemo
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

    val posts = articlesDemo

    fun showDevelopInfo(info: String, snackbarHostState: SnackbarHostState, scope: CoroutineScope) {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = info,
                withDismissAction = true
            )
        }
    }
}