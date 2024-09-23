package com.serjshul.bubble.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.serjshul.bubble.ui.screens.main.feed.FeedScreen
import com.serjshul.bubble.ui.screens.main.home.HomeScreen
import com.serjshul.bubble.ui.screens.main.profile.ProfileScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    openScreen: (String) -> Unit,
    popUpScreen: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            MainNavigationBar(
                navController = navController
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = MainScreens.HOME_SCREEN,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(MainScreens.FEED_SCREEN) {
                FeedScreen()
            }
            composable(MainScreens.HOME_SCREEN) {
                HomeScreen(
                    openScreen = openScreen,
                    popUpScreen = popUpScreen
                )
            }
            composable(MainScreens.PROFILE_SCREEN) {
                ProfileScreen()
            }
        }
    }
}