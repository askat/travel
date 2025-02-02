package com.example.travel.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travel.MainViewModel
import com.example.travel.R
import com.example.travel.model.Result
import com.example.travel.ui.screens.home.composables.categories.CategoriesComposable
import com.example.travel.ui.screens.home.composables.places.PlacesComposable
import com.example.travel.ui.screens.home.composables.search.SearchComposable
import com.example.travel.ui.screens.home.composables.top_block.TopBlock
import com.example.travel.ui.theme.dark_100
import com.example.travel.ui.theme.poppinsFontFamily

@Composable
fun HomeScreenComposable(
    viewModel: MainViewModel = viewModel()
) {
    val places = viewModel.places.collectAsStateWithLifecycle(Result.Loading)

    Scaffold { paddingValues ->
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
            Spacer(modifier = Modifier.height(45.dp))
            PlacesComposable(places.value)
        }
    }
}
