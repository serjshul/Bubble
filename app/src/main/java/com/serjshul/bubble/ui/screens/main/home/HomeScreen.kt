package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.serjshul.bubble.ui.components.CustomCenterAlignedTopAppBar
import com.serjshul.bubble.ui.theme.md_theme_light_background

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(md_theme_light_background),
        topBar = {
            CustomCenterAlignedTopAppBar(
                onAddArticleClick = {},
                onSearchArticleClick = {}
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(md_theme_light_background)
        ) {
            Banner(
                title = "Radical Optimism",
                description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, which has many interesting ideas for songs and a surprisingly low hit rate.",
                backgroundLink = "",
                onReadClick = {},
                onAddToFavoritesClick = {},
                onNotInterestedClick = {}
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}