package com.example.travel.ui.screens.details

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travel.MainViewModel
import com.example.travel.ui.screens.details.composables.ImageCard

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailsScreenComposable(
    placeId: Int,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onBackClick: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val place by viewModel.getPlace(placeId).collectAsStateWithLifecycle(null)

    place?.let { p ->
        Scaffold { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                ImageCard(
                    place = p,
                    sharedTransitionScope,
                    animatedContentScope,
                    onBackClicked = {
                        onBackClick.invoke()
                    }
                )
            }
        }
    }
}