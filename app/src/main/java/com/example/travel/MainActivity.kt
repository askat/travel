package com.example.travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.travel.navigation.Screens
import com.example.travel.ui.screens.details.DetailsScreenComposable
import com.example.travel.ui.screens.home.HomeScreenComposable
import com.example.travel.ui.screens.splash.SplashScreenComposable
import com.example.travel.ui.theme.TravelTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TravelTheme(dynamicColor = false) {
                SharedTransitionLayout {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Splash
                    ) {
                        composable<Screens.Splash> {
                            SplashScreenComposable()
                            LaunchedEffect(true) {
                                delay(1500)
                                navController.navigate(Screens.Home) {
                                    popUpTo(Screens.Splash) {
                                        inclusive = true
                                    }
                                }
                            }
                        }
                        composable<Screens.Home> {
                            HomeScreenComposable(
                                this@SharedTransitionLayout,
                                this@composable,
                                onPlaceClicked = { place ->
                                    navController.navigate(Screens.Details(placeId = place.id))
                                }
                            )
                        }
                        composable<Screens.Details> { backStackEntry ->
                            val details = backStackEntry.toRoute<Screens.Details>()
                            DetailsScreenComposable(
                                placeId = details.placeId,
                                this@SharedTransitionLayout,
                                this@composable,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
