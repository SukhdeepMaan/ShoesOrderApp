package com.example.abcapp.myCart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.abcapp.myCart.components.CartListItem
import com.example.abcapp.myCart.components.CheckOutButton
import com.example.abcapp.myCart.components.DashDivider
import com.example.abcapp.myCart.components.HeaderForCart
import com.example.abcapp.myCart.components.ShippingTextAndPrice
import com.example.abcapp.myCart.components.SubtotalTextAndPrice
import com.example.abcapp.myCart.components.TotalCostTextAndPrice
import com.example.abcapp.navigation.ScreenRoute
import com.example.abcapp.ui.theme.lightGreyForBackGround

@Composable
fun MyCartReady(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var isRefresh by remember { mutableStateOf(false) }
    val data by remember { mutableStateOf(myCartList) }
    var subTotal by remember { mutableDoubleStateOf(0.0) }
    var shipping by remember { mutableDoubleStateOf(40.90) }
    var total by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(key1 = isRefresh) {
        subTotal = calculateSubTotal(data)
        total = subTotal + shipping
        shipping = total * 0.01
    }


    MyCart(modifier = modifier.background(color = lightGreyForBackGround),
        header = {
            HeaderForCart { navHostController.popBackStack() }
        }, content = {
            items(data, key = { it.id }) {
                CartListItem(myCartData = it, isRefresh = isRefresh, onDelete = {
                }) { item ->
                    isRefresh = item
                }
            }
        }, bottomBar = {
            if (data.isNotEmpty()) {
                Column(
                    modifier = Modifier
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
                    CheckOutButton { navHostController.navigate(ScreenRoute.CHECKOUT.route) }
                }
            }
        }
    )
}

fun calculateSubTotal(data: List<MyCartData>): Double {
    var subTotal = 0.0
    data.forEach {
        subTotal += it.price * it.count
    }
    return subTotal
}