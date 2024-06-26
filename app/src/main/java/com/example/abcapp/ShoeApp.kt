package com.example.abcapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
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
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.example.abcapp.ui.theme.cornflowerBlue


@Composable
fun ShoeApp(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordShow by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color(0XFFD8D8D8))
            .fillMaxSize()
    ) {
        // BackArrow(modifier = Modifier.padding(24.dp))
        BackArrow2(modifier = Modifier.padding(24.dp))
        LazyColumn(
            modifier = Modifier
                .weight(1f, fill = true)
            //.fillMaxSize()
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = stringResource(R.string.hello_again), style = TextStyle(
                        fontWeight = FontWeight.Bold, fontSize = 36.sp
                    )
                )
                Text(
                    text = stringResource(R.string.welcome_back_you_have_been_missed),
                    color = MaterialTheme.colorScheme.secondary
                )
                // input field
                Column(
                    modifier = Modifier.padding(vertical = 48.dp, horizontal = 16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    HeaderAndInputField(header = stringResource(R.string.username),
                        value = username,
                        placeholder = "Enter Username",
                        onValueChange = { username = it })
                    HeaderAndInputField(header = stringResource(R.string.password),
                        value = password,
                        placeholder = "Enter Password",
                        isShowIcon = true,
                        isPasswordShow = isPasswordShow,
                        onValueChange = { password = it },
                        onClick = {
                            isPasswordShow = !isPasswordShow
                        })
                    // password recovery
                    CustomTextButton(
                        text = stringResource(R.string.recovery_password),
                        onClick = { })

                    // sign in buttons
                    SignInButtons()
                    SignInButtons()
                    SignInButtons()
                    SignInButtons()


                }
            }
        }

        // don't have an account
        BottomButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.don_t_have_an_account),
            buttonText = stringResource(R.string.sign_up_for_free),
            onClick = { },
            buttonColor = Color.Black,
            fontWeight = FontWeight.Bold

        )
    }
}

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    contentColor: Color = MaterialTheme.colorScheme.secondary,
    fontWeight: FontWeight? = null,
    textStyle: TextStyle = LocalTextStyle.current
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(contentColor = contentColor)
    ) {
        Text(text = text, fontWeight = fontWeight, textAlign = TextAlign.End)
    }
}

@Composable
fun BottomButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonText: String,
    onClick: () -> Unit,
    buttonColor: Color,
    fontWeight: FontWeight? = null
) {
    Row(
        modifier = modifier
            .padding(
                vertical = 20.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = text)
        CustomTextButton(
            text = buttonText,
            onClick = onClick,
            contentColor = buttonColor,
            fontWeight = fontWeight
        )
    }
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColor: Color = Color.Blue,
    contentColor: Color = Color.Black,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(), onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor, contentColor = contentColor
        ), contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        content.invoke()
    }
}

@Composable
fun SignInButtons() {
    Spacer(modifier = Modifier.height(48.dp))
    // Sign in button
    CustomButton(
        onClick = { /*TODO*/ }, buttonColor = cornflowerBlue, contentColor = Color.White
    ) {
        Text(text = "Sign In", fontSize = 18.sp)
    }
    Spacer(modifier = Modifier.height(24.dp))

    // google sign in button
    CustomButton(
        onClick = { /*TODO*/ }, buttonColor = Color.White
    ) {
        Image(
            painter = painterResource(id = R.drawable.google), contentDescription = "Google button"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = stringResource(R.string.sign_in_with_google), fontSize = 18.sp)
    }
}

@Composable
fun HeaderAndInputField(
    modifier: Modifier = Modifier,
    header: String,
    value: String,
    placeholder: String,
    isShowIcon: Boolean = false,
    isPasswordShow: Boolean = true,
    onClick: () -> Unit = {},
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = header,
            modifier = Modifier.padding(vertical = 8.dp),
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            placeholder = {
                Text(text = placeholder)
            },
            trailingIcon = {
                if (isShowIcon) IconButton(onClick = onClick) {
                    Icon(
                        imageVector = Icons.Default.RemoveRedEye,
                        contentDescription = null,
                        tint = if (isPasswordShow) Color.Black else Color.LightGray
                    )
                }
            },
            visualTransformation = if (isPasswordShow) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(16.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
            )
        )
    }
}

@Composable
fun BackArrow(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = CircleShape)
            .padding(4.dp)
    ) {
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = stringResource(R.string.back_arrow)
            )

        }
    }
}

@Composable
fun BackArrow2(modifier: Modifier = Modifier) {

    IconButton(onClick = {}, modifier = modifier.drawBehind {
        drawCircle(
            color = Color.White
        )
    }) {
        Icon(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = stringResource(R.string.back_arrow),
        )
    }

}
