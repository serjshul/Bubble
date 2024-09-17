package com.serjshul.bubble.ui.screens.common.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article

@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel = hiltViewModel()
) {
    ArticleScreenContent(
        modifier = modifier,
        article = viewModel.article
    )
}

@Composable
fun ArticleScreenContent(
    modifier: Modifier = Modifier,
    article: Article,
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}

@Preview
@Composable
fun ArticleScreenPreview() {
    ArticleScreenContent(
        article = articles[0]
    )
}