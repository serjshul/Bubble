package com.serjshul.bubble.ui.screens.main.profile

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        modifier = modifier.height(50.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = md_theme_light_background,
            titleContentColor = md_theme_light_onBackground,
        ),
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.navigation_back),
                    contentDescription = stringResource(id = R.string.icon_button_back)
                )
            }
        },
        actions = {
            IconButton(onClick = { onNotificationsClick() }) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.action_notifications),
                    contentDescription = stringResource(id = R.string.icon_button_notifications)
                )
            }
            IconButton(onClick = { onSettingsClick() }) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.action_settings),
                    contentDescription = stringResource(id = R.string.icon_button_settings)
                )
            }
            IconButton(onClick = { onMoreClick() }) {
                Icon(
                    modifier = Modifier.size(30.dp).align(Alignment.CenterVertically),
                    imageVector = ImageVector.vectorResource(id = R.drawable.action_more),
                    contentDescription = stringResource(id = R.string.icon_button_more)
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@Preview
@Composable
fun ProfileTopAppBarPreview() {
    ProfileTopAppBar(
        onBackClick = {},
        onNotificationsClick = {},
        onSettingsClick = {},
        onMoreClick = {}
    )
}