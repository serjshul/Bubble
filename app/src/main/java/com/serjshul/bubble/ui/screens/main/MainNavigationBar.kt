package com.serjshul.bubble.ui.screens.main

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.serjshul.bubble.ui.theme.md_theme_light_background
import com.serjshul.bubble.ui.theme.md_theme_light_onBackground
import com.serjshul.bubble.ui.theme.md_theme_light_onBackgroundVariant

@Composable
fun MainNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val screens = listOf(
        MainNavigation.Feed,
        MainNavigation.Home,
        MainNavigation.Profile
    )

    NavigationBar(
        modifier = modifier.height(50.dp),
        containerColor = md_theme_light_background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            val screenTitle = stringResource(id = screen.title)
            val screenRoute = screen.route

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(screen.icon),
                        contentDescription = screenTitle
                    )
                },
                selected = currentRoute == screenRoute,
                onClick = {
                    navController.navigate(screenRoute) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = md_theme_light_background,
                    unselectedIconColor = md_theme_light_onBackgroundVariant,
                    selectedIconColor = md_theme_light_onBackground
                )
            )
        }
    }
}

@Preview
@Composable
fun MainNavigationBarPreview() {
    MainNavigationBar(
        navController = rememberNavController()
    )
}