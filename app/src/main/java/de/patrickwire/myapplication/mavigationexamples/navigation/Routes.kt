package de.patrickwire.myapplication.mavigationexamples.navigation

sealed class Routes(val route: String) {

    data object Login : Routes("login")

    data object Home : Routes("home")

    data object Settings : Routes("settings")

    data object Detail : Routes("detail/{number}") {
        fun createRoute(number: Int) = "detail/$number"
        const val ARG_NUMBER = "number"
    }
}
