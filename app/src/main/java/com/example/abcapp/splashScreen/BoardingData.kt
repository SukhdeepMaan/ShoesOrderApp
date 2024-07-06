package com.example.abcapp.splashScreen

import com.example.abcapp.R

data class BoardingData(
    val image: Int,
    val title: String,
    val description: String
)

val boardingData = listOf(
    BoardingData(
        image = R.drawable.splash_shoe_one,
        title = "Start Journey With Nike",
        description = "Smart, Gorgeous & Fashionable Collection"
    ),
    BoardingData(
        image = R.drawable.splash_shoe_two,
        title = "Follow Latest Style Shoes",
        description = "There Are Many Beautiful And Attractive Plants To Your Room"
    ),
    BoardingData(
        image = R.drawable.splash_shoe_three,
        title = "Summer Shoes Nike 2022",
        description = "Amet Minim Lit Nodeseru Saku Nandu sit Alique Dolor"
    )
)
