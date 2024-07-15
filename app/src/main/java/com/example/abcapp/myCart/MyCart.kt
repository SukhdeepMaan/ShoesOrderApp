package com.example.abcapp.myCart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.abcapp.checkOut.components.BottomContentColum
import com.example.abcapp.myCart.components.CartListItem
import com.example.abcapp.myCart.components.EmptyCartView
import com.example.abcapp.myCart.components.HeaderForCart
import com.example.abcapp.navigation.ScreenRoute
import com.example.abcapp.ui.theme.lightGreyForBackGround

@Composable
fun MyCartReady(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var data by remember { mutableStateOf(myCartList) }
    var subTotal by remember { mutableDoubleStateOf(0.0) }
    var shipping by remember { mutableDoubleStateOf(0.0) }
    var total by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(key1 = data) {
        subTotal = calculateSubTotal(data)
        total = subTotal + shipping
        shipping = total * 0.01
    }

    MyCart(modifier = modifier.background(color = lightGreyForBackGround),
        header = {
            HeaderForCart { navHostController.popBackStack() }
        }, content = {
            if (data.isEmpty()) {
                item {
                    EmptyCartView(modifier = Modifier.fillParentMaxSize())
                }
            }
            items(data, key = { it.id }) { item ->
                CartListItem(listItem = item,
                    subtraction = {
                        data = countAddition(data, item)
                    },
                    addition = {
                        data = countSubtraction(data, item)
                    },
                    onDelete = {
                        data = data.filter { item.id != it.id }
                    }
                )
            }
        }, bottomBar = {
            if (data.isNotEmpty()) {
                BottomContentColum(modifier = Modifier.fillMaxWidth(),
                    paymentOnClick = {
                        navHostController.navigate(ScreenRoute.CHECKOUT.route)
                    }
                )
            }
        }
    )
}