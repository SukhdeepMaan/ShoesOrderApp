package com.example.abcapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ShoeAppSignUp(modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPassShow by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0XFFD8D8D8))
    ) {
        BackArrow2(modifier = Modifier.padding(24.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Title Text
            TitleText(
                firstText = stringResource(R.string.create_account),
                secondText = stringResource(R.string.let_s_create_account_together)
            )
            Spacer(modifier = Modifier.height(48.dp))
            // header and input field
            // name
            HeaderAndInputField(
                header = stringResource(R.string.your_name),
                value = name,
                placeholder = stringResource(R.string.enter_name),
                onValueChange = { name = it }
            )

            // email address
            HeaderAndInputField(
                modifier = Modifier.padding(vertical = 16.dp),
                header = stringResource(R.string.email_address),
                value = email,
                placeholder = stringResource(R.string.email)
            ) {
                email = it
            }
            // password
            HeaderAndInputField(
                header = stringResource(id = R.string.password),
                value = password,
                placeholder = stringResource(id = R.string.password),
                isShowIcon = true,
                isPasswordShow = isPassShow,
                onClick = { isPassShow = !isPassShow }
            ) {
                password = it
            }
            // sign in buttons
            SignInButtons()

        }
        // already have an account
        BottomButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.already_have_an_account),
            buttonText = stringResource(R.string.sign_in),
            onClick = { },
            buttonColor = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}