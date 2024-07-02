package com.example.abcapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.white

@Composable
fun FavouriteOrBestSeller(
    modifier: Modifier = Modifier,
    header: @Composable (()-> Unit)? = null,
    content:  LazyGridScope.() -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        header?.invoke()
        LazyVerticalGrid(
            modifier = Modifier.padding(16.dp),
            columns = GridCells.Adaptive(128.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content.invoke(this)
        }
    }
}

@Composable
fun FavouriteReady(modifier: Modifier = Modifier) {
    FavouriteOrBestSeller(
        modifier = modifier
            .background(color = white),
        header = {
            HeaderDesign(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                title = {
                    Text(text = "Favourite",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = "Arrow",
                        onClick = { /*TODO*/ }
                    )
                },
                trailingIcon = {
                    CustomIcon(
                        icon = R.drawable.heart,
                        contentDescription = "Heart",
                        onClick = { /*TODO*/ }
                    )
                }

            )
        },
        content = {
            items(shoeList) {
                ShoeItem(
                    modifier = Modifier.height(240.dp),
                    shoeData = it,
                    isFavorite = true) {

                }
            }
        }
    )
}