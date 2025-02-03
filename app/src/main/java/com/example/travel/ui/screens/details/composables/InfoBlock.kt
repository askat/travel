package com.example.travel.ui.screens.details.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.model.Place
import com.example.travel.ui.theme.grey_600

@Composable
fun InfoBlock(
    place: Place
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp, top = 32.dp, end = 16.dp
            )
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = grey_600)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_clock_small),
                contentDescription = stringResource(R.string.time),
                modifier = Modifier.padding(8.dp)
            )
        }
        Text(
            place.time,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
            modifier = Modifier.padding(start = 6.dp)
        )
        Spacer(Modifier.weight(1f))
        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = grey_600)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_cloud),
                contentDescription = stringResource(R.string.weather),
                modifier = Modifier.padding(8.dp)
            )
        }
        Text(
            "16°C",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
            modifier = Modifier.padding(start = 6.dp)
        )

        Spacer(Modifier.weight(1f))
        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = grey_600)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_star_dark),
                contentDescription = stringResource(R.string.rating),
                modifier = Modifier.padding(8.dp)
            )
        }
        Text(
            place.rating.toString(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}