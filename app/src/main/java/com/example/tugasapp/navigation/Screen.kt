package com.example.tugasapp.navigation

sealed class Screen (val route: String) {
    data object Home : Screen("home")
    data object Gallery: Screen("gallery")
    data object Detail: Screen("detail")
    data object About: Screen("about")
}