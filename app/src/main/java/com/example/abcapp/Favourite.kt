package com.example.abcapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.lightGreyForBackGround
import com.example.abcapp.ui.theme.white

@Composable
fun FavouriteOrBestSeller(
    modifier: Modifier = Modifier,
    header: @Composable (() -> Unit)? = null,
    content: LazyGridScope.() -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(color = lightGreyForBackGround)
    ) {
        header?.invoke()
        LazyVerticalGrid(
            modifier = Modifier.padding(16.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            content.invoke(this)
        }
    }
}

@Composable
fun FavouriteReady(modifier: Modifier = Modifier, navHostController: NavHostController) {
    FavouriteOrBestSeller(
        modifier = modifier
            .background(color = white),
        header = {
            HeaderDesign(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                title = {
                    Text(
                        text = stringResource(R.string.favourite),
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = "Arrow",
                        onClick = {
                            navHostController.navigateUp()
                        }
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
                ShoeItem1(
                    shoeData = it,
                    isFavorite = true
                ) {

                }
            }
        }
    )
}