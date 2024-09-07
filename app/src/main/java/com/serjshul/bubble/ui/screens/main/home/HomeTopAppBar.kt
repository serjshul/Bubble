package com.serjshul.bubble.ui.screens.main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.outfitFontFamily

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
fun HomeTopAppBarPreview() {
    HomeTopAppBar(
        onAddArticleClick = {},
        onSearchArticleClick = {}
    )
}