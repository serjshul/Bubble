package com.serjshul.bubble.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serjshul.bubble.services.LogService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BubbleViewModel(
    private val logService: LogService
) : ViewModel() {
    fun launchCatching(
        snackBar: Boolean = true,
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(
        CoroutineExceptionHandler { _, throwable ->
            if (snackBar) {
                //SnackbarManager.showMessage(
                //    throwable.toSnackbarMessage()
                //)
            }
            logService.logNonFatalCrash(throwable)
        },
        block = block
    )
}