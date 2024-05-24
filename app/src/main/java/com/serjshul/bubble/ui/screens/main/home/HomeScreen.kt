package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "Home",
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}