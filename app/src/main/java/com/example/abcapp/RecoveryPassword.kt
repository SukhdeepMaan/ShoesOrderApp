package com.example.abcapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.abcapp.ui.theme.cornflowerBlue

@Composable
fun RecoveryPassword(modifier: Modifier = Modifier,navHostController: NavHostController) {
    var emailAddress by remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize()) {
        BackArrow2(modifier = Modifier.padding(24.dp)){
            navHostController.navigateUp()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 24.dp),
                firstText = stringResource(id = R.string.recovery_password),
                secondText = stringResource(R.string.please_enter_your_email_address_to_recieve_a_verification_code)
            )
            HeaderAndInputField(
                modifier = Modifier.padding(vertical = 24.dp),
                header = stringResource(id = R.string.email_address),
                value = emailAddress,
                placeholder = stringResource(R.string.enter_email_address),
            ) {
                emailAddress = it
            }
            CustomButton(
                onClick = { /*TODO*/ }, buttonColor = cornflowerBlue, contentColor = Color.White
            ) {
                Text(text = stringResource(R.string.continueText), fontSize = 18.sp)
            }
        }

    }
}