package com.serjshul.bubble.ui.screens.common.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.serjshul.bubble.R
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.loading.FullScreenLoading
import com.serjshul.bubble.ui.components.loading.LoadingContent

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
private fun ArticleScreenContent(
    modifier: Modifier = Modifier,
    uiState: ArticleUiState
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        LoadingContent(
            modifier = Modifier.padding(it),
            empty = when (uiState) {
                is ArticleUiState.HasArticle -> false
                is ArticleUiState.NoArticle -> uiState.isLoading
            },
            emptyContent = { FullScreenLoading() },
            loading = uiState.isLoading,
            onRefresh = { /*TODO*/ }
        ) {
            when (uiState) {
                is ArticleUiState.HasArticle ->
                    Content(article = uiState.article)
                is ArticleUiState.NoArticle -> {
                    if (uiState.errorMessages.isEmpty()) {
                        NoContent(onClick = { /* TODO */ })
                    } else {
                        Error()
                    }
                }
            }
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    article: Article
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Gray))
}

@Composable
private fun NoContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier.fillMaxSize(),
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = R.string.error_no_content),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun Error(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.error_load),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ContentPreview() {
    Content(article = articles[0])
}

@Preview
@Composable
fun NoContentPreview() {
    NoContent(onClick = { /* TODO */ })
}

@Preview
@Composable
fun ErrorPreview() {
    Error()
}