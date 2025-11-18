package de.patrickwire.myapplication.mavigationexamples.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.patrickwire.myapplication.mavigationexamples.ui.LoginScreen
import de.patrickwire.myapplication.mavigationexamples.viewmodels.AppViewModel

@Composable
fun AppNavigation(viewModel: AppViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    // Start destination based on login state
    val startDestination = if (viewModel.isLoggedIn) Routes.Home.route else Routes.Login.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Login Screen (logged out state)
        composable(Routes.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.Home.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // Logged-in state graph (Home + Detail screens)
        loggedInGraph(navController)
    }
}
