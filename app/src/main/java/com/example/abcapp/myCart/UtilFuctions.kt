package com.example.abcapp.myCart

fun calculateSubTotal(data: List<MyCartData>): Double {
    var subTotal = 0.0
    data.forEach {
        subTotal += it.price * it.count
    }
    return subTotal
}

fun countAddition( data: List<MyCartData>, item: MyCartData) : List<MyCartData> {
    return data.map {
        if (item.id == it.id) {
            it.copy(count = it.count + 1)
        } else {
            it
        }
    }
}

fun countSubtraction(data: List<MyCartData>, item: MyCartData) : List<MyCartData> {
    return data.map {
        if (item.id == it.id) {
            it.copy(count = it.count - 1)
        } else {
            it
        }
    }
}