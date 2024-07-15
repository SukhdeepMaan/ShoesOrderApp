package com.example.abcapp.myCart.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.abcapp.R

@Composable
fun MyCartText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.my_cart), style = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun CartListItemName(
    modifier: Modifier = Modifier,
    name: String) {
    Text(
        modifier = modifier,
        text = name, style = TextStyle(
            fontWeight = FontWeight.SemiBold, fontSize = 16.sp
        )
    )
}

@Composable
fun CartListItemPrice(
    modifier: Modifier = Modifier,
    price: Double) {
    Text(
        modifier = modifier,
        text = "$${price}", style = TextStyle(
            fontWeight = FontWeight.SemiBold, fontSize = 16.sp
        )
    )
}

@Composable
fun CartListItemOwnCounter(modifier: Modifier = Modifier, count : Int) {
    Text(modifier = modifier,text = "$count")
}

@Composable
fun SubtotalTextAndPrice(modifier: Modifier = Modifier, price: Double) {
    RowForBottomBar(
        modifier = modifier,
        title = stringResource(R.string.subtotal), titleStyle = TextStyle(
            color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight(600)
        ), price = price, priceStyle = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun ShippingTextAndPrice(modifier: Modifier = Modifier, price: Double) {
    RowForBottomBar(
        modifier = modifier,
        title = stringResource(id = R.string.shipping), titleStyle = TextStyle(
            color = MaterialTheme.colorScheme.secondary, fontWeight = FontWeight(600)
        ), price = price, priceStyle = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun TotalCostTextAndPrice(modifier: Modifier = Modifier, price: Double) {
    RowForBottomBar(
        modifier = modifier,
        title = stringResource(id = R.string.total_cost), titleStyle = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight(600)
        ), price = price, priceStyle = TextStyle(
            fontSize = 20.sp, fontWeight = FontWeight(600)
        )
    )

}