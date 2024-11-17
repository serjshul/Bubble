package com.serjshul.bubble.ui.screens.common.addArticle

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.ArticleField
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.ui.components.buttons.AddImageButton
import com.serjshul.bubble.ui.components.buttons.AddParagraphButton
import com.serjshul.bubble.ui.components.buttons.AddQuoteButton
import com.serjshul.bubble.ui.components.buttons.AddTextFilledButton
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.cards.Owner
import com.serjshul.bubble.ui.components.dialogs.CoverDialog
import com.serjshul.bubble.ui.components.dialogs.SelectTagsDialog
import com.serjshul.bubble.ui.components.dialogs.SelectTypeDialog
import com.serjshul.bubble.ui.components.media.BackgroundAsyncImage
import com.serjshul.bubble.ui.components.media.DarkMutedColor
import com.serjshul.bubble.ui.components.input.ParagraphTextInput
import com.serjshul.bubble.ui.components.input.QuoteInput
import com.serjshul.bubble.ui.components.input.TextInput
import com.serjshul.bubble.ui.theme.md_theme_light_error
import com.serjshul.bubble.ui.theme.md_theme_light_errorContainer
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
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
        isSelectTypeOpened = viewModel.isSelectTypeOpened,
        isSelectTagsOpened = viewModel.isSelectTagsOpened,
        article = viewModel.article,
        types = viewModel.types,
        tags = viewModel.tags,
        currentUser = viewModel.currentUser,
        setIsSelectTypeOpened = viewModel::setIsSelectTypeOpened,
        setIsSelectTagsOpened = viewModel::setIsSelectTagsOpened,
        onArticleValueChange = viewModel::onArticleValueChange,
        onTypeValueChange = viewModel::onTypeValueChange,
        onSearchTag = viewModel::onSearchTag,
        onTagsAdd = viewModel::onAddTags,
        onParagraphValueChange = viewModel::onParagraphValueChange,
        onAddParagraph = viewModel::onAddParagraph,
        onRemoveParagraph = viewModel::onRemoveParagraph,
    )
}

