package com.example.barnaton.ui.navigations

sealed class Screen(val route: String) {
    data object Home : Screen("home")

    data object Favorite : Screen("favorite")

    data object Profile: Screen("profile")

    data object DetailScreen: Screen("home/{id}") {
        fun createRoute(id: String) = "home/$id"
    }
}