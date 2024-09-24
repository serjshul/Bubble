package com.serjshul.bubble.ui.screens.common.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ArticleScreenContent(
        modifier = modifier,
        uiState = uiState
    )
}

@Composable
fun ArticleScreenContent(
    modifier: Modifier = Modifier,
    uiState: ArticleUiState
) {
    val articleState = when (uiState) {
        is ArticleUiState.HasArticle -> uiState.article
        is ArticleUiState.NoArticle -> null
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
//            if (article != null) {
//                Text(
//                    modifier = Modifier.align(Alignment.CenterHorizontally),
//                    text = article.aid!!
//                )
//            }
        }
    }
}

@Preview
@Composable
fun ArticleScreenPreview() {
//    ArticleScreenContent(
//        article = articles[0]
//    )
}