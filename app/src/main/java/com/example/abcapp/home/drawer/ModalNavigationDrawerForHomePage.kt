package com.example.abcapp.home.drawer

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ModalNavigationDrawerForHomePage(
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    drawerContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {

}