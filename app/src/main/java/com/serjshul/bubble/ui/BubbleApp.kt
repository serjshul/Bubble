package com.serjshul.bubble.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            MainScreen()
        }
    }
}