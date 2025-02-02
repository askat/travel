package com.example.travel.ui.screens.home.composables.places

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.travel.model.Place
import com.example.travel.model.Result

@Composable
fun PlacesComposable(
    places: Result<List<Place>>
) {
    when (places) {
        is Result.Loading -> {
            Text("Loading")
        }

        is Result.Success -> {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(places.data) {
                    PlaceComposable(it) {

                    }
                }
            }
        }
    }
}
