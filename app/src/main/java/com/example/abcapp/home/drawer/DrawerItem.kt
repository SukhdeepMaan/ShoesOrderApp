package com.example.abcapp.home.drawer

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.abcapp.R
import com.example.abcapp.navigation.ScreenRoute

data class DrawerItem(
    val title: String,
    val icon: Int? = null,
    val imageVector: ImageVector? = null,
    val route: String
)

val drawerItems = listOf(
    DrawerItem(
        title = "Profile",
        icon = R.drawable.profile,
        route = ScreenRoute.PROFILE.route
    ),
    DrawerItem(
        title = "Home Page",
        icon = R.drawable.home,
        route = ScreenRoute.HOME.route
    ),
    DrawerItem(
        title = "My Cart",
        icon = R.drawable.bag,
        route = ScreenRoute.CART.route
    ),
    DrawerItem(
        title = "Favourite",
        icon = R.drawable.heart_nav,
        route = ScreenRoute.FAVOURITE.route
    ),
    DrawerItem(
        title = "Orders",
        icon = R.drawable.delivery_nav_icon,
        route = ScreenRoute.CHECKOUT.route
    ),
    DrawerItem(
        title = "Notification",
        icon = R.drawable.notification_nav_icon,
        route = ScreenRoute.NOTIFICATION.route
    ),
    DrawerItem(
        title = "Sign Out",
        icon = R.drawable.signout_nav_icon,
        route = ScreenRoute.HOME.route
    )
)
