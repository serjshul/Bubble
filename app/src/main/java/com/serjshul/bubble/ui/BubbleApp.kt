package com.serjshul.bubble.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.serjshul.bubble.ui.screens.common.addArticle.AddArticleScreen
import com.serjshul.bubble.ui.screens.common.article.ArticleScreen
import com.serjshul.bubble.ui.screens.main.MainScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun BubbleApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = BubbleDestinations.MAIN_ROUTE,
    navActions: BubbleNavigation = remember(navController) {
        BubbleNavigation(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(BubbleDestinations.MAIN_ROUTE) {
            MainScreen(
                openScreen = { route ->
                    navActions.navigate(route)
                },
                popUpScreen = {
                    navActions.popUp()
                }
            )
        }
        composable(
            route = "${BubbleDestinations.ARTCILE_ROUTE}/{${BubbleDestinationsArgs.ARTICLE_ID_ARG}}",
            arguments = listOf(
                navArgument(BubbleDestinationsArgs.ARTICLE_ID_ARG) { type = NavType.StringType }
            )
        ) {
            ArticleScreen(
                popUpScreen = {
                    navActions.popUp()
                }
            )
        }
        composable(BubbleDestinations.ADD_ARTICLE_ROUTE) {
            AddArticleScreen(
                popUpScreen = {
                    navActions.popUp()
                }
            )
        }
    }
}