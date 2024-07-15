package com.example.abcapp.home.drawer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.abcapp.home.components.NavigationText

@Composable
fun DrawerRow(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    imageVector: ImageVector? = null,
    title: String,
    onClick: () -> Unit = {}) {
    Box(
        modifier = modifier
            .clip(CircleShape) // Clip the Box to a circle shape
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true)
            ) {
                onClick()
            }
            .padding(8.dp) // Padding inside the clickable area
    ){
        Row(
            modifier = modifier
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            icon?.let {
                Icon(painter = painterResource(id = icon), contentDescription = title)
            }
            imageVector?.let {
                Icon(imageVector = imageVector, contentDescription = title)
            }
            NavigationText(title = title)
        }
    }
}