package com.example.abcapp.checkOut.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.abcapp.R

@Composable
fun ContactInformationText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.contact_information),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun AddressText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.address),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun PaymentMethodText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.payment_method),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}