package com.example.abcapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDesigning(modifier: Modifier = Modifier) {
    var searchValue by remember { mutableStateOf("") }
    var selectedCompany by remember { mutableIntStateOf(DataModel.getShoesData()[0].id) }
    val scope = rememberCoroutineScope()
    //val modalBottomSheetState = rememberModalBottomSheetState()
    val bottomSheetState = rememberBottomSheetScaffoldState()

    HomePage(
        modifier = modifier
            .fillMaxSize()
            .background(color = white),
        header = {
            HeaderDesign(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
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
                    Box {
                        CustomIcon(
                            icon = R.drawable.bag,
                            contentDescription = stringResource(R.string.bag)
                        ) {

                        }
                        Circle(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = 5.dp)
                        )
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

                    }
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        },
        company = {
            LazyRow(
                modifier = Modifier.padding(vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                }
                items(DataModel.getShoesData(), key = { it.id }) {
                    CompanyNameButton(
                        data = it,
                        index = it.id,
                        isSelected = selectedCompany == it.id,
                    ) { value ->
                        selectedCompany = value
                        scope.launch { bottomSheetState.bottomSheetState.expand() }
                    }
                }
            }

        },
        content = {
            // Popular Shoes
            item {
                StickyHeaderDesign(
                    modifier = Modifier.padding(top = 8.dp),
                    header = stringResource(R.string.popular_shoes)
                ) {
                    //TODO see all action will be here
                }
            }
            // each shoe item
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                    }
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
                    header = stringResource(R.string.new_arrivals)
                ) {
                    //TODO see all action will be here
                }
            }
            // new item
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item { }
                    items(shoeList) {
                        Box(
                            modifier = Modifier.fillParentMaxWidth(0.8f)
                        ) {
                            NewShowItem(shoeData = it)
                        }
                    }
                }
            }

        }
    )

    BottomSheetScaffold(
        sheetContent = {
            ReadyBottomSheetForHomePage() {
                // TODO apply filter action will be here

            }
        },
        scaffoldState = bottomSheetState,
        sheetPeekHeight = 0.dp,
        containerColor = Color.White,
    ) {
    }

//    // modal bottom sheet
//    ModalBottomSheet(onDismissRequest = {
//        scope.launch { bottomSheetState.hide() }
//    },
//        sheetState = bottomSheetState
//    ) {
//        ReadyBottomSheetForHomePage()
//    }
}

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    header: (@Composable () -> Unit)? = null,
    search: (@Composable () -> Unit)? = null,
    company: (@Composable () -> Unit)? = null,
    content: (LazyListScope.() -> Unit)? = null
) {
    Column(modifier = modifier) {
        header?.invoke()
        search?.invoke()
        company?.invoke()
        LazyColumn {
            content?.invoke(this)
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

    Box(
        modifier = modifier
            .size(100.dp, 100.dp)
            .background(color = Color.Red)
    )

}


