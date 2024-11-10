package com.serjshul.bubble.ui.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.serjshul.bubble.R
import com.serjshul.bubble.data.getAllTypes
import com.serjshul.bubble.model.subcollections.Type
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.components.text.TextInput
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.roundedCornerShape
import java.util.UUID

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectTypeDialog(
    modifier: Modifier = Modifier,
    type: Type?,
    types: List<Type>,
    onTypeValueChange: (Type) -> Unit,
    onDismissRequest: () -> Unit
) {
    var selectedType by remember { mutableStateOf(type) }
    var typedType by remember {
        mutableStateOf(
            if (type != null && type !in types) {
                type
            } else {
                Type(
                    id = UUID.randomUUID().toString(),
                    value = ""
                )
            }
        )
    }

    var inputChipEnabled by remember { mutableStateOf(type !in types && typedType.value != "") }

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
                    text = "Select the type",
                    color = md_theme_light_onBackground,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .wrapContentHeight(align = Alignment.Top),
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (typeChip in types) {
                        FilterChip(
                            modifier = Modifier
                                .padding(5.dp, 0.dp),
                            onClick = {
                                if (selectedType.toString() == typeChip.toString()) {
                                    selectedType = null
                                } else {
                                    inputChipEnabled = false
                                    selectedType = typeChip
                                    typedType.value = ""
                                }
                            },
                            label = {
                                Text(
                                    text = typeChip.toString(),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = md_theme_light_background,
                                labelColor = md_theme_light_onBackground,
                                selectedContainerColor = md_theme_light_primary,
                                selectedLabelColor = md_theme_light_onPrimary
                            ),
                            selected = selectedType == typeChip
                        )
                    }
                    if (inputChipEnabled) {
                        InputChip(
                            onClick = {
                                inputChipEnabled = false
                                selectedType = null
                                typedType.value = ""
                            },
                            label = {
                                Text(
                                    text = typedType.toString(),
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
                TextInput(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    text = typedType.toString(),
                    placeholderText = "Or you can add the type",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    textColor = md_theme_light_onBackground,
                    placeholderTextColor = md_theme_light_onBackgroundVariant,
                    keyboardActions = KeyboardActions(onDone = {
                        onTypeValueChange(typedType)
                        onDismissRequest()
                    }),
                    textAlign = TextAlign.Center,
                    onValueChange = {
                        typedType = typedType.copy(value = it)
                        selectedType = null
                        inputChipEnabled = typedType.value != ""
                    }
                )
                TextFilledButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Done",
                    enabled = selectedType != null || typedType.value != "",
                    containerColor = md_theme_light_primary,
                    contentColor = md_theme_light_onPrimary,
                    onClick = {
                        if (selectedType != null) {
                            onTypeValueChange(selectedType!!)
                        } else if (typedType.value != "") {
                            onTypeValueChange(typedType)
                        }
                        onDismissRequest()
                    }
                )
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
fun SelectTypeDialogPreview() {
    SelectTypeDialog(
        type = null,
        types = getAllTypes(),
        onTypeValueChange = { },
        onDismissRequest = { }
    )
}