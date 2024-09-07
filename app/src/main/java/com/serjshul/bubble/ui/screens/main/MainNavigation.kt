package com.serjshul.bubble.ui.screens.main

import com.serjshul.bubble.R

object MainScreens {
    const val FEED_SCREEN = "feed"
    const val HOME_SCREEN = "home"
    const val PROFILE_SCREEN = "profile"
}

sealed class MainNavigation(
    val route: String,
    var title: Int,
    var icon: Int
) {
    data object Feed :
        MainNavigation(
            route = MainScreens.FEED_SCREEN,
            title = R.string.screen_feed,
            icon = R.drawable.navigation_feed
        )

    data object Home :
        MainNavigation(
            route = MainScreens.HOME_SCREEN,
            title = R.string.screen_home,
            icon = R.drawable.navigation_home
        )

    data object Profile :
        MainNavigation(
            route = MainScreens.PROFILE_SCREEN,
            title = R.string.screen_profile,
            icon = R.drawable.navigation_profile
        )
}