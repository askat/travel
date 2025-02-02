package com.example.travel.ui.screens.home.composables.categories

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.ui.theme.dark_100
import com.example.travel.ui.theme.grey_300
import com.example.travel.ui.theme.grey_400

@Composable
fun CategoryComposable(
    category: Category,
    selectedId: Int,
    onCategoryClicked: (Category) -> Unit
) {
    Card(
        onClick = {
            onCategoryClicked.invoke(category)
        },
        colors = if (selectedId == category.id) {
            CardDefaults.cardColors().copy(containerColor = dark_100)
        } else {
            CardDefaults.cardColors().copy(containerColor = grey_400)
        },
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            stringResource(category.label),
            color = if (selectedId == category.id) {
                Color.White
            } else {
                grey_300
            },
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(10.dp),
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}