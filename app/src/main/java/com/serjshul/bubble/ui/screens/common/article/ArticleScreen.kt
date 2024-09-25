package com.serjshul.bubble.ui.screens.common.article

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.serjshul.bubble.R
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.loading.FullScreenLoading
import com.serjshul.bubble.ui.components.loading.LoadingContent
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_gradient
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.utils.roundedCornerShape

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
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight * 2 / 5)
                ) {
                    if (article.backgroundUrl != null) {
                        BackgroundAsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            url = article.backgroundUrl,
                            contentDescription = "Background image"
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(article.color!!.toColor())
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Brush.verticalGradient(md_theme_gradient))
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 15.dp, bottom = 35.dp, end = 15.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 15.dp)
                                .basicMarquee(),
                            text = article.title!!,
                            textAlign = TextAlign.Center,
                            color = md_theme_light_onPrimary,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Row(
                            modifier = modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                text = article.creator!!,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 0.dp),
                                text = "/",
                                color = md_theme_light_onPrimary,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                text = article.type!!,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 0.dp),
                                text = "/",
                                color = md_theme_light_onPrimary,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                text = article.tags.joinToString(),
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = screenHeight * 2 / 5 - 20.dp)
                        .roundedCornerShape()
                        .background(md_theme_light_onPrimary)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp),
                        text = article.description!!,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
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