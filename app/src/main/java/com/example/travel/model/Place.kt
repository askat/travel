package com.example.travel.model

import androidx.annotation.DrawableRes

data class Place(
    val id: Int,
    val name: String,
    val summary: String,
    val description: String,
    val location: String,
    val rating: Double = 0.0,
    val time: String = "",
    val temperature: String = "",
    var isFavorite: Boolean = false,
    var isSaved: Boolean = false,
    @DrawableRes val image: Int
)