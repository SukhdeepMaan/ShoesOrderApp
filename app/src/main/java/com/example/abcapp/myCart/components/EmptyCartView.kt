package com.example.abcapp.myCart.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.abcapp.R

@Composable
fun EmptyCartView(modifier: Modifier = Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center){
        Text(text = stringResource(R.string.your_cart_is_empty))
    }
}