package com.example.abcapp.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable


@Serializable
data class Login(
    val name: String
)

fun NavGraphBuilder.loginNavigation(
    navHostController: NavHostController
) {
    composable<Login> { navBackStackEntry ->
        val name = navBackStackEntry.toRoute<Login>()
        LoginScreen(navHostController = navHostController, name = name.name)
    }
}
