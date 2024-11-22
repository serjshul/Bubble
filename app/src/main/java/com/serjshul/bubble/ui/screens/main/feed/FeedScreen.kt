package com.serjshul.bubble.ui.screens.main.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = hiltViewModel(),
    openScreen: (String) -> Unit,
    popUpScreen: () -> Unit
) {
    FeedScreenContent(
        modifier = modifier,
        onAddArticleClick = viewModel::onAddArticleClick,
        openScreen = openScreen,
        popUpScreen = popUpScreen
    )
}

@Composable
fun FeedScreenContent(
    modifier: Modifier = Modifier,
    onAddArticleClick: ((String) -> Unit) -> Unit,
    openScreen: (String) -> Unit,
    popUpScreen: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingAddArticleButton(
                onAddArticleClick = onAddArticleClick,
                openScreen = openScreen
            )
        }
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.LightGray)
        ) {
            Text(
                text = "Feed",
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun FeedScreenContentPreview() {
    FeedScreenContent(
        onAddArticleClick = { },
        openScreen = { },
        popUpScreen = { }
    )
}

@Composable
fun FloatingAddArticleButton(
    onAddArticleClick: ((String) -> Unit) -> Unit,
    openScreen: (String) -> Unit,
) {
    FloatingActionButton(
        onClick = { onAddArticleClick(openScreen) },
        shape = CircleShape,
        containerColor = md_theme_light_primary,
        contentColor = md_theme_light_onPrimary,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.icon_button_add_atricle)
        )
    }
}

@Preview
@Composable
fun FloatingAddArticleButtonPreview() {
    FloatingAddArticleButton(
        onAddArticleClick = { },
        openScreen = { }
    )
}