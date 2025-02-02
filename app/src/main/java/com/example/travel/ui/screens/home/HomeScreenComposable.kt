package com.example.travel.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.travel.ui.screens.home.composables.search.SearchComposable
import com.example.travel.ui.screens.home.composables.top_block.TopBlock

@Composable
fun HomeScreenComposable(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)

    ) {
        TopBlock()
        SearchComposable()
    }
}
