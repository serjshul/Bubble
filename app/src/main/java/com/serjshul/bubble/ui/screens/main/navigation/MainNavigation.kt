package com.serjshul.bubble.ui.screens.main.navigation

import com.serjshul.bubble.R

sealed class MainNavigation(
    val route: String,
    var title: Int,
    var icon: Int
) {
    data object Feed :
        MainNavigation(
            route = MainRoutes.FeedScreen.name,
            title = R.string.feed_screen,
            icon = R.drawable.main_navigation_feed
        )

    data object Home :
        MainNavigation(
            route = MainRoutes.HomeScreen.name,
            title = R.string.home_screen,
            icon = R.drawable.main_navigation_home
        )

    data object Profile :
        MainNavigation(
            route = MainRoutes.ProfileScreen.name,
            title = R.string.profile_screen,
            icon = R.drawable.main_navigation_profile
        )
}

enum class MainRoutes {
    FeedScreen, HomeScreen, ProfileScreen
}