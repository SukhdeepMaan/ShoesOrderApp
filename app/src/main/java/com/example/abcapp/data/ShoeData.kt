package com.example.abcapp.data

import com.example.abcapp.R

data class ShoeData(
    val id: Int,
    val name: String,
    val image: Int ,
    val price: Double,
    val description: String
)

var shoeList = listOf(
    ShoeData( id = 1, name = "Nike jordan", image = R.drawable.nike_jordan, price = 493.00, description = "BEST SELLER"),
    ShoeData( id = 2, name = "Nike Air Max", image = R.drawable.nike_air_max, price = 897.99, description = "BEST SELLER"),
    ShoeData( id = 1, name = "Nike jordan", image = R.drawable.nike_jordan, price = 493.00, description = "BEST SELLER"),
    ShoeData( id = 2, name = "Nike Air Max", image = R.drawable.nike_air_max, price = 897.99, description = "BEST SELLER"),
    ShoeData( id = 1, name = "Nike jordan", image = R.drawable.nike_jordan, price = 493.00, description = "BEST SELLER"),
    ShoeData( id = 2, name = "Nike Air Max", image = R.drawable.nike_air_max, price = 897.99, description = "BEST SELLER"),
)
