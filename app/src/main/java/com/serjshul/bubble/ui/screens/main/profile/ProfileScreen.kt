package com.serjshul.bubble.ui.screens.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serjshul.bubble.ui.components.bars.CustomCenterAlignedTopAppBar
import com.serjshul.bubble.ui.components.buttons.CustomOutlinedButton
import com.serjshul.bubble.ui.components.buttons.CustomOutlinedIconButton
import com.serjshul.bubble.ui.components.buttons.IconButtonType
import com.serjshul.bubble.ui.components.media.CustomAsyncImage
import com.serjshul.bubble.ui.components.media.ImageType
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CustomCenterAlignedTopAppBar(
                onAddArticleClick = {},
                onSearchArticleClick = {}
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Row {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(end = 5.dp)
                    ) {
                        Text(
                            text = "Serge, 21",
                            color = md_theme_light_onBackground,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "@serjshul",
                            color = md_theme_light_onBackground,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    CustomAsyncImage(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(70.dp)
                            .align(Alignment.CenterVertically),
                        imageType = ImageType.PROFILE,
                        url = "coverUrl",
                        contentDescription = ""
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = "Graduated from SPbSTU, read a lot of books just to download yet another app",
                    color = md_theme_light_onBackground,
                    maxLines = 4,
                    lineHeight = 22.sp,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = "${35.1}K followers  •  ${103} following",
                    color = md_theme_light_onBackgroundVariant,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge
                )

                Row(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    CustomOutlinedButton(
                        modifier = Modifier
                            .weight(3f)
                            .padding(end = 10.dp),
                        text = "Following",
                        contentColor = md_theme_light_onBackground,
                        onClick = { }
                    )
                    CustomOutlinedButton(
                        modifier = Modifier
                            .weight(3f)
                            .padding(end = 10.dp),
                        text = "Message",
                        contentColor = md_theme_light_onBackground,
                        onClick = { }
                    )
                    CustomOutlinedIconButton(
                        modifier = Modifier.weight(1f),
                        iconButtonType = IconButtonType.SIMILAR_PROFILES,
                        color = md_theme_light_onBackground,
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}