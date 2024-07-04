package com.example.abcapp.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource


@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    imageVector: ImageVector? = null,
    contentDescription: String? = null,
    tint: Color = Color.Unspecified
) {

    icon?.let {
        Icon(
            painter = painterResource(id = it),
            contentDescription = contentDescription,
            modifier, tint
        )
    }

    imageVector?.let {
        Icon(
            imageVector = it,
            contentDescription = contentDescription,
            modifier, tint
        )
    }

}