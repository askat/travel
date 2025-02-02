package com.example.travel.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.ui.screens.home.composables.categories.CategoriesComposable
import com.example.travel.ui.screens.home.composables.search.SearchComposable
import com.example.travel.ui.screens.home.composables.top_block.TopBlock
import com.example.travel.ui.theme.dark_100
import com.example.travel.ui.theme.poppinsFontFamily

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

        Text(
            stringResource(R.string.popular_places),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = poppinsFontFamily,
            color = dark_100,
            modifier = Modifier
                .padding(start = 16.dp, top = 42.dp, end = 16.dp)
        )

        CategoriesComposable()
    }
}
