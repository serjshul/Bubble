package com.serjshul.bubble.ui.screens.main.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.R
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.buttons.TextOutlinedButton
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar(
    modifier: Modifier = Modifier,
    nickname: String,
    tabs: List<Int>,
    tabIndex: Int,
    isFollowing: Boolean,
    isProfileHidden: Boolean,
    scope: CoroutineScope,
    lazyListState: LazyListState,
    onBackClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onMoreClick: () -> Unit,
    onTabClick: (Int, Boolean, LazyListState, CoroutineScope) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    var isFollowingState by remember { mutableStateOf(isFollowing) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CenterAlignedTopAppBar(
            modifier = modifier.height(50.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = md_theme_light_background,
                titleContentColor = md_theme_light_onBackground,
            ),
            title = {
                if (isProfileHidden) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(screenWidth - 120.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(bottom = 4.dp),
                            text = nickname,
                            color = md_theme_light_onBackground,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                } else {
                    Text(text = "")
                }
            },
            navigationIcon = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.action_back),
                        contentDescription = stringResource(id = R.string.icon_button_back)
                    )
                }
            },
            actions = {
                if (!isProfileHidden) {
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
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.CenterVertically),
                            imageVector = ImageVector.vectorResource(id = R.drawable.action_more),
                            contentDescription = stringResource(id = R.string.icon_button_more)
                        )
                    }
                } else {
                    if (isFollowingState) {
                        TextOutlinedButton(
                            text = "Following",
                            contentColor = md_theme_light_onBackground,
                            onClick = {
                                isFollowingState = false
                                // TODO: unfollow method
                                //showDevelopInfo("TODO: unfollow method", snackbarHostState, scope)
                            }
                        )
                    } else {
                        TextFilledButton(
                            text = "Follow",
                            contentColor = md_theme_light_onPrimary,
                            containerColor = md_theme_light_primary,
                            onClick = {
                                isFollowingState = true
                                // TODO: follow method
                                //showDevelopInfo("TODO: follow method", snackbarHostState, scope)
                            }
                        )
                    }
                }
            },
            scrollBehavior = scrollBehavior,
        )

        AnimatedVisibility(isProfileHidden) {
            TabRow(
                modifier = Modifier
                    .fillMaxWidth(),
                selectedTabIndex = tabIndex,
                contentColor = md_theme_light_onBackground,
                containerColor = md_theme_light_background,
                indicator = { tabPositions ->
                    if (tabIndex < tabPositions.size) {
                        TabRowDefaults.SecondaryIndicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex
                            ]),
                            color = md_theme_light_onBackground
                        )
                    }
                }
            ) {
                tabs.forEachIndexed { index, titleId ->
                    Tab(text = { Text(stringResource(id = titleId)) },
                        selected = tabIndex == index,
                        onClick = { onTabClick(index, isProfileHidden, lazyListState, scope) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileTopAppBarPreview() {
    ProfileTopAppBar(
        nickname = "@serjshu",
        tabs = listOf(R.string.tab_posts, R.string.tab_comments, R.string.tab_likes),
        tabIndex = 0,
        isFollowing = false,
        isProfileHidden = false,
        lazyListState = rememberLazyListState(),
        scope = rememberCoroutineScope(),
        onBackClick = { },
        onNotificationsClick = { },
        onSettingsClick = { },
        onMoreClick = { },
        onTabClick = { _, _, _, _ -> }
    )
}

@Preview
@Composable
fun ProfileTopAppBarScrollingPreview() {
    ProfileTopAppBar(
        nickname = "@serjshu",
        tabs = listOf(R.string.tab_posts, R.string.tab_comments, R.string.tab_likes),
        tabIndex = 0,
        isFollowing = false,
        isProfileHidden = true,
        lazyListState = rememberLazyListState(),
        scope = rememberCoroutineScope(),
        onBackClick = { },
        onNotificationsClick = { },
        onSettingsClick = { },
        onMoreClick = { },
        onTabClick = { _, _, _, _ -> }
    )
}