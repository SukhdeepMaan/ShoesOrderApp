package com.example.abcapp.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.R

@Composable
fun HeyText(modifier: Modifier = Modifier) {
    Text(text = "Hey,👋",
        modifier = modifier.padding(top = 24.dp, start = 8.dp))
}

@Composable
fun UserNameText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.alisson_becker),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        ),
        modifier = modifier.padding(bottom = 24.dp, start = 8.dp)
    )
}

@Composable
fun StoreLocationText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.store_location),
        style = TextStyle(
            fontSize = 12.sp,
        )
    )
}

@Composable
fun CityNameText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.mondolibug_sylhet),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun NavigationText(
    modifier: Modifier = Modifier,
    title: String) {
    Text(
        modifier = modifier,
        text = title)
}