package com.serjshul.bubble.ui.components.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serjshul.bubble.common.ext.toColor
import com.serjshul.bubble.model.collections.Paragraph
import com.serjshul.bubble.ui.components.media.ParagraphAsyncImage
import com.serjshul.bubble.ui.utils.roundedCornerShape

@Composable
fun Paragraph(
    modifier: Modifier = Modifier,
    paragraph: Paragraph,
    articleColor: String
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val texts = paragraph.text!!.split("\n")

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = paragraph.title!!,
            color = articleColor.toColor(),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
        )
        if (paragraph.imageUrl != null) {
            ParagraphAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 1/4)
                    .padding(top = 15.dp)
                    .roundedCornerShape(),
                url = paragraph.imageUrl,
                contentDescription = "Paragraph image"
            )
        }
        for (text in texts) {
            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun ParagraphPreview() {
    val paragraph = Paragraph(
        title = "Lady Bird’s coming of age",
        imageUrl = "https://compote.slate.com/images/65093ba9-f66a-4912-92a7-090af2f5ef20.jpeg?crop=1560%2C1040%2Cx0%2Cy0",
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
    )

    Paragraph(
        paragraph = paragraph,
        articleColor = "#c22f2f"
    )
}