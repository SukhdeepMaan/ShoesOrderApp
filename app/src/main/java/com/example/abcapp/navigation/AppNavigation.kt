package com.example.abcapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.abcapp.LoginScreen
import com.example.abcapp.RecoveryPassword
import com.example.abcapp.ShoeAppSignUp
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
            OnBoardingScreen(
                navHostController = navHostController
            )
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
    }

}

enum class ScreenRoute(val route: String) {
    ONBOARDING("/onboarding"),
    LOGIN("/login"),
    REGISTER("/register"),
    FORGET_PASSWORD("/forgetPassword")
}

//sealed class ScreenRoute(val route:String){
//
//    data object OnBoarding : ScreenRoute("/onboarding")
//
//}