package com.example.travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travel.navigation.Screens
import com.example.travel.ui.screens.details.DetailsScreenComposable
import com.example.travel.ui.screens.home.HomeScreenComposable
import com.example.travel.ui.screens.splash.SplashScreenComposable
import com.example.travel.ui.theme.TravelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            TravelTheme {
                Scaffold { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Splash.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(route = Screens.Splash.route) {
                            SplashScreenComposable()
                        }
                        composable(route = Screens.Home.route) {
                            HomeScreenComposable()
                        }
                        composable(route = Screens.Details.route) {
                            DetailsScreenComposable()
                        }
                    }
                }
            }
        }
    }
}
