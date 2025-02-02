package com.example.travel.ui.screens.details.composables

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.travel.ui.theme.interFontFamily
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ImageCard(
    place: Place,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    onBackClicked: () -> Unit
) {
    val hazeState = remember { HazeState() }

    val cardStyle = HazeStyle(
        backgroundColor = Color.Black,
        tints = listOf(HazeTint(MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))),
        blurRadius = 16.dp,
        noiseFactor = HazeDefaults.noiseFactor,
    )

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
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
                        .fillMaxWidth()
                        .height(400.dp)
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState("image-${place.id}"),
                            animatedVisibilityScope = animatedContentScope
                        )
                        .clip(shape = RoundedCornerShape(20.dp))
                        .hazeSource(state = hazeState)
                )
            }
            IconButton(
                onClick = {
                    onBackClicked.invoke()
                },
                colors = IconButtonDefaults.iconButtonColors(containerColor = dark_200_AA),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_arrow_left),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            IconToggleButton(
                checked = place.isSaved,
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
                    painter = painterResource(R.drawable.icon_archive),
                    contentDescription = stringResource(R.string.save),
                    tint = if (place.isSaved) {
                        Color.Red
                    } else {
                        Color.White
                    }
                )
            }
            Surface(
                color = Color.Transparent,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .hazeEffect(state = hazeState, style = cardStyle)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        modifier = Modifier.height(IntrinsicSize.Min)
                    ) {
                        Text(
                            place.name,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = interFontFamily,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            stringResource(R.string.price),
                            fontSize = 16.sp,
                            color = grey_500
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_marker),
                            contentDescription = stringResource(R.string.location),
                            tint = grey_500,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                        Text(
                            place.location,
                            fontSize = 18.sp,
                            color = grey_500,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(Modifier.weight(1f))
                        Row(
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                "$",
                                fontSize = 18.sp,
                                fontFamily = interFontFamily,
                                color = grey_500
                            )
                            Text(
                                "420",
                                fontSize = 24.sp,
                                fontFamily = interFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = grey_500
                            )
                        }
                    }
                }
            }
        }
    }
}