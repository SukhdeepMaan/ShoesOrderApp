package com.example.abcapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.abcapp.CompanyNameButton
import com.example.abcapp.DataModel
import com.example.abcapp.NewShowItem
import com.example.abcapp.R
import com.example.abcapp.home.bottomSheet.ReadyBottomSheetForHomePage
import com.example.abcapp.ShoeItem
import com.example.abcapp.StickyHeaderDesign
import com.example.abcapp.data.shoeList
import com.example.abcapp.home.components.HeaderForHomePage
import com.example.abcapp.home.components.HeyText
import com.example.abcapp.home.components.ProfilePhoto
import com.example.abcapp.home.components.SearchField
import com.example.abcapp.home.components.UserNameText
import com.example.abcapp.home.drawer.components.DrawerRow
import com.example.abcapp.home.drawer.drawerItems
import com.example.abcapp.navigation.ScreenRoute
import com.example.abcapp.ui.theme.white
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDesigning(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    var searchValue by remember { mutableStateOf("") }
    var selectedCompany by remember { mutableIntStateOf(DataModel.getShoesData()[0].id) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberBottomSheetScaffoldState()
    val modalDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = modalDrawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White,
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(24.dp)
                        .padding(top = 48.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        ProfilePhoto()
                        HeyText()
                        UserNameText()
                    }
                    itemsIndexed(drawerItems) {
                        index, it ->
                        // divider is increasing the size of lazy column
/*                        if (index == drawerItems.size-1) {
                            HorizontalDivider()
                        }*/
                        DrawerRow(
                            icon = it.icon,
                            title = it.title
                        ) {
                            scope.launch { modalDrawerState.close() }
                            navHostController.navigate(it.route)
                        }
                    }
                }
            }
        }
    ) {
        BottomSheetScaffold(
            sheetContent = {
                ReadyBottomSheetForHomePage {
                }
            },
            scaffoldState = bottomSheetState,
            sheetPeekHeight = 0.dp,
            sheetContainerColor = Color.White
        ) {
            HomePage(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = white),
                header = {
                    HeaderForHomePage(
                        onMenuClick = { scope.launch { modalDrawerState.open() } },
                        onBagClick = { navHostController.navigate(ScreenRoute.CART.route) }
                    )
                },
                search = {
                    SearchField(searchValue = searchValue) {
                        searchValue = it
                    }
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
                                // filter action will be here
                                scope.launch {
                                    bottomSheetState.bottomSheetState.expand()
                                }
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
                                ShoeItem(shoeData = it,
                                    onClick = {
                                        navHostController.navigate(ScreenRoute.DETAIL.route)
                                    },
                                    onClickBestSeller = {
                                        navHostController.navigate(ScreenRoute.BEST_SELLER.route)
                                    },
                                    onClickPlusButton = {
                                        navHostController.navigate(ScreenRoute.CART.route)
                                    }
                                )
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
        }
    }
}

@Composable
private fun HomePage(
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
