package com.serjshul.bubble.ui.components.dialogs

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.serjshul.bubble.ui.components.buttons.AddCoverButton
import com.serjshul.bubble.ui.components.buttons.CloseIconToggleButton
import com.serjshul.bubble.ui.components.buttons.TextFilledButton
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import com.serjshul.bubble.ui.theme.md_theme_light_onSecondary
import com.serjshul.bubble.ui.theme.md_theme_light_primary
import com.serjshul.bubble.ui.theme.md_theme_light_secondary
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray

@Composable
fun CoverDialog(
    modifier: Modifier = Modifier,
    coverUri: Uri?,
    onCoverUriValueChange: (Uri?) -> Unit,
    onLauncherOpen: () -> Unit,
    onDismissRequest: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val coverWidth = configuration.screenWidthDp.dp - 30.dp
    val coverHeight = coverWidth * 9 / 16

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = modifier
        ) {
            Box {
                AddCoverButton(
                    modifier = Modifier
                        .size(coverWidth, coverHeight)
                        .clip(RoundedCornerShape(5.dp)),
                    coverUri = coverUri,
                    onCoverClick = { /*TODO*/ },
                    onAddCoverClick = { onLauncherOpen() }
                )
                CloseIconToggleButton(
                    modifier = Modifier.align(Alignment.TopEnd),
                    backgroundColor = md_theme_transparent_gray,
                    tint = md_theme_light_onSecondary,
                    onClick = { onDismissRequest() }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                TextFilledButton(
                    text = "Remove",
                    enabled = true,
                    containerColor = md_theme_light_primary,
                    contentColor = md_theme_light_onPrimary,
                    onClick = { onCoverUriValueChange(null) }
                )
                TextFilledButton(
                    modifier = Modifier.padding(start = 15.dp),
                    text = "Change",
                    enabled = true,
                    containerColor = md_theme_light_secondary,
                    contentColor = md_theme_light_onPrimary,
                    onClick = { onLauncherOpen() }
                )
            }
        }
    }
}

@Preview
@Composable
fun CoverDialogPreview() {
    CoverDialog(
        coverUri = Uri.EMPTY,
        onCoverUriValueChange = { },
        onLauncherOpen = { },
        onDismissRequest = { }
    )
}