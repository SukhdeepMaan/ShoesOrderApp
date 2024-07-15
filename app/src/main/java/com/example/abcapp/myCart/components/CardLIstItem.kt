package com.example.abcapp.myCart.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.abcapp.myCart.MyCartData

@Composable
fun CartListItem(
    modifier: Modifier = Modifier,
    myCartData: MyCartData,
    isRefresh: Boolean,
    onDelete: () -> Unit,
    onRefresh: (Boolean) -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(start = 20.dp, end = 20.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.weight(1f)) {
            MyCartListItemImage(image = myCartData.image)
            Column {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    CartListItemName(name = myCartData.name)
                    CartListItemPrice(price = myCartData.price)
                }
                // plus and minus button
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SubtractionButton {
                        onRefresh(!isRefresh)
                        if (myCartData.count > 1) {
                            myCartData.count--
                        }
                    }
                    CartListItemOwnCounter(count = myCartData.count)
                    AdditionButton {
                        onRefresh(!isRefresh)
                        myCartData.count++
                    }
                }
            }
        }
        CartListItemDeleteAndSize(onDelete = onDelete)
    }
}