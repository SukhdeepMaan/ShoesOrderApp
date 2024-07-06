package com.example.abcapp.splashScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.abcapp.ui.theme.cornflowerBlue

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { counter ->
            androidx.compose.foundation.Canvas(
                modifier = Modifier
                    .height(12.dp)
                    .width(if (currentPage == counter) 36.dp else 12.dp)
                    .padding(2.dp)
            ) {
                drawRoundRect(
                    color = if (currentPage == counter) cornflowerBlue else Color.LightGray,
                    size = size,
                    cornerRadius = CornerRadius(8.dp.toPx())
                )
            }
        }
    }

}