package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: AddArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    AddArticleScreenContent()
}

@Composable
fun AddArticleScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    )
}

@Preview
@Composable
fun AddArticleScreenContentPreview() {
    AddArticleScreenContent()
}