package com.example.abcapp.myCart.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.abcapp.R
import com.example.abcapp.components.AppIcon

@Composable
fun CartListItemDeleteAndSize(
    modifier: Modifier = Modifier,
    onDelete: () -> Unit) {
    Column(
        modifier = modifier.padding(end = 16.dp),
    ) {
        Text(text = "XL", modifier = Modifier.weight(1f))
        AppIcon(
            icon = R.drawable.delete_icon,
            contentDescription = "Delete Button",
            modifier = Modifier.clickable(onClick = onDelete)
        )
    }
}