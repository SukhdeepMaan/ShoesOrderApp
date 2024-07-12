package com.example.abcapp.checkOut.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.CustomIcon
import com.example.abcapp.R
import com.example.abcapp.ui.theme.unselectedTextColor

@Composable
fun PaymentMethodRow(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    enableTextField: Boolean = false,
    icon: Int? = null,
    vectorIcon: ImageVector? = null,
    rotateIcon: Float = 90f,
    onValueChange: (String) -> Unit,
    onIconClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = title,

                    )
            }
            vectorIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = title,
                    tint = unselectedTextColor,
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = unselectedTextColor
                    )
                )
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    enabled = enableTextField
                )
            }
        }
        CustomIcon(
            modifier = Modifier
                .rotate(rotateIcon),
            icon = R.drawable.forword_arrow,
            contentDescription = "",
            background = false,
            tint = unselectedTextColor,
            onClick = onIconClick
        )
    }

}