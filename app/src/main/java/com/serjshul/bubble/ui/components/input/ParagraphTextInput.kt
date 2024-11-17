package com.serjshul.bubble.ui.components.input

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.model.collections.ArticleField
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.ui.components.buttons.AddImageButton
import com.serjshul.bubble.ui.components.buttons.CloseIconToggleButton
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun ParagraphTextInput(
    modifier: Modifier = Modifier,
    paragraph: Paragraph,
    color: Color = md_theme_light_primary,
    onParagraphValueChange: (ArticleField, String, String?) -> Unit,
    onRemoveClick: (String) -> Unit,
    onLauncherOpen: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextInput(
                modifier = Modifier.weight(1f),
                text = paragraph.title!!,
                placeholderText = "Paragraph's title",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 3,
                textColor = color,
                placeholderTextColor = md_theme_light_onBackgroundVariant,
                textAlign = TextAlign.Start,
                onValueChange = {
                    onParagraphValueChange(ArticleField.PARAGRAPH_TITLE, paragraph.id!!, it)
                }
            )
            CloseIconToggleButton(
                modifier = Modifier
                    .padding(top = 6.dp, end = 6.dp),
                backgroundColor = color,
                tint = md_theme_light_onPrimary,
                onClick = { onRemoveClick(paragraph.id!!) }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 1 / 4)
                .padding(15.dp, 0.dp)
                .roundedCornerShape()
        ) {
            AddImageButton(
                modifier = Modifier.fillMaxSize(),
                imageUri = if (paragraph.imageUri != null) Uri.parse(paragraph.imageUri) else null,
                color = color,
                onCoverClick = { },
                onAddCoverClick = { onLauncherOpen() }
            )
            if (paragraph.imageUri != null) {
                TextFilledButton(
                    modifier = Modifier
                        .padding(top = 1.dp, end = 4.dp)
                        .align(Alignment.TopEnd),
                    text = "Remove",
                    containerColor = md_theme_transparent_gray,
                    contentColor = md_theme_light_onBackground,
                    onClick = {
                        onParagraphValueChange(ArticleField.PARAGRAPH_IMAGE_URI, paragraph.id!!, null)
                    }
                )
            }
        }
        TextInput(
            text = paragraph.text!!,
            placeholderText = "Type paragraph's text here",
            style = MaterialTheme.typography.bodyMedium,
            textColor = md_theme_light_onBackground,
            placeholderTextColor = md_theme_light_onBackgroundVariant,
            textAlign = TextAlign.Start,
            onValueChange = {
                onParagraphValueChange(ArticleField.PARAGRAPH_TEXT, paragraph.id!!, it)
            }
        )
    }
}

@Preview
@Composable
fun ParagraphTextInputWithoutDataPreview() {
    ParagraphTextInput(
        paragraph = Paragraph(id = "", title = "", text = ""),
        onParagraphValueChange = { _, _, _ -> },
        onRemoveClick = { },
        onLauncherOpen = { }
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
        onParagraphValueChange = { _, _, _ -> },
        onRemoveClick = { },
        onLauncherOpen = { }
    )
}