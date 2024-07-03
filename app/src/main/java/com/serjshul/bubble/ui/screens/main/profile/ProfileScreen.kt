package com.serjshul.bubble.ui.screens.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serjshul.bubble.ui.components.bars.ProfileTopAppBar
import com.serjshul.bubble.ui.components.buttons.CustomFilledButton
import com.serjshul.bubble.ui.components.buttons.CustomOutlinedButton
import com.serjshul.bubble.ui.components.buttons.CustomOutlinedIconButton
import com.serjshul.bubble.ui.components.buttons.IconButtonType
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    var isFollowing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val tabs = listOf("Posts", "Collections", "Replies")
    var tabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProfileTopAppBar(
                onBackClick = {},
                onNotificationsClick = {},
                onSettingsClick = {},
                onMoreClick = {}
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 5.dp)
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(end = 5.dp)
                    ) {
                        Text(
                            text = "Serge, 21",
                            color = md_theme_light_onBackground,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "@serjshul",
                            color = md_theme_light_onBackground,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    ProfileAsyncImage(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(70.dp)
                            .align(Alignment.CenterVertically),
                        url = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
                        contentDescription = ""
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = "Graduated from SPbSTU, read a lot of books just to download yet another app",
                    color = md_theme_light_onBackground,
                    maxLines = 4,
                    lineHeight = 22.sp,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(
                        modifier = Modifier.clickable {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "TODO: see followers method",  // TODO: see followers method
                                    withDismissAction = true
                                )
                            }
                        },
                        text = "${35.1}K followers",
                        color = md_theme_light_onBackgroundVariant,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "  •  ",
                        color = md_theme_light_onBackgroundVariant,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        modifier = Modifier.clickable {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "TODO: see following method",  // TODO: see following method
                                    withDismissAction = true
                                )
                            }
                        },
                        text = "${103} following",
                        color = md_theme_light_onBackgroundVariant,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Row(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    if (isFollowing) {
                        CustomOutlinedButton(
                            modifier = Modifier
                                .weight(4f)
                                .padding(end = 10.dp),
                            text = "Following",
                            contentColor = md_theme_light_onBackground,
                            onClick = {
                                isFollowing = false
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "TODO: unfollow method",  // TODO: unfollow method
                                        withDismissAction = true
                                    )
                                }
                            }
                        )
                    } else {
                        CustomFilledButton(
                            modifier = Modifier
                                .weight(4f)
                                .padding(end = 10.dp),
                            text = "Follow",
                            contentColor = md_theme_light_onPrimary,
                            containerColor = md_theme_light_primary,
                            onClick = {
                                isFollowing = true
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "TODO: follow method",  // TODO: follow method
                                        withDismissAction = true
                                    )
                                }
                            }
                        )
                    }

                    CustomOutlinedButton(
                        modifier = Modifier
                            .weight(4f)
                            .padding(end = 10.dp),
                        text = "Message",
                        contentColor = md_theme_light_onBackground,
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "TODO: send message method",  // TODO: send message method
                                    withDismissAction = true
                                )
                            }
                        }
                    )
                    Box(modifier = Modifier.weight(1f)) {
                        CustomOutlinedIconButton(
                            modifier = Modifier,
                            iconButtonType = IconButtonType.SIMILAR_PROFILES,
                            color = md_theme_light_onBackground,
                            onClick = {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "TODO: see similar profiles method",  // TODO: see similar profiles method
                                        withDismissAction = true
                                    )
                                }
                            }
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                TabRow(
                    selectedTabIndex = tabIndex,
                    contentColor = md_theme_light_onBackground,
                    containerColor = md_theme_light_background,
                    indicator = { tabPositions ->
                        if (tabIndex < tabPositions.size) {
                            TabRowDefaults.SecondaryIndicator(
                                modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                                color = md_theme_light_onBackground
                            )
                        }
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index }
                        )
                    }
                }
                when (tabIndex) {
                    0 -> {} //HomeScreen()
                    1 -> {} //AboutScreen()
                    2 -> {} //SettingsScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}