package com.example.abcapp.accountSetting

import com.example.abcapp.R

data class Account(
    val icon: Int,
    val name: String,
)

val accountFeatureList = listOf(
    Account(icon = R.drawable.notification_icon, name = "Notification Setting"),
    Account(icon = R.drawable.shopping_icon, name = "Shopping Address"),
    Account(icon = R.drawable.payment_icon, name = "Payment Info"),
    Account(icon = R.drawable.delete_icon, name = "Delete Account")
)

data class AppSettings(
    val name: String,
    var isSelected: Boolean
)

val appSettingsList = listOf(
    AppSettings(name = "Enable Face ID For Log In", isSelected = false),
    AppSettings(name = "Enable Push Notifications", isSelected = true),
    AppSettings(name = "Enable Location Service", isSelected = true),
    AppSettings(name = "Dark Mode", isSelected = false),
    AppSettings(name = "Language", isSelected = false)
)