package com.example.travel.ui.screens.home.composables.bottom_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.travel.R

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {

            },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent),
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_home),
                    contentDescription = "home",
                    modifier = Modifier
                        .drawBehind {
                            drawCircle(
                                color = Color.Red,
                                radius = 12f,
                                center = Offset(x = size.width * 0.5f, y = size.height * 1.7f)
                            )
                        }
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_clock),
                    contentDescription = "history"
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_heart),
                    contentDescription = "favorite"
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_user),
                    contentDescription = "profile"
                )
            }
        )
    }
}