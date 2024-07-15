package com.example.abcapp.myCart.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.abcapp.CustomIcon
import com.example.abcapp.HeaderDesign
import com.example.abcapp.R

@Composable
fun HeaderForCart(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    HeaderDesign(
        modifier = modifier.padding(20.dp),
        title = {
            MyCartText()
        },
        leadingIcon = {
            CustomIcon(
                icon = R.drawable.arrow,
                contentDescription = stringResource(id = R.string.back_arrow),
                onClick = onBackClick
            )
        }
    )
}