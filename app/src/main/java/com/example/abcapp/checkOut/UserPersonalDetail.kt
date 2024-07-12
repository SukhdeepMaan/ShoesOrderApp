package com.example.abcapp.checkOut

data class UserPersonalDetail(
    var name: String,
    var email: String,
    var number: String,
    var address: String
)
val userPersonalDetail = UserPersonalDetail(
    name = "AnyName",
    email = "rumenhussen@gmail.com",
    number = "+88-692 -764-269",
    address = "Newahall St 36, London, 12908 - UK"
)
