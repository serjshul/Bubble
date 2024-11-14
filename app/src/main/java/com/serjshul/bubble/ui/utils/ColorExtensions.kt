package com.serjshul.bubble.ui.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun Color.toARGBString() = String.format("#%08X", this.toArgb())

fun Color.lighten(factor: Float) = Color(
    (this.red + factor).coerceAtMost(1f),
    (this.green + factor).coerceAtMost(1f),
    (this.blue + factor).coerceAtMost(1f),
    this.alpha
)