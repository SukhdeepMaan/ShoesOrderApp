package com.example.abcapp.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.CustomIcon
import com.example.abcapp.HeaderAndInputField
import com.example.abcapp.HeaderDesign
import com.example.abcapp.R
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGreyForBackGround

@Composable
fun Profile(modifier: Modifier = Modifier) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    ProfileDesign(
        modifier = modifier,
        header = {
            HeaderDesign(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                title = {
                    Text(text = "Profile")
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = "Arrow",
                        onClick = { /*TODO*/ }
                    )
                },
                trailingIcon = {
                    CustomIcon(
                        icon = R.drawable.edit_icon,
                        contentDescription = "Heart",
                        background = false,
                        onClick = { /*TODO*/ }
                    )
                }
            )
        },
        content = {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.background(color = Color(0xFFDFEFFF), shape = CircleShape)
                    ) {
                        Image(
                            modifier = Modifier.size(100.dp),
                            painter = painterResource(id = R.drawable.profile_photo),
                            contentDescription = "")
                        Icon(
                            modifier = Modifier
                                .offset(x = 0.dp, y = 16.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = cornflowerBlue
                                    )
                                }
                                .padding(4.dp)
                                .align(Alignment.BottomCenter),
                            painter = painterResource(id = R.drawable.camera_icon),
                            contentDescription = "",
                            tint = Color.White)
                    }
                    Text(text = "Alisson Becker",
                        modifier = Modifier.padding(top = 24.dp),
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
                HeaderAndInputField(
                    header = "Full Name",
                    value = fullName,
                    placeholder = "Enter Full Name"
                ) { fullName = it }

                HeaderAndInputField(
                    header = "Email",
                    value = email,
                    placeholder = "Enter Email"
                ) { email = it }

                HeaderAndInputField(
                    header = "Password",
                    value = password,
                    isPasswordShow = false,
                    placeholder = "Enter Password"
                ) { password = it }
            }
        }
    )
}

@Composable
private fun ProfileDesign(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit
) {
    Column(modifier = modifier.fillMaxSize().background(color = lightGreyForBackGround)) {
        header()
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
            content.invoke(this)
        }
    }
}