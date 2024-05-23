package com.example.mycharacterlist.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailList : Screen("home/{listId}") {
        fun createRoute(listId: Int) = "home/$listId"
    }
}
