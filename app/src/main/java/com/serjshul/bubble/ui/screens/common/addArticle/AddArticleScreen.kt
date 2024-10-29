package com.serjshul.bubble.ui.screens.common.addArticle

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.R
import com.serjshul.bubble.data.getTagsByType
import com.serjshul.bubble.model.collections.Tag
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.buttons.TextOutlinedButton
import com.serjshul.bubble.ui.components.cards.Owner
import com.serjshul.bubble.ui.components.text.TextInput
import com.serjshul.bubble.ui.theme.md_theme_background_gradient
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_transparent
import com.serjshul.bubble.ui.utils.roundedCornerShape
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
        type = viewModel.type,
        creator = viewModel.creator,
        year = viewModel.year,
        currentUser = viewModel.currentUser,
        onTitleValueChange = viewModel::onTitleValueChange,
        onTypeSelect = viewModel::onTypeSelect,
        onCreatorValueChange = viewModel::onCreatorValueChange,
        onYearValueChange = viewModel::onYearValueChange
    )
}

@Composable
fun AddArticleScreenContent(
    modifier: Modifier = Modifier,
    title: String,
    type: String,
    creator: String,
    year: String,
    currentUser: User,
    onTitleValueChange: (String) -> Unit,
    onTypeSelect: (String) -> Unit,
    onCreatorValueChange: (String) -> Unit,
    onYearValueChange: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    var isSelectTypeOpened by remember { mutableStateOf(false) }

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
                                .padding(bottom = 5.dp)
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
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 15.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable { isSelectTypeOpened = true },
                            text = if (type == "") "Type" else type,
                            textAlign = TextAlign.Center,
                            color = if (type == "") md_theme_transparent_gray else md_theme_light_onPrimary,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            style = MaterialTheme.typography.titleMedium,
                        )
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
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .align(Alignment.CenterVertically)
                                    .clickable { },
                                text = "tags",
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_transparent_gray,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
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
        if (isSelectTypeOpened) {
            SelectType(
                selectedType = type,
                types = listOf(
                    "Film", "TV Show", "Book", "Music", "Podcast", "Blogger", "Youtube", "Tiktok",
                    "Instagram", "Twitch", "X", "Threads", "Reddit", "Brand", "Meme"
                ),
                onDone = onTypeSelect,
                onDismissRequest = { isSelectTypeOpened = false }
            )
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
        type = "",
        creator = "",
        year = "",
        onTitleValueChange = { },
        onTypeSelect = { },
        onCreatorValueChange = { },
        onYearValueChange = { }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectType(
    modifier: Modifier = Modifier,
    selectedType: String,
    types: List<String>,
    onDone: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
    var currentlySelectedType by remember { mutableStateOf(selectedType) }

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .roundedCornerShape()
                    .background(md_theme_light_background)
                    .padding(15.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Choose the type",
                    color = md_theme_light_onBackground,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
                ContextualFlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .wrapContentHeight(align = Alignment.Top),
                    horizontalArrangement = Arrangement.Center,
                    itemCount = types.size
                ) { index ->
                    FilterChip(
                        modifier = Modifier
                            .padding(5.dp, 0.dp),
                        onClick = { currentlySelectedType = types[index] },
                        label = {
                            Text(
                                text = types[index],
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        colors =  FilterChipDefaults.filterChipColors(
                            containerColor = md_theme_light_background,
                            labelColor = md_theme_light_onBackground,
                            selectedContainerColor = md_theme_light_primary,
                            selectedLabelColor = md_theme_light_onPrimary
                        ),
                        selected = currentlySelectedType == types[index]
                    )
                }
                TextOutlinedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    text = "Add the type",
                    contentColor = md_theme_light_onBackground,
                    onClick = { }
                )
                TextFilledButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp),
                    text = "Done",
                    enabled = currentlySelectedType != "",
                    containerColor = md_theme_light_primary,
                    contentColor = md_theme_light_onPrimary,
                    onClick = {
                        onDone(currentlySelectedType)
                        onDismissRequest()
                    }
                )
            }
            IconButton(
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.TopEnd),
                onClick = { onDismissRequest() }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.action_exit),
                    tint = md_theme_light_onBackground,
                    contentDescription = stringResource(id = R.string.icon_button_back)
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectTypePreview() {
    SelectType(
        selectedType = "",
        types = listOf(
            "Film", "TV Show", "Book", "Music", "Podcast", "Blogger", "Youtube", "Tiktok",
            "Instagram", "Twitch", "X", "Threads", "Reddit", "Brand", "Meme"
        ),
        onDone = { },
        onDismissRequest = { }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectTags(
    modifier: Modifier = Modifier,
    type: String,
    tags: List<Tag>
) {
    val totalCount = tags.size
    var maxLines by remember { mutableStateOf(3) }

    val moreOrCollapseIndicator = @Composable { scope: ContextualFlowRowOverflowScope ->
        val remainingItems = totalCount - scope.shownItemCount
        SuggestionChip(
            modifier = Modifier.padding(5.dp, 0.dp),
            label = { Text(text = if (remainingItems == 0) "Show Less" else "Show more") },
            colors = SuggestionChipDefaults.suggestionChipColors(
                containerColor = md_theme_light_primary,
                labelColor = md_theme_light_onPrimary
            ),
            border = BorderStroke(
                width = 1.dp,
                color = md_theme_transparent
            ),
            onClick = {
                maxLines = if (remainingItems == 0) 3 else Int.MAX_VALUE
            }
        )
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            text = type + "'s tags",
            color = md_theme_light_onBackground,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
        )
        ContextualFlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .wrapContentHeight(align = Alignment.Top),
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
                modifier = Modifier
                    .padding(5.dp, 0.dp),
                onClick = { selected = !selected },
                label = { Text(tags[index].value!!) },
                selected = selected
            )
        }
    }
}

@Preview
@Composable
fun SelectTagsPreview() {
    SelectTags(
        type = "Film",
        tags = getTagsByType("Film")
    )
}