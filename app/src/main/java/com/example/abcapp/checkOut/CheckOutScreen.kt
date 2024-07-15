package com.example.abcapp.checkOut

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.abcapp.CustomIcon
import com.example.abcapp.R
import com.example.abcapp.checkOut.alertDialogShow.ShowAlertDialog
import com.example.abcapp.checkOut.components.AddressText
import com.example.abcapp.checkOut.components.BottomContentColum
import com.example.abcapp.checkOut.components.ContactInformationText
import com.example.abcapp.checkOut.components.ExpandedContent
import com.example.abcapp.checkOut.components.HeaderContent
import com.example.abcapp.checkOut.components.InformationRow
import com.example.abcapp.checkOut.components.MapView
import com.example.abcapp.checkOut.components.PaymentMethodRow
import com.example.abcapp.checkOut.components.PaymentMethodText
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
fun CheckOutScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {

    var userPersonalDetail by remember { mutableStateOf(userPersonalDetail) }
    var cardNumber by remember { mutableStateOf("***********23456") }
    var addressIconRotation by remember { mutableFloatStateOf(90f) }
    var paymentMethodIconRotation by remember { mutableFloatStateOf(90f) }
    var enablerEmailField by remember { mutableStateOf(false) }
    var enablerNumberField by remember { mutableStateOf(false) }
    val emailFocusRequester = remember { FocusRequester() }
    val numberFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    var showAlert by remember { mutableStateOf(false) }

    // Request focus based on the enabled field
    LaunchedEffect(enablerEmailField, enablerNumberField) {
        when {
            enablerEmailField -> emailFocusRequester.requestFocus()
            enablerNumberField -> numberFocusRequester.requestFocus()
            else -> focusManager.clearFocus()
        }
    }
    if (showAlert) {
        ShowAlertDialog(
            onDismissRequest = { showAlert = false },
            onConfirm = { showAlert = false },
        )
    }  // show alert dialog
    CheckOutDesign(
        modifier = modifier,
        header = {
            HeaderContent {
                navHostController.navigateUp()
            }
        },
        content = {
            item {
                Column(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .pointerInput(Unit) {
                            detectTapGestures {
                                focusManager.clearFocus()
                                enablerEmailField = false
                                enablerNumberField = false
                            }
                        }
                        .padding(16.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ContactInformationText()   // contact information text
                    // email
                    InformationRow(
                        textFiledModifier = Modifier.focusRequester(emailFocusRequester),
                        title = stringResource(R.string.email_),
                        value = userPersonalDetail.email,
                        vectorIcon = Icons.Default.Email,
                        enableTextField = enablerEmailField,
                        onValueChange = {
                            userPersonalDetail = userPersonalDetail.copy(email = it)
                        }
                    ) {
                        enablerNumberField = false
                        enablerEmailField = !enablerEmailField
                    }
                    // Number
                    InformationRow(
                        textFiledModifier = Modifier.focusRequester(numberFocusRequester),
                        title = stringResource(R.string.email_),
                        value = userPersonalDetail.number,
                        vectorIcon = Icons.Default.Phone,
                        enableTextField = enablerNumberField,
                        onValueChange = {
                            userPersonalDetail = userPersonalDetail.copy(number = it)
                        }
                    ) {
                        enablerEmailField = false
                        enablerNumberField = !enablerNumberField
                    }
                    AddressText()   // address text
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
                        }
                    }
                    /* expanded address compose
                     on this condition we can add anything instead of this box*/
                    if (addressIconRotation != 90f) {
                        MapView()
                    }
                    // map will be here
                    PaymentMethodText()  // payment method text
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
                    }
                    if (paymentMethodIconRotation != 90f) {
                        ExpandedContent()
                    }
                }
            }
        },
        bottom = {
            BottomContentColum {
                showAlert = true
            }
        }
    )
}