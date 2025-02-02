package com.example.travel.ui.screens.home.composables.top_block

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.ui.theme.interFontFamily
import com.example.travel.ui.theme.montserratFontFamily

@Composable
fun TopBlock() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            Text(
                stringResource(R.string.hello_david),
                fontSize = 30.sp,
                fontFamily = montserratFontFamily
            )
            Text(
                stringResource(R.string.explore_the_world),
                fontSize = 20.sp,
                fontFamily = interFontFamily,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Image(
            painter = painterResource(R.drawable.avatar),
            contentDescription = "David",
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(50))
        )
    }
}
