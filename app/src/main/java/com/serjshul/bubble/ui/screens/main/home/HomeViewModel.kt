package com.serjshul.bubble.ui.screens.main.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.ui.BubbleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    logService: LogService
) : BubbleViewModel(logService) {
    init {
        Log.d(TAG, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
    }
}