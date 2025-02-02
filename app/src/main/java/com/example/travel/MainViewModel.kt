package com.example.travel

import androidx.lifecycle.ViewModel
import com.example.travel.constants.mockData
import com.example.travel.model.Place
import com.example.travel.model.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainViewModel : ViewModel() {

    private var isFirstLaunch = true

    // Mock data
    private val mockPlaces = mockData

    // Imitating network request
    val places = flow {
        emit(Result.Loading)
        if (isFirstLaunch) {
            isFirstLaunch = false
            delay(1500)
        }
        emit(Result.Success(mockPlaces))
    }

    fun getPlace(placeId: Int): Place? = mockPlaces.find { it.id == placeId }
}