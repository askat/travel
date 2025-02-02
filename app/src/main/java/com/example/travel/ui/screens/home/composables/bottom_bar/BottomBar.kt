package com.example.travel.ui.screens.home.composables.bottom_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.travel.R

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        NavigationBarItem(
            selected = false,
            onClick = {

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_home),
                    contentDescription = "home"
                )
            }
        )
    }
}