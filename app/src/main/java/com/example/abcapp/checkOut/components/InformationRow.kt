package com.example.abcapp.checkOut.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.CustomIcon
import com.example.abcapp.R
import com.example.abcapp.ui.theme.unselectedColor
import com.example.abcapp.ui.theme.unselectedTextColor

@Composable
fun InformationRow(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    enableTextField: Boolean = false,
    icon: Int? = null,
    vectorIcon: ImageVector? = null,
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
                    modifier = Modifier
                        .background(
                            color = unselectedColor,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                )
            }
            vectorIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = title,
                    tint = unselectedTextColor,
                    modifier = Modifier
                        .background(
                            color = unselectedColor,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    enabled = enableTextField
                )
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = unselectedTextColor
                    )
                )
            }
        }
        CustomIcon(
            icon = R.drawable.edit_icon,
            contentDescription = "",
            background = false,
            tint = unselectedTextColor,
            onClick = onIconClick
        )
    }

}