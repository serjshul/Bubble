package com.serjshul.bubble.ui

import androidx.navigation.NavHostController
import com.serjshul.bubble.ui.BubbleScreens.MAIN_SCREEN

/**
 * Screens used in [BubbleDestinations]
 */
private object BubbleScreens {
    const val MAIN_SCREEN = "main"
}

/**
 * Arguments used in [BubbleDestinations] routes
 */
object BubbleDestinationsArgs {
    const val USER_MESSAGE_ARG = "userMessage"
    const val TASK_ID_ARG = "taskId"
    const val TITLE_ARG = "title"
}

/**
 * Destinations used in the [BubbleActivity]
 */
object BubbleDestinations {
    const val MAIN_ROUTE = MAIN_SCREEN
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