package com.example.abcapp.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.abcapp.R

@Composable
fun ProfilePhoto(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xFFDFEFFF),
                shape = CircleShape
            )
    ) {
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = ""
        )
    }

}