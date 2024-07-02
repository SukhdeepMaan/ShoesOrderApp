package com.example.abcapp

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.data.ShoeData
import com.example.abcapp.data.sizeType
import com.example.abcapp.ui.theme.cornflowerBlue
import com.example.abcapp.ui.theme.lightGrey
import com.example.abcapp.ui.theme.white

@Composable
fun DetailScreenDesign(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit,
    bottomContent: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        header.invoke()
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(color = white)

        ) {
            content.invoke(this)
        }
        bottomContent.invoke()
    }
}

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    shoeData: ShoeData,

    ) {
    var selectedSize by remember { mutableIntStateOf(10) }
    var shoeSizeType by remember {mutableStateOf("EU")
    }
    DetailScreenDesign(
        modifier = modifier.background(color = white),
        header = {
            HeaderDesign(
                modifier = Modifier
                    .background(color = lightGrey)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                title = {
                    Text(text = stringResource(R.string.men_s_shoe),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        ))
                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.arrow,
                        contentDescription = stringResource(R.string.back_arrow),
                        onClick = {/*TODO*/ }
                    )
                },
                trailingIcon = {
                    CustomIcon(
                        icon = R.drawable.bag,
                        contentDescription = stringResource(R.string.bag),
                        onClick = {/*TODO*/ }
                    )
                }

            )
        },
        content = {
            item {
                Box(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .fillParentMaxHeight(0.4f)
                        .background(color = lightGrey)
                        .padding(top = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // detail shoe photo
                        Image(
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            painter = painterResource(id = R.drawable.new_large_photo),
                            contentDescription = shoeData.name,
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ellipse),
                            contentDescription = shoeData.name
                        )
                    }
                }

                // detail
                NamePriceAndDes(
                    modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                    shoeData = shoeData,
                    nameStyle = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    priceStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                // detail Text
                Text(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp),
                    text = shoeData.detailText,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    modifier = Modifier.padding(start = 20.dp, bottom = 16.dp),
                    text = "Gallery",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                // gallery
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item { }
                    items(shoeData.image) {
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(0.dp, 0.dp),
                            onClick = { /*TODO*/ }) {
                            Image(
                                painter = painterResource(id = it),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                }
                // size and type
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 16.dp, top = 16.dp),
                        text = stringResource(R.string.size),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    // size type
                    Row{
                        sizeType.forEach {
                            ShoeSizeType(isSelected = shoeSizeType == it , text = it ) {
                                shoeSizeType = it
                            }
                        }
                    }
                }

                // size numbers
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                    items(shoeData.size) {
                        ShoeSizeButton(
                            isSelected = selectedSize == it,
                            shoeSize = it,
                            onClick = {
                                selectedSize = it
                            }
                        )
                    }
                }
            }
        },
        bottomContent = {
            BottomDesignAddToCart(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 16.dp),
                price = shoeData.price.toString(),
                priceStyle = TextStyle(
                    fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
                )
            ) {
                // TODO add to cart action will be here
            }
        }
    )
}