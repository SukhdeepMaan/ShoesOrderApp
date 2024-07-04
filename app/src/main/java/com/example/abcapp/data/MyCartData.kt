package com.example.abcapp.data

import androidx.compose.runtime.mutableStateListOf
import com.example.abcapp.R

data class MyCartData(
    val id: Int,
    val name: String,
    val image: Int,
    val price: Double,
    val size: Int,
    var count: Int
)


var myCartList = listOf(
    MyCartData(
        id = 1,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 40,
        count = 1
    ),
    MyCartData(
        id = 2,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 36,
        count = 3
    ),
    MyCartData(
        id = 3,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 40,
        count = 2
    ),
    MyCartData(
        id = 4,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 36,
        count = 2
    ),
    MyCartData(
        id = 5,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 40,
        count = 1
    ),
    MyCartData(
        id = 6,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 36,
        count = 3
    ),
    MyCartData(
        id = 7,
        name = "Nike Club Max",
        image = R.drawable.nike_list_image,
        price = 493.00,
        size = 40,
        count = 2
    )
)
