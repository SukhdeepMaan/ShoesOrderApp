package com.example.abcapp.checkOut.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.login.CustomButton
import com.example.abcapp.R
import com.example.abcapp.myCart.components.DashDivider
import com.example.abcapp.myCart.components.RowForBottomBar
import com.example.abcapp.myCart.components.formatPrice
import com.example.abcapp.ui.theme.cornflowerBlue

@Composable
fun BottomContentColum(modifier: Modifier = Modifier, paymentOnClick: () -> Unit) {
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
        RowForBottomBar(
            title = stringResource(R.string.subtotal),
            titleStyle = TextStyle(
                color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight(600)
            ), price = formatPrice(40.90),
            priceStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        RowForBottomBar(
            title = stringResource(R.string.shipping),
            titleStyle = TextStyle(
                color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight(600)
            ), price =formatPrice(40.90) ,
            priceStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        // Divider()
        DashDivider()
        RowForBottomBar(
            title = stringResource(R.string.total_cost), titleStyle = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight(600)
            ), price = formatPrice(40.90), priceStyle = TextStyle(
                fontSize = 20.sp, fontWeight = FontWeight(600)
            )
        )
        // Checkout Button
        CustomButton(
            onClick = paymentOnClick,
            buttonColor = cornflowerBlue,
            contentColor = Color.White
        ) {
            Text(text = stringResource(R.string.payment))
        }
    }
}