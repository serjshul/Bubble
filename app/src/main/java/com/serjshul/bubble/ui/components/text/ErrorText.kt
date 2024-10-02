package com.serjshul.bubble.ui.components.text

import androidx.annotation.StringRes

data class ErrorText(
    val id: Long,
    @StringRes val messageId: Int
)