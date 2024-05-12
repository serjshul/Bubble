package com.serjshul.bubble.ui.screens.main

import com.serjshul.bubble.R

sealed class MainNavigation(
    val route: String,
    var icon: Int
) {
    data object Feed :
        MainNavigation(
            MainRoutes.FeedScreen.name,
            R.drawable.main_navigation_feed
        )

    data object Home :
        MainNavigation(
            MainRoutes.HomeScreen.name,
            R.drawable.main_navigation_home
        )

    data object Profile :
        MainNavigation(
            MainRoutes.ProfileScreen.name,
            R.drawable.main_navigation_profile
        )
}

enum class MainRoutes {
    FeedScreen, HomeScreen, ProfileScreen
}