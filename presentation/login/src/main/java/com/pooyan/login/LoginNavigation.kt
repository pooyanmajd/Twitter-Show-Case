package com.pooyan.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val LoginRoute = "login_screen_route"

fun NavGraphBuilder.loginGraph() {
    composable(route = LoginRoute) {
        LoginScreen()
    }
}