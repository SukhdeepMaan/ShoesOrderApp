package com.example.abcapp.checkOut

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.CustomIcon
import com.example.abcapp.R
import com.example.abcapp.checkOut.components.BottomContentColum
import com.example.abcapp.checkOut.components.ExpandedContent
import com.example.abcapp.checkOut.components.HeaderContent
import com.example.abcapp.checkOut.components.InformationRow
import com.example.abcapp.checkOut.components.MapView
import com.example.abcapp.checkOut.components.PaymentMethodRow
import com.example.abcapp.ui.theme.unselectedTextColor

@Composable
private fun CheckOutDesign(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit,
    bottom: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        header.invoke()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            content.invoke(this)
        }
        bottom.invoke()
    }
}

@Composable
fun CheckOutScreen(modifier: Modifier = Modifier) {

    val userPersonalDetail by remember {
        mutableStateOf(userPersonalDetail)
    }
    var cardNumber by remember { mutableStateOf("1234567890123456") }
    var addressIconRotation by remember { mutableFloatStateOf(90f) }
    var paymentMethodIconRotation by remember { mutableFloatStateOf(90f) }
    CheckOutDesign(
        modifier = modifier,
        header = { HeaderContent() },
        content = {
            item {
                Column(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(16.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = stringResource(R.string.contact_information),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    // email
                    InformationRow(
                        title = stringResource(R.string.email_),
                        value = userPersonalDetail.email,
                        vectorIcon = Icons.Default.Email,
                        onValueChange = {
                        }
                    ) {
                        // TODO edit icon action will be here
                    }
                    // Number
                    InformationRow(
                        title = stringResource(R.string.email_),
                        value = userPersonalDetail.number,
                        vectorIcon = Icons.Default.Phone,
                        onValueChange = {

                        }
                    ) {
                        // TODO edit icon action will be here
                    }
                    // address
                    Text(
                        text = stringResource(R.string.address),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    // address line and expand icon
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = userPersonalDetail.address,
                            style = TextStyle(
                                color = unselectedTextColor
                            )
                        )
                        CustomIcon(
                            modifier = Modifier.rotate(addressIconRotation),
                            icon = R.drawable.forword_arrow,
                            contentDescription = ""
                        ) {
                            addressIconRotation = if (addressIconRotation == 90f) -90f else 90f
                            // TODO address expand icon action will be here
                        }
                    }
                    // expanded address compose
                    // on this condition we can add anything instead of this box
                    if (addressIconRotation != 90f) {
                        ExpandedContent()
                    }
                    // map will be here
                    MapView()
                    // payment method
                    Text(
                        text = stringResource(R.string.payment_method),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    // payment method row
                    PaymentMethodRow(
                        title = stringResource(R.string.paypal_card),
                        value = cardNumber,
                        rotateIcon = paymentMethodIconRotation,
                        onValueChange = {
                            cardNumber = it
                        }
                    ) {
                        paymentMethodIconRotation =
                            if (paymentMethodIconRotation == 90f) -90f else 90f
                        // TODO arrow icon action will be here
                    }
                    if (paymentMethodIconRotation != 90f) {
                        ExpandedContent()
                    }
                }
            }
        },
        bottom = {
            BottomContentColum {
                // TODO payment button click will be here
            }
        }
    )
}