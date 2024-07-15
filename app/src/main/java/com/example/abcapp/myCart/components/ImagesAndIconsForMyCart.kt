package com.example.abcapp.myCart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.abcapp.R
import com.example.abcapp.components.AppIcon
import com.example.abcapp.ui.theme.cornflowerBlue

@Composable
fun MyCartListItemImage(
    modifier: Modifier = Modifier,
    image: Int,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier
            .background(
                color = Color.White, shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 10.dp)
    )
}

@Composable
fun SubtractionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    AppIcon(icon = R.drawable.abc_icon,
        contentDescription = "",
        modifier = modifier
            .size(26.dp)
            .background(
                color = Color.White, shape = CircleShape
            )
            .clickable {
                onClick()
            }
            .padding(4.dp)
    )
}

@Composable
fun AdditionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    AppIcon(imageVector = Icons.Default.Add,
        contentDescription = "Add Icon",
        modifier = modifier
            .size(24.dp)
            .background(
                color = cornflowerBlue, shape = CircleShape
            )
            .clickable {
                onClick()
            }
            .padding(4.dp),
        tint = Color.White
    )

}