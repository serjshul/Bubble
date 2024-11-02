package com.serjshul.bubble.ui.screens.common.addArticle

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.R
import com.serjshul.bubble.model.collections.Tag
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.ui.components.buttons.AddTextFilledButton
import com.serjshul.bubble.ui.components.buttons.CloseIconToggleButton
import com.serjshul.bubble.ui.components.cards.Owner
import com.serjshul.bubble.ui.components.dialogs.SelectTagsDialog
import com.serjshul.bubble.ui.components.dialogs.SelectTypeDialog
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.components.text.TextInput
import com.serjshul.bubble.ui.theme.md_theme_background_gradient
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.theme.md_theme_light_secondary
import java.util.Date

@Composable
fun AddArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: AddArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    AddArticleScreenContent(
        modifier = modifier,
        isSelectTypeOpened = viewModel.isSelectTypeOpened,
        isSelectTagsOpened = viewModel.isSelectTagsOpened,
        title = viewModel.title,
        type = viewModel.type,
        creator = viewModel.creator,
        year = viewModel.year,
        tags = viewModel.tags,
        description = viewModel.description,
        backgroundUri = viewModel.backgroundUri,
        currentUser = viewModel.currentUser,
        setIsSelectTypeOpened = viewModel::setIsSelectTypeOpened,
        setIsSelectTagsOpened = viewModel::setIsSelectTagsOpened,
        onTitleValueChange = viewModel::onTitleValueChange,
        onTypeValueChange = viewModel::onTypeValueChange,
        onCreatorValueChange = viewModel::onCreatorValueChange,
        onYearValueChange = viewModel::onYearValueChange,
        onSearchTag = viewModel::onSearchTag,
        onTagsAdd = viewModel::onTagsAdd,
        onDescriptionValueChange = viewModel::onDescriptionValueChange,
        setLauncherBackgroundUri = viewModel::setLauncherBackgroundUri
    )
}

@Composable
fun AddArticleScreenContent(
    modifier: Modifier = Modifier,
    isSelectTypeOpened: Boolean,
    isSelectTagsOpened: Boolean,
    title: String,
    type: String,
    creator: String,
    year: String,
    tags: List<Tag>,
    description: String,
    backgroundUri: Uri?,
    currentUser: User,
    setIsSelectTypeOpened: (Boolean) -> Unit,
    setIsSelectTagsOpened: (Boolean) -> Unit,
    onTitleValueChange: (String) -> Unit,
    onTypeValueChange: (String) -> Unit,
    onCreatorValueChange: (String) -> Unit,
    onYearValueChange: (String) -> Unit,
    onSearchTag: (String) -> List<Tag>,
    onTagsAdd: (List<Tag>) -> Unit,
    onDescriptionValueChange: (String) -> Unit,
    setLauncherBackgroundUri: (Uri?) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        setLauncherBackgroundUri(uri)
    }

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
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (backgroundUri != null) {
                        BackgroundAsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(screenHeight * 1 / 2),
                            url = backgroundUri,
                            contentDescription = stringResource(id = R.string.image_background)
                        )
                        CloseIconToggleButton(
                            modifier = Modifier
                                .padding(top = 50.dp, end = 10.dp)
                                .align(Alignment.TopEnd),
                            backgroundColor = md_theme_light_secondary,
                            tint = md_theme_light_onSecondary,
                            onClick = { setLauncherBackgroundUri(null) }
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(screenHeight * 1 / 2)
                                .background(Brush.verticalGradient(md_theme_background_gradient))
                        )
                    }
                    Owner(
                        modifier = Modifier
                            .padding(top = 55.dp)
                            .align(Alignment.TopCenter),
                        nickname = currentUser.nickname!!,
                        photoUrl = currentUser.photoUrl!!,
                        onOwnerClick = { }
                    )
                    if (backgroundUri == null) {
                        AddTextFilledButton(
                            modifier = Modifier
                                .padding(top = 110.dp)
                                .align(Alignment.TopCenter),
                            text = "Add a background",
                            onClick = { launcher.launch("image/*") },
                            contentColor = md_theme_light_onSecondary,
                            containerColor = md_theme_light_secondary
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = screenHeight * 1 / 2 - 210.dp)
                    ) {
                        TextInput(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
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
                                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                                .align(Alignment.CenterHorizontally)
                                .clickable { setIsSelectTypeOpened(true) },
                            text = if (type == "") "Type" else type,
                            textAlign = TextAlign.Center,
                            color = if (type == "") md_theme_transparent_gray else md_theme_light_onPrimary,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
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
                                    .clickable { setIsSelectTagsOpened(true) },
                                text = if (tags.isEmpty()) "Tags" else tags.joinToString(),
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = if (tags.isEmpty()) md_theme_transparent_gray else md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                                .background(md_theme_light_onPrimary)
                        ) {
                            TextInput(
                                text = description,
                                placeholderText = "Description",
                                style = MaterialTheme.typography.bodyMedium,
                                textColor = md_theme_light_onBackground,
                                placeholderTextColor = md_theme_light_onBackgroundVariant,
                                textAlign = TextAlign.Start,
                                onValueChange = onDescriptionValueChange
                            )
                        }
                    }
                }
            }
//            item {
//
//            }
        }
        if (isSelectTypeOpened) {
            SelectTypeDialog(
                type = type,
                types = listOf(
                    "Film", "TV Show", "Book", "Music", "Podcast", "Blogger", "Youtube", "Tiktok",
                    "Instagram", "Twitch", "X", "Threads", "Reddit", "Brand", "Meme"
                ),
                onTypeValueChange = onTypeValueChange,
                onDismissRequest = { setIsSelectTypeOpened(false) }
            )
        }
        if (isSelectTagsOpened) {
            SelectTagsDialog(
                type = type,
                tags = tags,
                onSearchTag = onSearchTag,
                onTagsAdd = onTagsAdd,
                setIsSelectTypeOpened = setIsSelectTypeOpened,
                onDismissRequest = { setIsSelectTagsOpened(false) }
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
        isSelectTypeOpened = false,
        isSelectTagsOpened = false,
        title = "",
        type = "",
        creator = "",
        year = "",
        tags = listOf(),
        description = "",
        backgroundUri = null,
        setIsSelectTypeOpened = { },
        setIsSelectTagsOpened = { },
        onTitleValueChange = { },
        onTypeValueChange = { },
        onCreatorValueChange = { },
        onYearValueChange = { },
        onSearchTag = { _ -> listOf() },
        onTagsAdd = { },
        onDescriptionValueChange = { },
        setLauncherBackgroundUri = { }
    )
}