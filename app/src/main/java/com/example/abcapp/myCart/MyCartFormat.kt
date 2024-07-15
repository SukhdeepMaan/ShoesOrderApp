package com.example.abcapp.myCart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyCart(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: LazyListScope.() -> Unit,
    bottomBar: @Composable () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        header()
        LazyColumn(modifier = Modifier.weight(1f)) {
            content.invoke(this)
        }
        bottomBar()
    }
}