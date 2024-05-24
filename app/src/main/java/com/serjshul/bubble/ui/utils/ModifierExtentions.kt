package com.serjshul.bubble.ui.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

fun Modifier.roundedCornerShape() = clip(RoundedCornerShape(20.dp))
