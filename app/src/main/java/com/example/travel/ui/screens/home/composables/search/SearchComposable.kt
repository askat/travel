package com.example.travel.ui.screens.home.composables.search

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel.R
import com.example.travel.ui.theme.grey_100
import com.example.travel.ui.theme.grey_200

@Composable
fun SearchComposable() {
    var search by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier.padding(top = 38.dp)
    ) {
        BasicTextField(
            value = search,
            onValueChange = { search = it },
            textStyle = MaterialTheme.typography.bodyMedium,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
            }),
            singleLine = true,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(2.dp, grey_100, RoundedCornerShape(20.dp))
                        .padding(start = 31.dp, end = 24.dp, top = 13.dp, bottom = 13.dp)
                ) {
                    Box {
                        if (search.isBlank()) {
                            Text(
                                stringResource(R.string.search_placeholder),
                                fontSize = 16.sp,
                                color = grey_200
                            )
                        }
                        innerTextField()
                    }
                    Spacer(Modifier.weight(1f))
                    VerticalDivider(
                        thickness = 2.dp,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(R.drawable.icon_setting),
                            tint = grey_200,
                            contentDescription = "",
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}