package de.patrickwire.myapplication.mavigationexamples.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import de.patrickwire.myapplication.mavigationexamples.ui.DetailScreen
import de.patrickwire.myapplication.mavigationexamples.ui.HomeScreen
import de.patrickwire.myapplication.mavigationexamples.ui.SettingsScreen

/**
 * Navigation graph for logged-in state
 * Contains: Home, Settings, and Detail screens
 */
fun NavGraphBuilder.loggedInGraph(navController: NavController) {

    // Home Screen with list
    composable(Routes.Home.route) {
        HomeScreen(
            onItemClick = { number ->
                navController.navigate(Routes.Detail.createRoute(number))
            },
            onSettingsClick = {
                navController.navigate(Routes.Settings.route)
            },
            onLogout = {
                navController.navigate(Routes.Login.route) {
                    popUpTo(Routes.Home.route) { inclusive = true }
                }
            }
        )
    }

    // Settings Screen with input field (DataStore persistence)
    composable(Routes.Settings.route) {
        SettingsScreen(
            onBack = {
                navController.popBackStack()
            }
        )
    }

    // Detail Screen with number
    composable(
        route = Routes.Detail.route,
        arguments = listOf(
            navArgument(Routes.Detail.ARG_NUMBER) {
                type = NavType.IntType
            }
        )
    ) { backStackEntry ->
        val number = backStackEntry.arguments?.getInt(Routes.Detail.ARG_NUMBER) ?: 0

        DetailScreen(
            number = number,
            onBack = {
                navController.popBackStack()
            }
        )
    }
}
