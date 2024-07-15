package com.example.abcapp.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.abcapp.CustomIcon
import com.example.abcapp.CustomSearchBar
import com.example.abcapp.R

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    searchValue: String,
    onValueChange: (String) -> Unit) {
    CustomSearchBar(
        modifier = modifier.padding(horizontal = 16.dp),
        value = searchValue,
        onValueChange = onValueChange,
        placeholder = { Text(text = stringResource(R.string.looking_for_shoes)) },
        leadingIcon = {
            CustomIcon(
                icon = R.drawable.search,
                contentDescription = stringResource(R.string.search),
                background = false
            )
        }
    )
}