package com.example.abcapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.components.AppIcon
import com.example.abcapp.data.MyCartData
import com.example.abcapp.data.myCartList
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGreyForBackGround

@Composable
fun MyCart(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit,
    bottomBar: @Composable () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        header()
        LazyColumn(modifier = Modifier.weight(1f)) {
            content.invoke(this)
        }
        bottomBar()
    }
}

@Composable
fun MyCartReady(modifier: Modifier = Modifier) {


    MyCart(
        modifier = modifier
            .background(color = lightGreyForBackGround),
        header = {
            HeaderDesign(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 4.dp),
                title = {
                    Text(
                        text = stringResource(R.string.my_cart),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = stringResource(id = R.string.back_arrow)
                    )
                }
            )
        },
        content = {
            items(myCartList) {
                CartListItem(myCartData = it)
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                RowForBottomBar(
                    title = "Subtotal",
                    titleStyle = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight(600)
                    ),
                    price = 1250.00,
                    priceStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                RowForBottomBar(
                    title = "Shipping",
                    titleStyle = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight(600)
                    ),
                    price = 40.90,
                    priceStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Divider()
                RowForBottomBar(
                    title = "Total Cost",
                    titleStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    ),
                    price = 1690.99,
                    priceStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600)
                    )
                )
                // Checkout Button
                CustomButton(
                    onClick = { /*TODO check out action will be here*/ },
                    buttonColor = cornflowerBlue,
                    contentColor = Color.White
                ) {
                    Text(text = "Checkout")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun RowForBottomBarView() {
    RowForBottomBar(
        title = "Subtotal",
        price = 493.00
    )
}

@Composable
private fun RowForBottomBar(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = TextStyle(),
    price: Double,
    priceStyle: TextStyle = TextStyle()
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = titleStyle
        )
        Text(
            text = "$${price}",
            style = priceStyle
        )
    }
}

@Composable
private fun CartListItem(modifier: Modifier = Modifier, myCartData: MyCartData) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 20.dp, top = 12.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = myCartData.image),
            contentDescription = null,
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(vertical = 10.dp)

        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = myCartData.name,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            )
            Text(
                text = "$${myCartData.price}",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            )
            // plus and minus button
            Row(
                modifier = Modifier.padding(top = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppIcon(
                    icon = R.drawable.abc_icon,
                    contentDescription = "Abc",
                    modifier = Modifier
                        .size(26.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                        .clickable {
                            // TODO minus action will be here

                        }
                        .padding(4.dp)
                )

                Text(text = "${myCartData.count}")

                AppIcon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Abc",
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            color = cornflowerBlue,
                            shape = CircleShape
                        )
                        .clickable {
                            // TODO plus action will be here
                        }
                        .padding(4.dp),
                    tint = Color.White
                )
            }
        }
        Column(
            modifier = Modifier.padding(end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "XL")
            AppIcon(
                icon = R.drawable.delete_icon,
                contentDescription = "Abc",
                modifier = Modifier.clickable {
                    // TODO delete action will be here
                }
            )
        }
    }
}