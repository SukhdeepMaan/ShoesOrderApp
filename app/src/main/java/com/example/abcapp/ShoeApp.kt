package com.example.abcapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.abcapp.ui.theme.cornflowerBlue


@Composable
fun ShoeApp(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize()) {
        // back button
        BackArrow(modifier = Modifier.padding(24.dp))
        // text
       Column(modifier = Modifier
           .fillMaxSize()
           .padding(top = 120.dp),
           horizontalAlignment = Alignment.CenterHorizontally) {
           Text(text = "Hello Again!", fontWeight = FontWeight.Bold, fontSize = 36.sp)
           Text(
               text = "Welcome Back you have been Missed!",
               color = MaterialTheme.colorScheme.secondary
           )
           // input field
           Column(modifier = Modifier.padding(vertical = 48.dp, horizontal = 16.dp),
               horizontalAlignment = Alignment.CenterHorizontally) {
               HeaderAndInputField(
                   header = "Username",
                   value = username,
                   onValueChange = { username = it })
               HeaderAndInputField(
                   header = "Password",
                   value = password,
                   onValueChange = { password = it })
               // password recovery
               Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                   CustomTextButton(text = "Recovery Password", onClick = { /*TODO*/ })
               }

               // sign in buttons
               SignInButtons()

               Spacer(modifier = Modifier.height(120.dp))
               

               // don't have an account
               BottomButton(modifier = Modifier.fillMaxWidth(),
                   text = "Don't Have An Account?",
                   buttonText = "Sign Up For Free",
                   onClick = { /*TODO*/ },
                   buttonColor = Color.Black,
                   fontWeight = FontWeight.Bold

               )
           }
       }

    }
}
// preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomButton(
        text = "Don't Have An Account?",
        buttonText = "Sign Up For Free",
        onClick = { /*TODO*/ },
        buttonColor = Color.Black
    )
}

@Composable
fun CustomTextButton(modifier: Modifier = Modifier,
                     text: String,
                     onClick: () -> Unit,
                     contentColor: Color = MaterialTheme.colorScheme.secondary,
                     fontWeight: FontWeight? = null) {
    TextButton(onClick = onClick,
        colors = ButtonDefaults.textButtonColors(contentColor = contentColor)) {
        Text(text = text, fontWeight = fontWeight)
    }
}

@Composable
fun BottomButton(modifier: Modifier = Modifier,
                 text: String, buttonText: String, 
                 onClick: () -> Unit,
                 buttonColor: Color,
                 fontWeight: FontWeight? = null) {
   Row(verticalAlignment = Alignment.CenterVertically,) {
       Text(text = text)
       CustomTextButton(text = buttonText,
           onClick = onClick,
           contentColor = buttonColor,
           fontWeight = fontWeight)
   }
}

@Composable
fun CustomButton(modifier: Modifier = Modifier,
                 onClick: () -> Unit,
                 buttonColor: Color = Color.Blue,
                 contentColor: Color = Color.Black,
                 content: @Composable RowScope.() -> Unit) {
    Button( modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor, contentColor = contentColor)) {
        Row (content = content, modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically)
    }
}

@Composable
fun SignInButtons(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(48.dp))
    // Sign in button
    CustomButton(onClick = { /*TODO*/ },
        buttonColor = cornflowerBlue,
        contentColor = Color.White ) {
        Text(text = "Sign In", fontSize = 18.sp)
    }
    Spacer(modifier = Modifier.height(24.dp))

    // google sign in button
    CustomButton(onClick = { /*TODO*/ },
        buttonColor = Color.White) {
        Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google button")
        Text(text = "Sign in with google", fontSize = 18.sp)
    }
}

@Composable
fun HeaderAndInputField(modifier: Modifier = Modifier,
                        header: String, value: String,
                        onValueChange: (String) -> Unit) {
    Column {
        Text(text = header, modifier = Modifier.padding(vertical = 8.dp), fontWeight = FontWeight.Bold)
        TextField(value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.Blue, shape = RoundedCornerShape(24.dp)))
    }

}

@Composable
fun BackArrow(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .background(color = Color.White, shape = CircleShape)
        .padding(4.dp)) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.arrow), contentDescription = "Back arrow" )
        }
    }
}