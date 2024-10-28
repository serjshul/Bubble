package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ContextualFlowRowOverflowScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.ui.components.cards.Owner
import com.serjshul.bubble.ui.components.text.TextInput
import com.serjshul.bubble.ui.theme.md_theme_background_gradient
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_transparent
import java.util.Date

@Composable
fun AddArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: AddArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    AddArticleScreenContent(
        modifier = modifier,
        title = viewModel.title,
        creator = viewModel.creator,
        year = viewModel.year,
        currentUser = viewModel.currentUser,
        onTitleValueChange = viewModel::onTitleValueChange,
        onCreatorValueChange = viewModel::onCreatorValueChange,
        onYearValueChange = viewModel::onYearValueChange
    )
}

@Composable
fun AddArticleScreenContent(
    modifier: Modifier = Modifier,
    title: String,
    creator: String,
    year: String,
    currentUser: User,
    onTitleValueChange: (String) -> Unit,
    onCreatorValueChange: (String) -> Unit,
    onYearValueChange: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    var tagsExpanded by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight * 1 / 2)
                        .background(
                            Brush.verticalGradient(md_theme_background_gradient)
                        )
                ) {
                    Owner(
                        modifier = Modifier
                            .padding(top = 55.dp)
                            .align(Alignment.TopCenter),
                        nickname = currentUser.nickname!!,
                        photoUrl = currentUser.photoUrl!!,
                        onOwnerClick = { }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 15.dp, bottom = 40.dp, end = 15.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        TextInput(
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                                .align(Alignment.CenterHorizontally),
                            text = title,
                            placeholderText = "Title",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 4,
                            textColor = md_theme_light_onPrimary,
                            placeholderTextColor = md_theme_transparent_gray,
                            textAlign = TextAlign.Center,
                            onValueChange = onTitleValueChange
                        )
                        // TODO: type
                        Row(
                            modifier = modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            TextInput(
                                modifier = Modifier
                                    .weight(1f),
                                text = creator,
                                placeholderText = "Creator",
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4,
                                textColor = md_theme_light_onPrimary,
                                placeholderTextColor = md_theme_transparent_gray,
                                textAlign = TextAlign.Center,
                                onValueChange = onCreatorValueChange
                            )
                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 0.dp),
                                text = "/",
                                color = md_theme_light_onPrimary,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            TextInput(
                                modifier = Modifier
                                    .weight(1f),
                                text = year,
                                placeholderText = "Year",
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4,
                                textColor = md_theme_light_onPrimary,
                                placeholderTextColor = md_theme_transparent_gray,
                                textAlign = TextAlign.Center,
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number
                                ),
                                onValueChange = onYearValueChange
                            )
                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 0.dp),
                                text = "/",
                                color = md_theme_light_onPrimary,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )

                            AnimatedContent(
                                modifier = Modifier.weight(1f),
                                targetState = tagsExpanded,
                                transitionSpec = {
                                    fadeIn(animationSpec = tween(150, 150)) togetherWith
                                            fadeOut(animationSpec = tween(150)) using SizeTransform { initialSize, targetSize ->
                                                if (targetState) {
                                                    keyframes {
                                                        // Expand horizontally first.
                                                        IntSize(targetSize.width, initialSize.height) at 150
                                                        durationMillis = 300
                                                    }
                                                } else {
                                                    keyframes {
                                                        // Shrink vertically first.
                                                        IntSize(initialSize.width, targetSize.height) at 150
                                                        durationMillis = 300
                                                    }
                                                }
                                            }
                                }, label = "size transform"
                            ) { targetExpanded ->
                                if (targetExpanded) {
                                    //Expanded()
                                } else {
                                    Text(
                                        modifier = Modifier
                                            .align(Alignment.CenterVertically)
                                            .clickable { tagsExpanded = true },
                                        text = "tags",
                                        overflow = TextOverflow.Ellipsis,
                                        textAlign = TextAlign.Center,
                                        color = md_theme_light_onPrimary,
                                        style = MaterialTheme.typography.bodyMedium,
                                        maxLines = 4
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(15.dp)
                            .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                            .background(md_theme_light_onPrimary)
                            .align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun AddArticleScreenContentPreview() {
    AddArticleScreenContent(
        currentUser = User(
            uid = "237465719432",
            nickname = "serjshul",
            name = "Serge, 21",
            bio = "Graduated from SPbSTU, read a lot of books just to download yet another app",
            dateOfBirth = Date(),
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            aids = listOf("45g2j23fd8723", "jkef5s7dfjk23", "223fgh425kj2g3"),
            cids = emptyList(),
            lids = emptyList(),
            followers = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73"),
            following = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73")
        ),
        title = "",
        creator = "",
        year = "",
        onTitleValueChange = { },
        onCreatorValueChange = { },
        onYearValueChange = { }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagsChips(
    modifier: Modifier = Modifier,
    filmsTags: List<String>,
    booksTags: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
//        Text(
//            modifier = Modifier.fillMaxWidth(),
//            text = "Film's tags",
//            color = md_theme_light_onBackground,
//            fontWeight = FontWeight.Bold,
//            style = MaterialTheme.typography.titleLarge,
//        )
        val totalCount = booksTags.size
        var maxLines by remember { mutableStateOf(3) }
        val moreOrCollapseIndicator = @Composable { scope: ContextualFlowRowOverflowScope ->
            val remainingItems = totalCount - scope.shownItemCount
            SuggestionChip(
                modifier = Modifier.padding(5.dp, 0.dp),
                label = { Text(text = if (remainingItems == 0) "Less" else "+ $remainingItems") },
                colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = md_theme_light_primary,
                    labelColor = md_theme_light_onPrimary
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = md_theme_transparent
                ),
                onClick = {
                    maxLines = if (remainingItems == 0) 3 else Int. MAX_VALUE
                }
            )
        }
        ContextualFlowRow(
            modifier = Modifier
                .safeDrawingPadding()
                .padding(top = 15.dp)
                .wrapContentHeight(align = Alignment.Top)
                .verticalScroll(rememberScrollState()),
            maxLines = maxLines,
            overflow = ContextualFlowRowOverflow.expandOrCollapseIndicator(
                minRowsToShowCollapse = 3,
                expandIndicator = moreOrCollapseIndicator,
                collapseIndicator = moreOrCollapseIndicator
            ),
            itemCount = totalCount
        ) { index ->
            var selected by remember { mutableStateOf(false) }
            FilterChip(
                modifier = Modifier.padding(5.dp, 0.dp),
                onClick = { selected = !selected },
                label = { Text(booksTags[index]) },
                selected = selected,
            )
        }
    }
}

@Preview
@Composable
fun TagsChipsPreview() {
    TagsChips(
        filmsTags = listOf("Drama", "Mystery", "Thriller", "Fantasy", "Horror", "Comedy", "Romance",
            "Crime", "Sci-Fi", "Biography"),
        booksTags = listOf("Fantasy", "Science Fiction", "Dystopian", "Action", "Adventure",
            "Mystery", "Thriller", "Suspense", "Historical Fiction", "Classics", "Graphic Novel",
            "Comic Book", "Detective")
    )
}