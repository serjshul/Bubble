package com.serjshul.bubble.ui.screens.main.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "Feed",
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}