@Composable
fun AddArticleScreenContent(
    modifier: Modifier = Modifier,
    isSelectTypeOpened: Boolean,
    isSelectTagsOpened: Boolean,
    article: Article.Draft,
    types: List<Type>,
    tags: List<Tag>,
    currentUser: User,
    setIsSelectTypeOpened: (Boolean) -> Unit,
    setIsSelectTagsOpened: (Boolean) -> Unit,
    onArticleValueChange: (ArticleField, String?) -> Unit,
    onTypeValueChange: (Type) -> Unit,
    onSearchTag: (String) -> Unit,
    onTagsAdd: (List<Tag>) -> Unit,
    onParagraphValueChange: (ArticleField, String, String?) -> Unit,
    onAddParagraph: () -> Unit,
    onRemoveParagraph: (String) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var launcherSource = ArticleField.COVER_URI
    var launcherParagraphId = ""
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        when (launcherSource) {
            ArticleField.COVER_URI -> {
                onArticleValueChange(
                    ArticleField.COVER_URI,
                    uri.toString()
                )
            }
            ArticleField.BACKGROUND_URI -> {
                onArticleValueChange(
                    ArticleField.BACKGROUND_URI,
                    uri.toString()
                )
            }
            ArticleField.PARAGRAPH_IMAGE_URI -> {
                onParagraphValueChange(
                    ArticleField.PARAGRAPH_IMAGE_URI,
                    launcherParagraphId,
                    uri.toString()
                )
            }
            else -> { }
        }
    }

    var isCoverOpened by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddings ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings)
        ) {
            item(key = "header") {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenHeight * 1 / 2)
                    ) {
                        if (article.backgroundUri != null) {
                            BackgroundAsyncImage(
                                modifier = Modifier.fillMaxSize(),
                                url = article.backgroundUri,
                                contentDescription = stringResource(id = R.string.image_background)
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(article.color.toColor())
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp, top = 50.dp)
                    ) {
                        AddImageButton(
                            modifier = Modifier
                                .size(
                                    screenWidth * 1 / 2 - 100.dp,
                                    (screenWidth * 1 / 2 - 100.dp) * 9 / 16
                                )
                                .clip(RoundedCornerShape(5.dp))
                                .align(Alignment.CenterStart),
                            imageUri = article.coverUri,
                            color = article.color.toColor(),
                            onCoverClick = { isCoverOpened = true },
                            onAddCoverClick = {
                                launcherSource = ArticleField.COVER_URI
                                launcher.launch("image/*")
                            }
                        )
                        Owner(
                            modifier = Modifier.align(Alignment.Center),
                            nickname = currentUser.nickname!!,
                            photoUrl = currentUser.photoUrl!!,
                            onOwnerClick = { /* TODO: */ }
                        )
                        AnimatedVisibility(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            visible = article.backgroundUri != null,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            TextFilledButton(
                                text = "Remove",
                                containerColor = article.color.toColor(),
                                contentColor = md_theme_light_onSecondary,
                                onClick = {
                                    onArticleValueChange(ArticleField.BACKGROUND_URI, null)
                                }
                            )
                        }
                    }
                    AnimatedVisibility(
                        modifier = Modifier
                            .padding(top = 120.dp)
                            .align(Alignment.TopCenter),
                        visible = article.backgroundUri == null,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        AddTextFilledButton(
                            text = "Add a background",
                            contentColor = article.color.toColor(),
                            containerColor = md_theme_light_onSecondary,
                            onClick = {
                                launcherSource = ArticleField.BACKGROUND_URI
                                launcher.launch("image/*")
                            }
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = screenHeight * 1 / 2 - 240.dp)
                    ) {
                        TextInput(
                            modifier = Modifier
                                .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
                                .roundedCornerShape()
                                .align(Alignment.CenterHorizontally),
                            text = article.title,
                            placeholderText = "Title",
                            isError = true,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 4,
                            textColor = md_theme_light_onPrimary,
                            placeholderTextColor = md_theme_transparent_gray,
                            textAlign = TextAlign.Center,
                            onValueChange = { onArticleValueChange(ArticleField.TITLE, it) }
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                                .align(Alignment.CenterHorizontally)
                                .roundedCornerShape()
                                .background(md_theme_light_errorContainer)
                                .padding(17.dp)
                                .clickable { setIsSelectTypeOpened(true) },
                            text = if (article.type == null) "Type" else article.type!!.toString(),
                            textAlign = TextAlign.Center,
                            color = md_theme_light_error,
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
                                    .weight(1f)
                                    .roundedCornerShape(),
                                text = article.creator,
                                placeholderText = "Creator",
                                isError = true,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4,
                                textColor = md_theme_light_onPrimary,
                                placeholderTextColor = md_theme_transparent_gray,
                                textAlign = TextAlign.Center,
                                onValueChange = { onArticleValueChange(ArticleField.CREATOR, it) }
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
                                    .weight(1f)
                                    .roundedCornerShape(),
                                text = if (article.year == null) "" else article.year.toString(),
                                placeholderText = "Year",
                                isError = true,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4,
                                textColor = md_theme_light_onPrimary,
                                placeholderTextColor = md_theme_transparent_gray,
                                textAlign = TextAlign.Center,
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number
                                ),
                                onValueChange = { onArticleValueChange(ArticleField.YEAR, it) }
                            )
                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 0.dp),
                                text = "/",
                                color = md_theme_light_onPrimary,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Box(
                                modifier =
                                    if (true)
                                        Modifier
                                            .weight(1f)
                                            .height(55.dp)
                                            .roundedCornerShape()
                                            .background(md_theme_light_errorContainer)
                                    else
                                        Modifier.weight(1f)
                            ) {
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .clickable { setIsSelectTagsOpened(true) },
                                    text = if (article.tags.isEmpty()) "Tags" else article.tags.joinToString(),
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Center,
                                    color = if (article.tags.isEmpty()) md_theme_transparent_gray else md_theme_light_onPrimary,
                                    style = MaterialTheme.typography.bodyMedium,
                                    maxLines = 4
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                                .background(md_theme_light_onPrimary)
                        ) {
                            TextInput(
                                text = article.description,
                                placeholderText = "Description",
                                isError = true,
                                style = MaterialTheme.typography.bodyMedium,
                                textColor = md_theme_light_onBackground,
                                placeholderTextColor = md_theme_light_onBackgroundVariant,
                                textAlign = TextAlign.Start,
                                onValueChange = {
                                    onArticleValueChange(ArticleField.DESCRIPTION, it)
                                }
                            )
                        }
                    }
                }
            }
            items(
                items = article.content,
                key = { paragraph -> paragraph.id!! }
            ) { paragraph ->
                ParagraphTextInput(
                    modifier = Modifier.animateItem(),
                    paragraph = paragraph,
                    color = article.color.toColor(),
                    onParagraphValueChange = onParagraphValueChange,
                    onRemoveClick = onRemoveParagraph,
                    onLauncherOpen = {
                        launcherSource = ArticleField.PARAGRAPH_IMAGE_URI
                        launcherParagraphId = paragraph.id!!
                        launcher.launch("image/*")
                    }
                )
            }
            item(key = "add_paragraph") {
                AddParagraphButton(
                    color = article.color.toColor(),
                    onClick = onAddParagraph
                )
            }
            item(key = "add_quote") {
                if (article.quote == null) {
                    AddQuoteButton(
                        modifier = Modifier.animateItem(),
                        color = article.color.toColor(),
                        onClick = { onArticleValueChange(ArticleField.QUOTE, "") }
                    )
                } else {
                    QuoteInput(
                        modifier = Modifier.animateItem(),
                        quote = article.quote!!,
                        color = article.color.toColor(),
                        onRemoveClick = { onArticleValueChange(ArticleField.QUOTE, null) },
                        onQuoteValueChange = { onArticleValueChange(ArticleField.QUOTE, it) }
                    )
                }
            }
        }
        if (isSelectTypeOpened) {
            SelectTypeDialog(
                type = article.type,
                types = types,
                onTypeValueChange = onTypeValueChange,
                onDismissRequest = { setIsSelectTypeOpened(false) }
            )
        }
        if (isSelectTagsOpened) {
            SelectTagsDialog(
                selectedType = article.type,
                selectedTags = article.tags,
                searchedTags = tags,
                onSearchTag = onSearchTag,
                onTagsAdd = onTagsAdd,
                setIsSelectTypeOpened = setIsSelectTypeOpened,
                onDismissRequest = { setIsSelectTagsOpened(false) }
            )
        }
        if (isCoverOpened) {
            CoverDialog(
                coverUri = article.coverUri,
                onCoverUriValueChange = { onArticleValueChange(ArticleField.COVER_URI, null) },
                onLauncherOpen = {
                    launcherSource = ArticleField.COVER_URI
                    launcher.launch("image/*")
                },
                onDismissRequest = { isCoverOpened = false }
            )
        }
    }
    DarkMutedColor(
        uri = article.backgroundUri ?: article.coverUri,
        onColorExtract = { color ->
            onArticleValueChange(ArticleField.COLOR, color)
        }
    )
}

