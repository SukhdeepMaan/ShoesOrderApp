package com.example.abcapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.abcapp.BestSeller
import com.example.abcapp.DetailScreen
import com.example.abcapp.FavouriteReady
import com.example.abcapp.home.HomeDesigning
import com.example.abcapp.LoginScreen
import com.example.abcapp.myCart.MyCartReady
import com.example.abcapp.RecoveryPassword
import com.example.abcapp.ShoeAppSignUp
import com.example.abcapp.accountSetting.AccountAndSettings
import com.example.abcapp.checkOut.CheckOutScreen
import com.example.abcapp.data.shoeList
import com.example.abcapp.notifications.NotificationScreen
import com.example.abcapp.profile.Profile
import com.example.abcapp.splashScreen.OnBoardingScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = ScreenRoute.ONBOARDING.route
    ) {
        composable(
            route = ScreenRoute.ONBOARDING.route
        ) {
            OnBoardingScreen(navHostController = navHostController)
        }
        composable(ScreenRoute.LOGIN.route) {
            LoginScreen(navHostController = navHostController)
        }
        composable(ScreenRoute.REGISTER.route) {
            ShoeAppSignUp(navHostController = navHostController)
        }
        composable(ScreenRoute.FORGET_PASSWORD.route) {
            RecoveryPassword(navHostController = navHostController)
        }
        composable(ScreenRoute.HOME.route) {
            HomeDesigning(navHostController = navHostController)
        }
        composable(ScreenRoute.DETAIL.route) {
            // want to pass data to detail screen
            DetailScreen(shoeData = shoeList[0], navHostController = navHostController)
        }
        composable(ScreenRoute.CART.route) {
            MyCartReady(navHostController = navHostController)
        }
        composable(ScreenRoute.FAVOURITE.route) {
            FavouriteReady(navHostController = navHostController)
        }
        composable(ScreenRoute.BEST_SELLER.route) {
            BestSeller(navHostController = navHostController)
        }
        composable(ScreenRoute.PROFILE.route) {
            Profile(navHostController = navHostController)
        }
        composable(ScreenRoute.ACCOUNT_SETTINGS.route) {
            AccountAndSettings(navHostController = navHostController)
        }
        composable(ScreenRoute.NOTIFICATION.route) {
            NotificationScreen(navHostController = navHostController)
        }
        composable(ScreenRoute.CHECKOUT.route) {
            CheckOutScreen(navHostController = navHostController)
        }
    }
}

enum class ScreenRoute(val route: String) {
    ONBOARDING("/onboarding"),
    LOGIN("/login"),
    REGISTER("/register"),
    FORGET_PASSWORD("/forgetPassword"),
    HOME("/home"),
    DETAIL("/detail"),
    CART("/cart"),
    FAVOURITE("/favourite"),
    BEST_SELLER("/bestSeller"),
    PROFILE("/profile"),
    ACCOUNT_SETTINGS("/accountSettings"),
    NOTIFICATION("/notification"),
    CHECKOUT("/checkout")
}

//sealed class ScreenRoute(val route:String){
//
//    data object OnBoarding : ScreenRoute("/onboarding")
//
//}