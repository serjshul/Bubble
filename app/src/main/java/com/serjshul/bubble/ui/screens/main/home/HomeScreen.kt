package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.ui.components.bars.CustomCenterAlignedTopAppBar
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.utils.getColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(md_theme_light_background)
        ) {
            item {
                Banner(
                    modifier = Modifier,
                    title = "Radical Optimism",
                    description = "Dua Lipa’s star power sounds muffled on her much-anticipated third album, which has many interesting ideas for songs and a surprisingly low hit rate.",
                    coverUrl = "https://vinyla.com/files/products/40/106/209002/photo-2024-03-15-10-38-20.1280x1280.jpg?c258d668158a54a172e09aa86daa2731",
                    color = "#055c62".getColor,
                    onReadClick = {},
                    onAddToFavoritesClick = {},
                    onNotInterestedClick = {}
                )
            }
            items (20) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.White)
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}