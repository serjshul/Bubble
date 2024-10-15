package com.serjshul.bubble.ui.screens.common.addArticle

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.serjshul.bubble.model.collections.Article
import com.serjshul.bubble.model.collections.User
import com.serjshul.bubble.ui.components.cards.Owner
import com.serjshul.bubble.ui.components.text.TextInput
import com.serjshul.bubble.ui.theme.md_theme_background_gradient
import com.serjshul.bubble.ui.theme.md_theme_transparent_gray
import com.serjshul.bubble.ui.theme.md_theme_light_onPrimary
import java.util.Date

@Composable
fun AddArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: AddArticleViewModel = hiltViewModel(),
    popUpScreen: () -> Unit
) {
    AddArticleScreenContent(
        modifier = modifier,
        article = viewModel.article,
        currentUser = viewModel.currentUser
    )
}

@Composable
fun AddArticleScreenContent(
    modifier: Modifier = Modifier,
    article: Article,
    currentUser: User
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

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
                        photoUrl = currentUser.photoUrl!!,
                        onOwnerClick = { }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 15.dp, bottom = 40.dp, end = 15.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        TextInput(
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                                .align(Alignment.CenterHorizontally),
                            text = article.title!!,
                            placeholderText = "Title",
                            style = MaterialTheme.typography.titleLarge,
                            maxLines = 4,
                            textColor = md_theme_light_onPrimary,
                            placeholderTextColor = md_theme_transparent_gray,
                            textAlign = TextAlign.Center,
                            onValueChange = { }
                        )
//                        Text(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(bottom = 15.dp)
//                                .basicMarquee(),
//                            text = "title!!",
//                            textAlign = TextAlign.Center,
//                            color = md_theme_light_onPrimary,
//                            fontWeight = FontWeight.Bold,
//                            style = MaterialTheme.typography.titleLarge,
//                        )
                        Row(
                            modifier = modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                text = "creator!!",
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
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
                                    .weight(1f),
                                text = "year",
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
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
                                    .weight(1f),
                                text = "tags",
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                color = md_theme_light_onPrimary,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(15.dp)
                            .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                            .background(md_theme_light_onPrimary)
                            .align(Alignment.BottomCenter)
                    )
                }
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
        ),
        article = Article(
            title = "",
            description = "",
            creator = "",
            type = "",
            color = ""

        )
    )
}