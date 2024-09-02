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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.R
import com.serjshul.bubble.data.articles
import com.serjshul.bubble.data.users
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.ui.components.buttons.SimilarProfilesOutlinedIconButton
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.buttons.TextOutlinedButton
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.components.cards.Post
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import kotlinx.coroutines.CoroutineScope

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    ProfileScreenContent(
        modifier = modifier,
        tabIndex = viewModel.tabIndex,
        user = viewModel.user,
        articles = viewModel.posts,
        comments = viewModel.comments,
        likes = viewModel.likes,
        onTabClick = viewModel::onTabClick,
        showDevelopInfo = viewModel::showDevelopInfo
    )
}

@Composable
fun ProfileScreenContent(
    modifier: Modifier = Modifier,
    tabIndex: Int,
    user: User,
    articles: List<Article>,
    comments: List<Article>,
    likes: List<Article>,
    onTabClick: (Int, Boolean, LazyListState, CoroutineScope) -> Unit,
    showDevelopInfo: (String, SnackbarHostState, CoroutineScope) -> Unit
) {
    val tabs = listOf(R.string.tab_posts, R.string.tab_comments, R.string.tab_likes)

    var isFollowing by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val lazyListState: LazyListState = rememberLazyListState()

    val isProfileHidden by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 1
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProfileTopAppBar(
                nickname = "sdfklsdjf",
                tabs = tabs,
                tabIndex = tabIndex,
                isFollowing = isFollowing,
                isProfileHidden = isProfileHidden,
                lazyListState = lazyListState,
                scope = scope,
                onBackClick = { },
                onNotificationsClick = { },
                onSettingsClick = { },
                onMoreClick = { },
                onTabClick = onTabClick
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(md_theme_light_background)
                .padding(it),
            state = lazyListState
        ) {
            item {
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
                                text = user.name!!,
                                color = md_theme_light_onBackground,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                modifier = Modifier.padding(top = 5.dp),
                                text = "@" + user.nickname!!,
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
                            url = user.photoUrl!!,
                            contentDescription = "User's photo"
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        text = user.bio!!,
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
                                // TODO: see followers method
                                showDevelopInfo("TODO: see followers method", snackbarHostState, scope)
                            },
                            text = "${user.followers.size} followers",
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
                                // TODO: see following method
                                showDevelopInfo("TODO: see following method", snackbarHostState, scope)
                            },
                            text = "${user.following.size} following",
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
                            TextOutlinedButton(
                                modifier = Modifier
                                    .weight(4f)
                                    .padding(end = 10.dp),
                                text = "Following",
                                contentColor = md_theme_light_onBackground,
                                onClick = {
                                    isFollowing = false
                                    // TODO: unfollow method
                                    showDevelopInfo("TODO: unfollow method", snackbarHostState, scope)
                                }
                            )
                        } else {
                            TextFilledButton(
                                modifier = Modifier
                                    .weight(4f)
                                    .padding(end = 10.dp),
                                text = "Follow",
                                contentColor = md_theme_light_onPrimary,
                                containerColor = md_theme_light_primary,
                                onClick = {
                                    isFollowing = true
                                    // TODO: follow method
                                    showDevelopInfo("TODO: follow method", snackbarHostState, scope)
                                }
                            )
                        }

                        TextOutlinedButton(
                            modifier = Modifier
                                .weight(4f)
                                .padding(end = 10.dp),
                            text = "Message",
                            contentColor = md_theme_light_onBackground,
                            onClick = {
                                // TODO: send message method
                                showDevelopInfo("TODO: send message method", snackbarHostState, scope)
                            }
                        )
                        Box(modifier = Modifier.weight(1f)) {
                            SimilarProfilesOutlinedIconButton(
                                color = md_theme_light_onBackground,
                                onClick = {
                                    // TODO: see similar profiles method
                                    showDevelopInfo("TODO: see similar profiles method", snackbarHostState, scope)
                                }
                            )
                        }
                    }
                }
            }

            item {
                TabRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp),
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
                    tabs.forEachIndexed { index, titleId ->
                        Tab(text = { Text(stringResource(id = titleId)) },
                            selected = tabIndex == index,
                            onClick = { onTabClick(index, isProfileHidden, lazyListState, scope) }
                        )
                    }
                }
            }

            when (tabIndex) {
                0 -> {
                    items(articles) { article ->
                        Post(
                            article = article,
                            onLikeCLick = {
                                // TODO: like click method
                                showDevelopInfo("TODO: like click method", snackbarHostState, scope)
                            },
                            onCommentCLick = {
                                // TODO: comment click method
                                showDevelopInfo("TODO: comment click method", snackbarHostState, scope)
                            },
                            onRepostCLick = {
                                // TODO: repost click method
                                showDevelopInfo("TODO: repost click method", snackbarHostState, scope)
                            },
                            onSaveCLick = {
                                // TODO: save click method
                                showDevelopInfo("TODO: save click method", snackbarHostState, scope)
                            },
                            currentUid = "",
                            openArticleScreen = { },
                            openOwnerScreen = { }
                        )
                    }
                }
                1 -> {
                    items(comments) { reply ->
                        Post(
                            article = reply,
                            onLikeCLick = {
                                // TODO: like click method
                                showDevelopInfo("TODO: like click method", snackbarHostState, scope)
                            },
                            onCommentCLick = {
                                // TODO: comment click method
                                showDevelopInfo("TODO: comment click method", snackbarHostState, scope)
                            },
                            onRepostCLick = {
                                // TODO: repost click method
                                showDevelopInfo("TODO: repost click method", snackbarHostState, scope)
                            },
                            onSaveCLick = {
                                // TODO: save click method
                                showDevelopInfo("TODO: save click method", snackbarHostState, scope)
                            },
                            currentUid = "",
                            openArticleScreen = { },
                            openOwnerScreen = { }
                        )
                    }
                }
                2 -> {
                    items(likes) { like ->
                        Post(
                            article = like,
                            onLikeCLick = {
                                // TODO: like click method
                                showDevelopInfo("TODO: like click method", snackbarHostState, scope)
                            },
                            onCommentCLick = {
                                // TODO: comment click method
                                showDevelopInfo("TODO: comment click method", snackbarHostState, scope)
                            },
                            onRepostCLick = {
                                // TODO: repost click method
                                showDevelopInfo("TODO: repost click method", snackbarHostState, scope)
                            },
                            onSaveCLick = {
                                // TODO: save click method
                                showDevelopInfo("TODO: save click method", snackbarHostState, scope)
                            },
                            currentUid = "",
                            openArticleScreen = { },
                            openOwnerScreen = { }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreenContent(
        modifier = Modifier.fillMaxSize(),
        tabIndex = 0,
        user = users[0],
        articles = articles,
        comments = articles,
        likes = articles,
        onTabClick = { _, _, _, _ -> },
        showDevelopInfo = { _, _, _ -> }
    )
}