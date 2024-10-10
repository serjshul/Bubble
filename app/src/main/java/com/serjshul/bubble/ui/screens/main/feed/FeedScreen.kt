package com.serjshul.bubble.ui.screens.main.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.ui.screens.common.addArticle.AddArticleViewModel

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: AddArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    FeedScreenContent(
        modifier = modifier,
        popUpScreen = popUpScreen
    )
}

@Composable
fun FeedScreenContent(
    modifier: Modifier = Modifier,
    popUpScreen: () -> Unit
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

@Preview
@Composable
fun FeedScreenContentPreview() {
    FeedScreenContent(
        popUpScreen = { }
    )
}