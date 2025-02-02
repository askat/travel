package com.example.travel

import androidx.lifecycle.ViewModel
import com.example.travel.model.Place
import com.example.travel.model.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    // Mock data
    private val mockPlaces = listOf(
        Place(
            id = 1,
            name = "Karakol Valley",
            summary = "Park",
            description = "Desc",
            location = "Kyrgystan",
            image = R.drawable.karakol_valley
        ),
        Place(
            id = 2,
            name = "Ala-Kul Lake",
            summary = "Park",
            description = "Desc",
            location = "Kyrgystan",
            image = R.drawable.alakul
        ),
        Place(
            id = 3,
            name = "Tian-Shan Range",
            summary = "Park",
            description = "Desc",
            location = "Kyrgystan",
            image = R.drawable.tian_shan_ragne,
            isFavorite = true
        ),
        Place(
            id = 4,
            name = "Ala-Archa Park",
            summary = "Park",
            description = "Desc",
            location = "Kyrgystan",
            image = R.drawable.ala_archa_park
        ),
        Place(
            id = 5,
            name = "Tulpar Kul",
            summary = "Park",
            description = "Desc",
            location = "Kyrgystan",
            image = R.drawable.tulpar_kul
        )
    )

    // Imitating network request
    val places = flow {
        emit(Result.Loading)
        delay(1500)
        emit(Result.Success(mockPlaces))
    }
}