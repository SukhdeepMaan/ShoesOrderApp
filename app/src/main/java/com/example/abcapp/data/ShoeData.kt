package com.example.abcapp.data

import androidx.compose.ui.graphics.Color
import com.example.abcapp.R

data class ShoeData(
    val id: Int,
    val name: String,
    val image: List<Int>,
    val price: Double,
    val size: List<Int>,
    val description: String,
    val detailText: String,
    var colorList: List<Color> = emptyList()
)

val imageList = listOf(
    R.drawable.nike_jordan,
    R.drawable.nike_air_max,
    R.drawable.nike_jordan,
    R.drawable.nike_air_max
)
val shoeSizeList = listOf(
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
    20,
    21,
    22,
    23,
    24,
    25,
    26,
    27,
    28,
    29,
    30,
    31,
    32,
    33,
    34,
    35,
    36,
    37,
    38,
    39,
    40
)

val sizeType = listOf("EU", "US", "UK")
var shoeList = listOf(
    ShoeData(
        id = 1,
        name = "Nike jordan",
        image = imageList,
        price = 493.00,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 2,
        name = "Nike Air Max",
        image = imageList,
        price = 897.99,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 3,
        name = "Nike jordan",
        image = imageList,
        price = 493.00,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 4,
        name = "Nike Air Max",
        image = imageList,
        price = 897.99,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 5,
        name = "Nike jordan",
        image = imageList,
        price = 493.00,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 6,
        name = "Nike Air Max",
        image = imageList,
        price = 897.99,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 7,
        name = "Nike jordan",
        image = imageList,
        price = 493.00,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 8,
        name = "Nike Air Max",
        image = imageList,
        price = 897.99,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 9,
        name = "Nike jordan",
        image = imageList,
        price = 493.00,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    ),
    ShoeData(
        id = 10,
        name = "Nike Air Max",
        image = imageList,
        price = 897.99,
        size = shoeSizeList,
        description = "BEST SELLER",
        detailText = "Air Jordan is an American brand of basketball shoes athletic, casual, and style clothing produced by Nike....",
        colorList = listOf(Color.Red, Color.Blue, Color.Green)
    )
)
