package com.example.abcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.ABCAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ABCAppTheme {
               //ShoeApp()
               //ShoeAppSignUp()
               // RecoveryPassword()
               HomeDesigning()
                //FavouriteReady()
                //BestSeller()
                //DetailScreen(shoeData = shoeList[0])
                //MyCartReady()
                //ReadyBottomSheetForHomePage()
            }
        }
    }
}

@Composable
fun SignIn(modifier: Modifier = Modifier) {

    val userNameField = remember { mutableStateOf("") }
    val passwordField = remember { mutableStateOf("") }

    Column(
        modifier = Modifier

            .padding(64.dp)
            .fillMaxSize()
            .padding(top = 64.dp),
        verticalArrangement = Arrangement.spacedBy(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {

            Text(text = "Sign In", fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = userNameField.value,
                onValueChange = { userNameField.value = it },
                label = { Text(text = "Username") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                value = passwordField.value,
                onValueChange = { passwordField.value = it },
                label = { Text(text = "Password") },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Sign In")
            }
        }


    }
}


