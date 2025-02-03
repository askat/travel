package com.example.travel.ui.screens.details

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
    val scrollState = rememberScrollState()
    val isFabVisible by remember {
        derivedStateOf {
            scrollState.value == 0 || scrollState.lastScrolledBackward
        }
    }
    var isReviewVisible by rememberSaveable { mutableStateOf(true) }

    if (place != null) {
        Scaffold(
            floatingActionButton = {
                AnimatedVisibility(
                    isFabVisible,
                    enter = scaleIn() + fadeIn(),
                    exit = scaleOut() + fadeOut()
                ) {
                    BookButton {

                    }
                }
            },
            floatingActionButtonPosition = FabPosition.Center
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(scrollState)
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
                        fontSize = if (isReviewVisible) {
                            22.sp
                        } else {
                            16.sp
                        },
                        fontFamily = interFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clickable {
                                isReviewVisible = true
                            }
                    )
                    Spacer(Modifier.width(100.dp))
                    Text(
                        stringResource(R.string.details),
                        color = primaryContainerDark.copy(0.62f),
                        fontFamily = interFontFamily,
                        fontSize = if (isReviewVisible.not()) {
                            22.sp
                        } else {
                            16.sp
                        },
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clickable {
                                isReviewVisible = false
                            }
                    )
                }
                InfoBlock(place)

                if (isReviewVisible) {
                    Text(
                        place.description.substring(0, 250),
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = TextStyle(
                            brush = Brush.verticalGradient(
                                listOf(MaterialTheme.colorScheme.onBackground, Color.Transparent)
                            )
                        ),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 32.dp, end = 16.dp)
                    )
                } else {
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
}