package com.serjshul.bubble.ui.components.text

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.ui.components.buttons.AddCoverButton
import com.serjshul.bubble.ui.components.buttons.AddTextFilledButton
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun ParagraphTextInput(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    paragraph: Paragraph,
    articleColor: String?,
    onTitleValueChange: (String, String) -> Unit,
    onTextValueChange: (String) -> Unit,
    onAddClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    if (enabled) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            TextInput(
                modifier = Modifier,
                text = paragraph.title!!,
                placeholderText = "Paragraph's title",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                textColor = if (articleColor != null) articleColor.toColor() else md_theme_light_onBackground,
                placeholderTextColor = md_theme_light_onBackgroundVariant,
                textAlign = TextAlign.Start,
                onValueChange = { onTitleValueChange(paragraph.id!!, it) }
            )
            AddCoverButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 1 / 4)
                    .padding(15.dp, 0.dp)
                    .roundedCornerShape(),
                coverUri = if (paragraph.imageUri != null) Uri.parse(paragraph.imageUri) else null,
                onCoverClick = { },
                onAddCoverClick = { }
            )
            TextInput(
                text = paragraph.text!!,
                placeholderText = "Paragraph's text",
                style = MaterialTheme.typography.bodyMedium,
                textColor = md_theme_light_onBackground,
                placeholderTextColor = md_theme_light_onBackgroundVariant,
                textAlign = TextAlign.Start,
                onValueChange = onTextValueChange
            )
        }
    } else {
        Box {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(15.dp, 15.dp)
                    .blur(25.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "A Hero in the Making, on Shifting Sands",
                    color = "#a46d58".toColor(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = "Herbert had a lot to say — about religion, ecology, the fate of " +
                            "humanity — and drew from an astonishment of sources, from Greek " +
                            "mythology to Indigenous cultures. Inspired by government efforts " +
                            "to keep sand dunes at bay, he dreamed up a desert planet where " +
                            "water was the new petroleum.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            AddTextFilledButton(
                modifier = Modifier.align(Alignment.Center),
                text = "Add a paragraph",
                contentColor = md_theme_light_onPrimary,
                containerColor = md_theme_light_primary,
                onClick = onAddClick
            )
        }
    }
}

@Preview
@Composable
fun ParagraphTextInputWithoutDataPreview() {
    ParagraphTextInput(
        paragraph = Paragraph(id = "", title = "", text = ""),
        articleColor = null,
        onTitleValueChange = { _, _ -> },
        onTextValueChange = { },
        onAddClick = { }
    )
}

@Preview
@Composable
fun ParagraphTextInputWithDataPreview() {
    ParagraphTextInput(
        paragraph = Paragraph(
            id = "kldsjflsdk",
            title = "Lady Bird’s coming of age",
            imageUri = "",
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
                    "begun.\n\nThough the film gives us milestones from Lady Bird’s coming of age, " +
                    "its key preoccupation is the jagged relationship between Lady Bird and her " +
                    "mother Marion (Laurie Metcalf), an overworked nurse whose blunt pragmatism " +
                    "butts heads with her daughter’s dreams of moving to New York, “where culture " +
                    "is”. The scenes between Ronan and Metcalf are electric; Gerwig maps their " +
                    "inability to communicate with excruciating veracity."
        ),
        articleColor = "#c22f2f",
        onTitleValueChange = { _, _ -> },
        onTextValueChange = { },
        onAddClick = { }
    )
}

@Preview
@Composable
fun ParagraphTextInputDisabledPreview() {
    ParagraphTextInput(
        enabled = false,
        paragraph = Paragraph(id = "", title = "", text = ""),
        articleColor = null,
        onTitleValueChange = { _, _ -> },
        onTextValueChange = { },
        onAddClick = { }
    )
}