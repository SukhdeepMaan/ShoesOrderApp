package com.example.abcapp.checkOut.alertDialogShow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.R
import com.example.abcapp.ui.theme.cornflowerBlue
import kotlinx.datetime.Month

@Composable
fun ShowAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        containerColor = Color.White,
        confirmButton = {},
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFDFEFFF),
                            shape = CircleShape
                        )
                        .padding(24.dp),
                    painter = painterResource(id = R.drawable.dialog_img) ,
                    contentDescription = "")

                Text(
                    text = "Your Payment Is Successful",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                )
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = cornflowerBlue
                    ),
                    onClick = onConfirm,
                    contentPadding = PaddingValues(
                        horizontal = 32.dp,
                        vertical = 16.dp
                    )
                ) {
                    Text(
                        text = "Back To Shopping",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    )
}