@Preview
@Composable
fun AddArticleScreenContentNoDataPreview() {
    AddArticleScreenContent(
        currentUser = User(
            id = "237465719432",
            nickname = "serjshul",
            name = "Serge, 21",
            bio = "Graduated from SPbSTU, read a lot of books just to download yet another app",
            dateOfBirth = Date(),
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            articleIds = listOf("45g2j23fd8723", "jkef5s7dfjk23", "223fgh425kj2g3"),
            commentIds = emptyList(),
            likeIds = emptyList(),
            followers = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73"),
            following = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73")
        ),
        isSelectTypeOpened = false,
        isSelectTagsOpened = false,
        article = Article.Draft(),
        types = emptyList(),
        tags = emptyList(),
        setIsSelectTypeOpened = { },
        setIsSelectTagsOpened = { },
        onArticleValueChange = { _, _ -> },
        onTypeValueChange = { },
        onSearchTag = { },
        onTagsAdd = { },
        onParagraphValueChange = { _, _, _ -> },
        onAddParagraph = { },
        onRemoveParagraph = { }
    )
}

@Preview
@Composable
fun AddArticleScreenContentWithDataPreview() {
    AddArticleScreenContent(
        currentUser = User(
            id = "237465719432",
            nickname = "serjshul",
            name = "Serge, 21",
            bio = "Graduated from SPbSTU, read a lot of books just to download yet another app",
            dateOfBirth = Date(),
            photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
            articleIds = listOf("45g2j23fd8723", "jkef5s7dfjk23", "223fgh425kj2g3"),
            commentIds = emptyList(),
            likeIds = emptyList(),
            followers = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73"),
            following = listOf("hjk3h6j41204fsd", "354h6g13fh25jk7l73")
        ),
        isSelectTypeOpened = false,
        isSelectTagsOpened = false,
        article = Article.Draft(
            title = "Lady Bird",
            type = Type(value = "Movie"),
            creator = "Greta Gerwig",
            year = 2018,
            tags = listOf(
                Tag(id = "1ertf", typeId = "Film", value = "Drama"),
                Tag(id = "6regh", typeId = "Film", value = "Comedy")
            ),
            description = "Writer-director Greta Gerwig’s semiautobiographical Lady Bird is both generous " +
                    "and joyous, but when it stings, it stings deep. At one point, Saoirse Ronan, as " +
                    "disgruntled high school senior Christine, begs her mother, Laurie Metcalf’s Marion, " +
                    "for a magazine at the supermarket: “It’s only \$3! I’m having a bad week!” Marion " +
                    "brushes her off, and it could be the usual mom move of just saying no–until she " +
                    "reaches the cash register and you realize that this respectable-looking suburban " +
                    "woman can barely cover the family groceries.",
            content = listOf(
                Paragraph(
                    id = "klajsdfl",
                    title = "The endearing shagginess and goofy imperfection",
                    imageUri = "https://static01.nyt.com/images/2017/11/03/arts/03LADYBIRD1/03LADYBIRD1-superJumbo-v3.jpg",
                    text = "In the conversations that have ushered in its theatrical release, Lady Bird " +
                            "has been described as Greta Gerwig’s directorial debut. Yet, with seven " +
                            "screenplays to her name and a co-director credit on Joe Swanberg’s 2008 " +
                            "mumblecore drama Nights and Weekends, it’s not as though she is new to " +
                            "making movies. Still, the endearing shagginess and goofy imperfection " +
                            "associated with Gerwig’s work in front of and behind the camera are " +
                            "noticeably absent in this polished, muscular, Oscar-nominated debut proper. " +
                            "Not a criticism exactly, but perhaps an explanation for why the film has " +
                            "managed to transcend its indie dramedy trappings."
                ),
                Paragraph(
                    id = "dsnwlkn",
                    title = "Lady Bird’s coming of age",
                    imageUri = "https://compote.slate.com/images/65093ba9-f66a-4912-92a7-090af2f5ef20.jpeg?crop=1560%2C1040%2Cx0%2Cy0",
                    text = "Set in Sacramento, California in 2002, it centres on Christine “Lady Bird” " +
                            "McPherson (Saoirse Ronan), a high-schooler who behaves with the unselfconscious " +
                            "conviction of a young kid. She insists she be called by her “given” name of " +
                            "Lady Bird (“It was given to me, by me”), extols the benefits of bathtub " +
                            "masturbation to her best friend Julie while eating communion wafers (“They’re " +
                            "not consecrated!”) and jabs her crush in the shoulder, asking him to dance. " +
                            "Gerwig’s pink-haired protagonist is seemingly unencumbered by the awkwardness " +
                            "and fear that dogs most teenagers on the cusp of change. This cusp-ness " +
                            "is where the film’s magic resides; its joyful, forward-rushing narrative " +
                            "rhythm captures the feeling of adolescence ending before it has barely " +
                            "begun.\nThough the film gives us milestones from Lady Bird’s coming of age, " +
                            "its key preoccupation is the jagged relationship between Lady Bird and her " +
                            "mother Marion (Laurie Metcalf), an overworked nurse whose blunt pragmatism " +
                            "butts heads with her daughter’s dreams of moving to New York, “where culture " +
                            "is”. The scenes between Ronan and Metcalf are electric; Gerwig maps their " +
                            "inability to communicate with excruciating veracity."
                ),
                Paragraph(
                    id = "klsnwemdsfklnrw",
                    title = "The small things that make a good movie great",
                    imageUri = null,
                    text = "However, it is Gerwig’s tidy pacing, vividly drawn characters (see Timothée " +
                            "Chalamet’s bit-part as a floppy-haired mobile phone sceptic who smokes " +
                            "roll-ups and “trying as much as possible not to participate in our economy”), " +
                            "and eye for period detail (like her use of the Dave Matthews Band) that " +
                            "mark her as a keen observer of the small things that make a good movie great. " +
                            "Her writing is alive with beautiful bon mots, but also an acute sense of " +
                            "class anxiety in post-9/11, pre-financial crash suburban America, with " +
                            "the McPherson family’s worries about Lady Bird’s tuition fees given as " +
                            "much screen time as her romantic exploits."
                )
            ),
            backgroundUri = "",
            coverUri = ""
        ),
        types = emptyList(),
        tags = emptyList(),
        setIsSelectTypeOpened = { },
        setIsSelectTagsOpened = { },
        onArticleValueChange = { _, _ -> },
        onTypeValueChange = { },
        onSearchTag = { },
        onTagsAdd = { },
        onParagraphValueChange = { _, _, _ -> },
        onAddParagraph = { },
        onRemoveParagraph = { }
    )
}