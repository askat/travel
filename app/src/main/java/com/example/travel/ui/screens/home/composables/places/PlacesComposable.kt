package com.example.travel.ui.screens.home.composables.places

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.travel.model.Place
import com.example.travel.model.Result
import com.example.travel.ui.screens.home.composables.places.components.shimmerBrush

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PlacesComposable(
    places: Result<List<Place>>,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onPlaceClicked: (Place) -> Unit
) {
    when (places) {
        is Result.Loading -> {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
                    .width(270.dp)
                    .height(400.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(shimmerBrush())
            )
        }

        is Result.Success -> {
            LazyRow(
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(places.data) {
                    PlaceComposable(
                        it,
                        sharedTransitionScope,
                        animatedContentScope
                    ) { p ->
                        onPlaceClicked.invoke(p)
                    }
                }
            }
        }
    }
}
