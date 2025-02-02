package com.example.travel.navigation

sealed class Screens(val route: String) {
    data object Splash : Screens("splash")
    data object Home : Screens("home")
    data object Details : Screens("details")
}