package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.ui.components.cards.Banner
import com.serjshul.bubble.ui.components.cards.Quote
import com.serjshul.bubble.ui.components.lists.BubblesList
import com.serjshul.bubble.ui.components.lists.CardsList
import com.serjshul.bubble.ui.components.lists.SmallCardsList
import com.serjshul.bubble.ui.theme.md_theme_light_background

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreenContent(
        modifier = modifier,
        banner = viewModel.banner
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    banner: Article
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(md_theme_light_background),
        topBar = {
            HomeTopAppBar(
                onAddArticleClick = {},
                onSearchArticleClick = {}
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
                    onReadClick = {},
                    onAddToFavoritesClick = {},
                    onNotInterestedClick = {}
                )
            }
            item {
                CardsList(
                    title = "Cards list",
                    content = articles
                )
            }
            item {
                BubblesList(
                    title = "Bubbles list",
                    content = articles
                )
            }
            item {
                Quote(
                    article = articles[2],
                    onOpenClick = { }
                )
            }
            item {
                SmallCardsList(
                    title = "Small cards list",
                    content = articles
                )
            }
            item {
                Quote(
                    article = articles[0],
                    onOpenClick = { }
                )
            }
            item {
                Banner(
                    modifier = Modifier,
                    article = banner,
                    onReadClick = {},
                    onAddToFavoritesClick = {},
                    onNotInterestedClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        banner = articles[0]
    )
}