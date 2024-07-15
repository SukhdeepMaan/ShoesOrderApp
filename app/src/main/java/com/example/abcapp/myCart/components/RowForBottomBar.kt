package com.example.abcapp.myCart.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun RowForBottomBar(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = TextStyle(),
    price: String,
    priceStyle: TextStyle = TextStyle()
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title, modifier = Modifier.weight(1f), style = titleStyle
        )
        Text(
            text = price, style = priceStyle
        )
    }
}