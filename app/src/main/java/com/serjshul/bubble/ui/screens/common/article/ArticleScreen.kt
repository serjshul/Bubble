package com.serjshul.bubble.ui.screens.common.article

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.serjshul.bubble.R
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.cards.Owner
import com.serjshul.bubble.ui.components.interaction.InteractionPanelArticle
import com.serjshul.bubble.ui.components.loading.FullScreenLoading
import com.serjshul.bubble.ui.components.loading.LoadingContent
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.components.text.ParagraphText
import com.serjshul.bubble.ui.components.text.QuoteText
import com.serjshul.bubble.ui.theme.md_theme_dark_gradient
import com.serjshul.bubble.ui.theme.md_theme_transparent
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import kotlinx.coroutines.CoroutineScope

@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ArticleScreenContent(
        modifier = modifier,
        uiState = uiState,
        isCommentsOpened = viewModel.isCommentsOpened,
        onLikeClick = viewModel::onLikeClick,
        onCommentsClick = viewModel::onCommentsClick,
        onRepostClick = viewModel::onRepostClick,
        showDevelopInfo = viewModel::showDevelopInfo,
        popUpScreen = popUpScreen
    )
}

@Composable
private fun ArticleScreenContent(
    modifier: Modifier = Modifier,
    uiState: ArticleUiState,
    isCommentsOpened: Boolean,
    onLikeClick: () -> Unit,
    onCommentsClick: () -> Unit,
    onRepostClick: () -> Unit,
    showDevelopInfo: (String, SnackbarHostState, CoroutineScope) -> Unit,
    popUpScreen: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LoadingContent(
            modifier = Modifier.fillMaxSize(),
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
                    Content(
                        article = uiState.article,
                        isCommentsOpened = isCommentsOpened,
                        onLikeClick = onLikeClick,
                        onCommentsClick = onCommentsClick,
                        onRepostClick = onRepostClick,
                        showDevelopInfo = showDevelopInfo,
                        popUpScreen = popUpScreen
                    )
                is ArticleUiState.NoArticle -> {
                    if (uiState.errorTexts.isEmpty()) {
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
    article: Article,
    isCommentsOpened: Boolean,
    onLikeClick: () -> Unit,
    onCommentsClick: () -> Unit,
    onRepostClick: () -> Unit,
    showDevelopInfo: (String, SnackbarHostState, CoroutineScope) -> Unit,
    popUpScreen: () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val listState = rememberLazyListState()
    val isScrolledBelow by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                state = listState
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenHeight * 1 / 2)
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
                                .background(Brush.verticalGradient(md_theme_dark_gradient))
                        )
                        Owner(
                            modifier = Modifier
                                .padding(top = 55.dp)
                                .align(Alignment.TopCenter),
                            nickname = article.owner!!.nickname!!,
                            photoUrl = article.owner!!.photoUrl!!,
                            onOwnerClick = {
                                // TODO: open owner's profile method
                                showDevelopInfo("TODO: open owner's profile method", snackbarHostState, scope)
                            }
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, bottom = 40.dp, end = 15.dp)
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
                                    text = article.year.toString(),
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
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(15.dp)
                                .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                                .background(md_theme_light_onPrimary)
                                .align(Alignment.BottomCenter)
                        )
                    }
                }
                item {
                    Text(
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                        text = article.description!!,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                items(article.content) { paragraph ->
                    ParagraphText(
                        modifier = Modifier.padding(start = 15.dp, top = 20.dp, end = 15.dp),
                        paragraph = paragraph,
                        articleColor = article.color!!
                    )
                }
                if (article.quote != null) {
                    item {
                        QuoteText(
                            modifier = Modifier.padding(start = 15.dp, top = 25.dp, end = 15.dp),
                            quote = article.quote,
                            color = article.color!!
                        )
                    }
                }
                item {
                    InteractionPanelArticle(
                        modifier = Modifier.padding(15.dp, 20.dp),
                        isLiked = article.isLiked!!,
                        isCommentsOpened = isCommentsOpened,
                        isReposted = article.isReposted!!,
                        date = article.date!!,
                        onLikeCLick = onLikeClick,
                        onCommentsCLick = onCommentsClick,
                        onRepostCLick = onRepostClick
                    )
                }
            }

            ArticleTopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                title = article.title!!,
                type = article.type!!,
                articleColor = article.color!!,
                isScrolledBelow = isScrolledBelow,
                onBackClick = popUpScreen
            )
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
fun Error(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    type: String,
    articleColor: String,
    isScrolledBelow: Boolean,
    onBackClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val containerColor =
        if (!isScrolledBelow)
            Color.Transparent
        else
            md_theme_light_background
    val titleContentColor =
        if (!isScrolledBelow)
            md_theme_light_onPrimary
        else
            articleColor.toColor()
    val shadowElevation: Dp by animateDpAsState(
        if (!isScrolledBelow) 0.dp else 6.dp,
        label = "shadowElevation"
    )

    Surface(
        modifier = modifier,
        color = md_theme_transparent,
        shadowElevation = shadowElevation
    ) {
        CenterAlignedTopAppBar(
            modifier = modifier.height(50.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = containerColor,
                titleContentColor = titleContentColor
            ),
            title = {
                Box(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .basicMarquee(),
                        text = if (isScrolledBelow) title else type,
                        maxLines = 1,
                        color = titleContentColor,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.action_back),
                        tint = titleContentColor,
                        contentDescription = stringResource(id = R.string.icon_button_back)
                    )
                }
            },
            scrollBehavior = scrollBehavior,
        )
    }
}

@Preview
@Composable
fun ContentPreview() {
    Content(
        article = articles[0],
        isCommentsOpened = false,
        onLikeClick = { },
        onCommentsClick = { },
        onRepostClick = { },
        showDevelopInfo = { _, _, _ -> },
        popUpScreen = { }
    )
}

@Preview
@Composable
fun NoContentPreview() {
    NoContent(onClick = { })
}

@Preview
@Composable
fun ErrorPreview() {
    Error()
}

@Preview
@Composable
fun ArticleTopAppBarNotScrolledBelowPreview() {
    ArticleTopAppBar(
        title = "Lady Bird",
        type = "Movie",
        articleColor = "#c22f2f",
        isScrolledBelow = false,
        onBackClick = { }
    )
}

@Preview
@Composable
fun ArticleTopAppBarScrolledBelowPreview() {
    ArticleTopAppBar(
        title = "Lady Bird",
        type = "Movie",
        articleColor = "#c22f2f",
        isScrolledBelow = true,
        onBackClick = { }
    )
}