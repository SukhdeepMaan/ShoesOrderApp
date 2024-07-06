package com.example.abcapp.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.ui.theme.unselectedTextColor

@Composable
fun BoardingContentDesign(
    modifier: Modifier = Modifier, boardingData: BoardingData
) {
    Column(modifier = modifier) {
        val configuration = LocalConfiguration.current
        val context = LocalContext.current

        // Get the screen width in pixels
        val screenWidthPx = configuration.screenWidthDp.dp
        Image(
            painter = painterResource(id = boardingData.image),
            contentDescription = null,
            modifier = Modifier
                .size(
                    screenWidthPx
                )
        )
        Text(
            text = boardingData.title, style = TextStyle(
                fontSize = 40.sp, fontWeight = FontWeight.SemiBold, lineHeight = 56.sp
            ), modifier = Modifier.padding(20.dp)
        )
        Text(
            text = boardingData.description, style = TextStyle(
                fontSize = 20.sp, lineHeight = 32.sp, color = unselectedTextColor
            ), modifier = Modifier.padding(
                horizontal = 20.dp,
            )
        )
    }
}