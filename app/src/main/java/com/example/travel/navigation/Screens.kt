package com.example.travel.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data object Splash
    @Serializable
    data object Home
    @Serializable
    data class Details(val placeId: Int)
}