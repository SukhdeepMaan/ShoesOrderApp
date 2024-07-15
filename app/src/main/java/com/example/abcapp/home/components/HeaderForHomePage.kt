package com.example.abcapp.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.abcapp.Circle
import com.example.abcapp.CustomIcon
import com.example.abcapp.HeaderDesign
import com.example.abcapp.R
@Composable
fun HeaderForHomePage(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit = {},
    onBagClick: () -> Unit = {},
) {
    HeaderDesign(
        modifier = modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        title = {
            StoreLocationText()
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.locationicon),
                    contentDescription = stringResource(R.string.location)
                )
                CityNameText()
            }
        },
        leadingIcon = {
            CustomIcon(
                icon = R.drawable.menu,
                contentDescription = stringResource(R.string.menu),
                onClick = onMenuClick
            )
        }, trailingIcon = {
            Box {
                CustomIcon(
                    icon = R.drawable.bag,
                    contentDescription = stringResource(R.string.bag),
                    onClick = onBagClick
                )
                Circle(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 5.dp)
                )
            }
        }
    )
}