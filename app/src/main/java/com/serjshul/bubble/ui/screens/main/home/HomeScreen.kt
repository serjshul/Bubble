package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.R
import com.serjshul.bubble.data.articlesUI
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.ui.components.cards.Banner
import com.serjshul.bubble.ui.components.cards.Quote
import com.serjshul.bubble.ui.components.lists.BubblesList
import com.serjshul.bubble.ui.components.lists.CardsList
import com.serjshul.bubble.ui.components.lists.SmallCardsList
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.outfitFontFamily

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    openScreen: (String) -> Unit,
    popUpScreen: () -> Unit
) {
    HomeScreenContent(
        modifier = modifier,
        banner = viewModel.banner,
        openScreen = openScreen,
        popUpScreen = popUpScreen,
        onArticleClick = viewModel::onArticleClick
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    banner: Article,
    openScreen: (String) -> Unit,
    popUpScreen: () -> Unit,
    onArticleClick: ((String) -> Unit, String) -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(md_theme_light_background),
        topBar = {
            HomeTopAppBar(
                onAddArticleClick = { },
                onSearchArticleClick = { }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(md_theme_light_background)
        ) {
            item {
                Banner(
                    modifier = Modifier,
                    article = banner,
                    onReadClick = { },
                    onAddToFavoritesClick = { },
                    onNotInterestedClick = { }
                )
            }
            item {
                CardsList(
                    title = "Cards list",
                    content = articlesUI,
                    openScreen = openScreen,
                    onArticleClick = onArticleClick
                )
            }
            item {
                BubblesList(
                    title = "Bubbles list",
                    content = articlesUI
                )
            }
            item {
                Quote(
                    article = articlesUI[2],
                    onOpenClick = { }
                )
            }
            item {
                SmallCardsList(
                    title = "Small cards list",
                    content = articlesUI
                )
            }
            item {
                Quote(
                    article = articlesUI[0],
                    onOpenClick = { }
                )
            }
            item {
                Banner(
                    modifier = Modifier,
                    article = banner,
                    onReadClick = { },
                    onAddToFavoritesClick = { },
                    onNotInterestedClick = { }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    onAddArticleClick: () -> Unit,
    onSearchArticleClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        modifier = modifier.height(50.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = md_theme_light_background,
            titleContentColor = md_theme_light_onBackground,
        ),
        title = {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = stringResource(id = R.string.app_name),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = outfitFontFamily,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { onAddArticleClick() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.icon_button_add_atricle)
                )
            }
        },
        actions = {
            IconButton(onClick = { onSearchArticleClick() }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.icon_button_search_atricle)
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        banner = articlesUI[0],
        openScreen = { },
        popUpScreen = { },
        onArticleClick = { _, _ -> }
    )
}

@Preview
@Composable
fun HomeTopAppBarPreview() {
    HomeTopAppBar(
        onAddArticleClick = {},
        onSearchArticleClick = {}
    )
}