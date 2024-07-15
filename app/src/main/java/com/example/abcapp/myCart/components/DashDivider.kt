package com.example.abcapp.myCart.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp

@Composable
fun DashDivider(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
    ) {
        drawLine(
            color = Color(0XFFEFEFEF),
            start = Offset.Zero,
            end = Offset(size.width, 0f),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(10f, 20f)
            ),
            strokeWidth = 3.dp.toPx()
        )
    }
}