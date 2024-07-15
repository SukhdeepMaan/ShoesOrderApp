package com.example.abcapp.myCart.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.abcapp.CustomButton
import com.example.abcapp.R
import com.example.abcapp.ui.theme.cornflowerBlue

@Composable
fun CheckOutButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    CustomButton(
        modifier = modifier,
        onClick = onClick,
        buttonColor = cornflowerBlue,
        contentColor = Color.White
    ) {
        Text(text = stringResource(R.string.checkout))
    }
}