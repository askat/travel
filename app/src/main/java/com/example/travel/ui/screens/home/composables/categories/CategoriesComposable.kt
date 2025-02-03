package com.example.travel.ui.screens.home.composables.categories

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travel.R

@Composable
fun CategoriesComposable() {

    var selectedCategory by rememberSaveable { mutableIntStateOf(Category.All.id) }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .padding(top = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        val categories = listOf(
            Category.All,
            Category.MostViewed,
            Category.Nearest,
            Category.Latest,
            Category.Expensive,
            Category.Affordable
        )

        items(categories) {
            CategoryComposable(it, selectedCategory) { cat ->
                selectedCategory = cat.id
            }
        }
    }
}

sealed class Category(val id: Int, @StringRes val label: Int) {
    data object All : Category(1, R.string.all)
    data object MostViewed : Category(2, R.string.most_viewed)
    data object Nearest : Category(3, R.string.near)
    data object Latest : Category(4, R.string.latest)
    data object Expensive : Category(5, R.string.expensive)
    data object Affordable : Category(6, R.string.affordable)
}