package com.serjshul.bubble.ui

import androidx.navigation.NavHostController
import com.serjshul.bubble.ui.BubbleScreens.ADD_ARTICLE_SCREEN
import com.serjshul.bubble.ui.BubbleScreens.ARTICLE_SCREEN
import com.serjshul.bubble.ui.BubbleScreens.MAIN_SCREEN

/**
 * Screens used in [BubbleDestinations]
 */
private object BubbleScreens {
    const val MAIN_SCREEN = "main"
    const val ARTICLE_SCREEN = "article"
    const val ADD_ARTICLE_SCREEN = "addArticle"
}

/**
 * Arguments used in [BubbleDestinations] routes
 */
object BubbleDestinationsArgs {
    const val ARTICLE_ID_ARG = "articleId"
}

/**
 * Destinations used in the [BubbleActivity]
 */
object BubbleDestinations {
    const val MAIN_ROUTE = MAIN_SCREEN
    const val ARTCILE_ROUTE = ARTICLE_SCREEN
    const val ADD_ARTICLE_ROUTE = ADD_ARTICLE_SCREEN
}

/**
 * Models the navigation actions in the app.
 */
class BubbleNavigation(
    private val navController: NavHostController
) {

    fun popUp() = navController.popBackStack()

    fun navigate(route: String) =
        navController.navigate(route) {
            launchSingleTop = true
        }

    fun navigateAndPopUp(route: String, popUp: String) =
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }

    fun clearAndNavigate(route: String) =
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
}