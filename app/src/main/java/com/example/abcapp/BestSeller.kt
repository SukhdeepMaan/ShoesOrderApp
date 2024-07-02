package com.example.abcapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.white

@Composable
fun BestSeller(modifier: Modifier = Modifier) {
    FavouriteOrBestSeller(
        modifier = modifier.background(color = white),
        header = {
            HeaderDesign(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                title = {
                    Text(
                        text = "Best Seller",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold),
                        fontSize = 16.sp
                    )
                },
                leadingIcon =  {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = "Arrow",
                        onClick = { /*TODO*/ }
                    )
                },
                trailingIcon = {
                    CustomIcon(
                        icon = R.drawable.filter,
                        contentDescription = "Filter",
                        background = false,
                        onClick = { /*TODO*/ }
                    )
                    CustomIcon(
                        icon = R.drawable.search,
                        contentDescription = stringResource(id = R.string.search),
                        background = false,
                        onClick = { /*TODO*/ }
                    )

                }
            )
        }
    ) {
        items(shoeList) {
            ShoeItem(
                modifier = Modifier.height(240.dp),
                shoeData = it,
                isFavorite = true) {
            }
        }

    }
}