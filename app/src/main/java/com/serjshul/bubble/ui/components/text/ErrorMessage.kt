package com.serjshul.bubble.ui.components.text

import androidx.annotation.StringRes

data class ErrorMessage(
    val id: Long,
    @StringRes val messageId: Int
)