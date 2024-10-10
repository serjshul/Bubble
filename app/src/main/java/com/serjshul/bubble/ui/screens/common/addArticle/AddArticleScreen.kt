package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.R
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.ui.components.media.ProfileAsyncImage
import com.serjshul.bubble.ui.theme.md_theme_background_gradient
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import java.util.Date

@Composable
fun AddArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: AddArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    AddArticleScreenContent(
        currentUser = viewModel.currentUser
    )
}

@Composable
fun AddArticleScreenContent(
    modifier: Modifier = Modifier,
    currentUser: User
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    LazyColumn(
        modifier = Modifier.fillMaxSize()
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
                    photoUrl = currentUser.photoUrl!!
                )
            }
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
        )
    )
}

@Composable
private fun Owner(
    modifier: Modifier = Modifier,
    nickname: String,
    photoUrl: String
) {
    Row(
        modifier = modifier
    ) {
        ProfileAsyncImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            url = photoUrl,
            contentDescription = stringResource(id = R.string.image_user_photo)
        )
        Text(
            modifier = Modifier
                .padding(start = 15.dp)
                .align(Alignment.CenterVertically),
            text = buildAnnotatedString {
                append("by ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("@${nickname}")
                }
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = md_theme_light_onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun OwnerPreview() {
    Owner(
        modifier = Modifier.background(Color.Gray),
        nickname = "serjshul",
        photoUrl = "https://sun9-13.userapi.com/impg/0hcngQRHKeTQupgE4o4CD5AYE0ezO-Jta_MTDg/e9YqYdkAXVw.jpg?size=1080x1350&quality=95&sign=468e9c0b5d080643534757230681000e&type=album",
    )
}