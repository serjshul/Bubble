package com.serjshul.bubble.ui.utils

import androidx.compose.ui.graphics.Color

val String.getColor
    get() = Color(android.graphics.Color.parseColor(this))