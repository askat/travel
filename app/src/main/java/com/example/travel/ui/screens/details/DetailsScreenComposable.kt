package com.example.travel.ui.screens.details

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travel.MainViewModel
import com.example.travel.R
import com.example.travel.ui.screens.details.composables.BookButton
import com.example.travel.ui.screens.details.composables.ImageCard
import com.example.travel.ui.screens.details.composables.InfoBlock
import com.example.travel.ui.theme.interFontFamily
import com.example.travel.ui.theme.primaryContainerDark

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailsScreenComposable(
    placeId: Int,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onBackClick: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val place = viewModel.getPlace(placeId)

    if (place != null) {
        Scaffold(
            floatingActionButton = {
                BookButton {

                }
            },
            floatingActionButtonPosition = FabPosition.Center
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                ImageCard(
                    place = place,
                    sharedTransitionScope,
                    animatedContentScope,
                    onBackClicked = {
                        onBackClick.invoke()
                    }
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 40.dp, end = 16.dp)
                ) {
                    Text(
                        stringResource(R.string.overview),
                        color = primaryContainerDark,
                        fontSize = 22.sp,
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.width(100.dp))
                    Text(
                        stringResource(R.string.details),
                        color = primaryContainerDark.copy(0.62f),
                        fontFamily = interFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                InfoBlock(place)

                Text(
                    place.description,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 32.dp, end = 16.dp)
                )
            }
        }
    }
}