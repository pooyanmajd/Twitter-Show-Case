package com.pooyan.dev.tweet

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val TweetsRoute = "tweets_screen_route"

fun NavGraphBuilder.tweetsGraph() {
    composable(route = TweetsRoute) {
        TweetsScreen()
    }
}