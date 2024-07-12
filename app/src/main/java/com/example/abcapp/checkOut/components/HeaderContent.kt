package com.example.abcapp.checkOut.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.CustomIcon
import com.example.abcapp.HeaderDesign
import com.example.abcapp.R

@Composable
fun HeaderContent(modifier: Modifier = Modifier) {
    HeaderDesign(
        modifier = modifier.padding(horizontal = 20.dp, vertical = 12.dp),
        title = {
            Text(
                text = stringResource(R.string.check_out),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        },
        leadingIcon = {
            CustomIcon(
                icon = R.drawable.arrow,
                contentDescription = stringResource(R.string.back),
                onClick = { /*TODO*/ }
            )
        }
    )
}