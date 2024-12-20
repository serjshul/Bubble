package com.serjshul.bubble.ui.components.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.serjshul.bubble.R
import com.serjshul.bubble.model.subcollections.Tag
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.input.TextInput
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimaryContainer
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_light_primaryContainer
import com.serjshul.bubble.ui.theme.md_theme_transparent
import com.serjshul.bubble.ui.utils.roundedCornerShape
import java.util.UUID

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SelectTagsDialog(
    modifier: Modifier = Modifier,
    selectedType: Type?,
    selectedTags: List<Tag>,
    searchedTags: List<Tag>,
    onSearchTag: (String) -> Unit,
    onTagsAdd: (List<Tag>) -> Unit,
    setIsSelectTypeOpened: (Boolean) -> Unit,
    onDismissRequest: () -> Unit
) {
    val showingTags = remember {
        mutableStateListOf<Tag>().apply {
            addAll(selectedTags)
            addAll(searchedTags.filter { it !in selectedTags })
        }
    }
    val currentlySelectedTags = remember {
        mutableStateListOf<Tag>().apply {
            addAll(selectedTags)
        }
    }

    val maxItems = 11
    var isExpanded by remember { mutableStateOf(false) }

    var query by remember { mutableStateOf("") }
    var isNothingFound by remember { mutableStateOf(false) }
    var typedTag by remember {
        mutableStateOf(
            Tag(
                id = UUID.randomUUID().toString(),
                typeId = if (selectedType == null) "" else selectedType.id,
                value = ""
            )
        )
    }

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .roundedCornerShape()
                    .background(md_theme_light_background)
                    .padding(15.dp)
            ) {
                if (selectedType == null) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        text = "Please, select type first",
                        color = md_theme_light_onBackground,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                    TextFilledButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        text = "Select the type",
                        containerColor = md_theme_light_primary,
                        contentColor = md_theme_light_onPrimary,
                        onClick = {
                            onDismissRequest()
                            setIsSelectTypeOpened(true)
                        }
                    )
                } else {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Select tags",
                        color = md_theme_light_onBackground,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                    SearchBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        query = query,
                        onQueryChange = { query = it },
                        onSearch = {
                            onSearchTag(query)
                            showingTags.apply {
                                clear()
                                addAll(currentlySelectedTags)
                                addAll(searchedTags.filter { it !in selectedTags })
                            }
                            if (searchedTags.isEmpty()) {
                                isNothingFound = true
                            }
                        },
                        active = false,
                        onActiveChange = {  },
                        placeholder = {
                            Text(
                                text = "Enter your tag",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        },
                        colors = SearchBarDefaults.colors(
                            containerColor = md_theme_light_primaryContainer
                        ),
                        content = { }
                    )
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .wrapContentHeight(align = Alignment.Top)
                    ) {
                        var shownItems = 0
                        for (tag in showingTags) {
                            FilterChip(
                                modifier = Modifier.padding(5.dp, 0.dp),
                                onClick = {
                                    if (tag in currentlySelectedTags) {
                                        currentlySelectedTags.remove(tag)
                                    } else {
                                        currentlySelectedTags.add(tag)
                                    }
                                },
                                label = {
                                    Text(
                                        text = tag.value!!,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                selected = tag in currentlySelectedTags,
                                colors = FilterChipDefaults.filterChipColors(
                                    containerColor = md_theme_light_background,
                                    labelColor = md_theme_light_onBackground,
                                    selectedContainerColor = md_theme_light_primary,
                                    selectedLabelColor = md_theme_light_onPrimary
                                )
                            )
                            shownItems += 1
                            if (shownItems > maxItems && !isExpanded) break
                        }
                        if (shownItems > maxItems) {
                            SuggestionChip(
                                modifier = Modifier.padding(5.dp, 0.dp),
                                label = {
                                    Text(
                                        text = if (isExpanded) "Show Less" else "Show more",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = md_theme_light_primaryContainer,
                                    labelColor = md_theme_light_onPrimaryContainer
                                ),
                                border = BorderStroke(
                                    width = 1.dp,
                                    color = md_theme_transparent
                                ),
                                onClick = { isExpanded = !isExpanded }
                            )
                        }
                        if (isNothingFound && typedTag.value != "") {
                            InputChip(
                                modifier = Modifier.padding(start = 5.dp),
                                onClick = { typedTag.value = "" },
                                label = {
                                    Text(
                                        text = typedTag.toString(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                selected = true,
                                trailingIcon = {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Localized description",
                                        Modifier.size(InputChipDefaults.IconSize)
                                    )
                                },
                                colors = InputChipDefaults.inputChipColors(
                                    selectedContainerColor = md_theme_light_primary,
                                    selectedLabelColor = md_theme_light_onPrimary,
                                    selectedTrailingIconColor = md_theme_light_onPrimary
                                )
                            )
                        }
                    }
                    if (isNothingFound) {
                        if (typedTag.value == "") {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp),
                                text = "Nothing found",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                        TextInput(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp),
                            text = typedTag.toString(),
                            placeholderText = "So you can add your tag",
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 1,
                            textColor = md_theme_light_onBackground,
                            placeholderTextColor = md_theme_light_onBackgroundVariant,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done, // Указываем действие для клавиши Enter
                                keyboardType = KeyboardType.Text
                            ),
                            keyboardActions = KeyboardActions(onDone = {
                                // Adding new tag to lists `selectedTags` and `showingTags`
                                currentlySelectedTags.add(typedTag)
                                showingTags.apply {
                                    clear()
                                    addAll(currentlySelectedTags)
                                }
                                // Refresh fields
                                isNothingFound = false
                                query = ""
                                typedTag = Tag(
                                    id = UUID.randomUUID().toString(),
                                    typeId = selectedType.id,
                                    value = ""
                                )
                            }),
                            textAlign = TextAlign.Center,
                            onValueChange = { typedTag = typedTag.copy(value = it) }
                        )
                    }
                    TextFilledButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        text = "Done",
                        enabled = currentlySelectedTags.isNotEmpty(),
                        containerColor = md_theme_light_primary,
                        contentColor = md_theme_light_onPrimary,
                        onClick = {
                            onTagsAdd(currentlySelectedTags)
                            onDismissRequest()
                        }
                    )
                }
            }

            IconButton(
                modifier = Modifier
                    .padding(17.dp)
                    .size(25.dp)
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
fun SelectTagsDialogPreview() {
    SelectTagsDialog(
        selectedType = Type(value = "Film"),
        selectedTags = emptyList(),
        searchedTags = emptyList(),
        onSearchTag = { },
        onTagsAdd = { },
        setIsSelectTypeOpened = { },
        onDismissRequest = { }
    )
}

@Preview
@Composable
fun SelectTagsDialogNoTypePreview() {
    SelectTagsDialog(
        selectedType = null,
        selectedTags = emptyList(),
        searchedTags = emptyList(),
        onSearchTag = { },
        onTagsAdd = { },
        setIsSelectTypeOpened = { },
        onDismissRequest = { }
    )
}