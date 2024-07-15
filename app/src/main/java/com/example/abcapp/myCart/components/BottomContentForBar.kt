package com.example.abcapp.myCart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomContentForBar(modifier: Modifier = Modifier,
                        subTotal: Double,
                        shipping: Double,
                        total: Double,
                        onClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SubtotalTextAndPrice(price = subTotal)
        ShippingTextAndPrice(price = shipping)
        DashDivider()
        TotalCostTextAndPrice(price = total)
        CheckOutButton( onClick = onClick)
    }

}