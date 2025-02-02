package com.example.travel.ui.screens.home.composables.places

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.travel.R
import com.example.travel.model.Place
import com.example.travel.ui.theme.dark_200_AA
import com.example.travel.ui.theme.grey_500

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PlaceComposable(
    place: Place,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onPlaceClicked: (Place) -> Unit
) {
    Card(
        onClick = {
            onPlaceClicked.invoke(place)
        },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .width(270.dp)
            .height(400.dp)
    ) {
        Box {
            with(sharedTransitionScope) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(place.image)
                        .crossfade(true)
                        .placeholderMemoryCacheKey("image-${place.id}")
                        .memoryCacheKey("image-${place.id}")
                        .build(),
                    contentDescription = place.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState("image-${place.id}"),
                            animatedVisibilityScope = animatedContentScope
                        )
                )
            }
            IconToggleButton(
                checked = place.isFavorite,
                onCheckedChange = {

                },
                colors = IconButtonDefaults.iconToggleButtonColors(
                    containerColor = dark_200_AA,
                    checkedContainerColor = Color.White
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_favorite),
                    contentDescription = stringResource(R.string.favorite),
                    tint = if (place.isFavorite) {
                        Color.Red
                    } else {
                        Color.White
                    }
                )
            }
            Surface(
                color = dark_200_AA,
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        place.name,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_marker),
                            contentDescription = stringResource(R.string.location),
                            tint = grey_500
                        )
                        Text(
                            place.location,
                            fontSize = 14.sp,
                            color = grey_500,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = stringResource(R.string.rating),
                            tint = grey_500
                        )
                        Text(
                            place.rating.toString(),
                            fontSize = 14.sp,
                            color = grey_500,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}