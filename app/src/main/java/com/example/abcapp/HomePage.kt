package com.example.abcapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.abcapp.data.shoeList
import com.example.abcapp.ui.theme.white

@Composable
fun HomeDesigning(modifier: Modifier = Modifier) {
    var searchValue by remember { mutableStateOf("") }
    var selectedCompany by remember { mutableStateOf(0) }
    HomePage(
        modifier = modifier
            .fillMaxSize()
            .background(color = white)
            .padding(8.dp)
            .padding(horizontal = 8.dp),
        header = {
            HeaderDesign(
                modifier = Modifier.padding(top = 16.dp),
                title = {
                    Text(
                        text = stringResource(R.string.store_location),
                        style = TextStyle(
                            fontSize = 12.sp,
                        )
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.locationicon),
                            contentDescription = stringResource(R.string.location)
                        )
                        Text(
                            text = stringResource(R.string.mondolibug_sylhet),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }

                },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.menu,
                        contentDescription = stringResource(R.string.menu)
                    ) {
                        //TODO menu button action here
                    }
                }, trailingIcon = {
                    CustomIcon(
                        icon = R.drawable.bag,
                        contentDescription = stringResource(R.string.bag)
                    ) {
                        //TODO menu button action here
                    }
                }
            )
        },
        search = {
            CustomSearchBar(
                value = searchValue,
                onValueChange = { searchValue = it },
                placeholder = { Text(text = stringResource(R.string.looking_for_shoes)) },
                leadingIcon = {
                    CustomIcon(
                        icon = R.drawable.search,
                        contentDescription = stringResource(R.string.search),
                        background = false
                    ) {
                        // TODO Search action will be here
                    }
                }
            )
        },
        company = {
            items(mapList.keys.toList()) {
                CompanyNameButton(
                    icon = it,
                    name = mapList[it]!!,
                    index = it,
                    isSelected = selectedCompany == it
                ) {
                    selectedCompany = it
                }

            }

        },
        content = {
            // Popular Shoes
            item {
                StickyHeaderDesign(
                    modifier = Modifier.padding(top = 8.dp),
                    header = "Popular Shoes") {
                    //TODO see all action will be here
                }
            }
            // each shoe item
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(shoeList) {
                        ShoeItem(shoeData = it) {
                            //TODO add to cart action will be here
                        }

                    }

                }

            }
            // New Arrivals
            item {
                StickyHeaderDesign(
                    modifier = Modifier.padding(top = 16.dp),
                    header = "New Arrivals") {
                    //TODO see all action will be here
                }
            }
            // new item
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(shoeList) {
                        Box(
                            modifier = Modifier.fillParentMaxWidth()
                        ) {
                            NewShowItem(shoeData = it)
                        }
                    }
                }
            }

        }
    )
}

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    header: (@Composable () -> Unit)? = null,
    search: (@Composable () -> Unit)? = null,
    company: (LazyListScope.() -> Unit)? = null,
    content: (LazyListScope.() -> Unit)? = null
) {
    Column(modifier = modifier) {
        header?.invoke()
        search?.invoke()
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    company?.invoke(this)
                }
            }
            content?.invoke(this)
        }
    }
}



@Composable
fun StickyHeaderPlusItem(
    modifier: Modifier = Modifier,
    header: String,
    buttonName: String = "See all",
    onClick: () -> Unit = {}
) {
    Column(modifier = modifier) {
        StickyHeaderDesign(
            header = header,
            buttonName = buttonName,
            onClick = onClick
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),

        ) {
            items(shoeList) {
                ShoeItem(shoeData = it) {
                    //TODO add to cart action will be here
                }
            }
        }
    }
}

@Preview
@Composable
private fun A() {
    BoxScoped()
}

@Composable
fun BoxScoped(modifier: Modifier = Modifier) {

    Box(modifier = modifier
        .size(100.dp, 100.dp)
        .background(color = Color.Red))

}


