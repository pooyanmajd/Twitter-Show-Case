package com.pooyan.twittershowcase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pooyan.dev.tweet.TweetsRoute
import com.pooyan.dev.tweet.tweetsGraph
import com.pooyan.login.LoginRoute
import com.pooyan.login.loginGraph

@Composable
fun TwitterShowCaseNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = LoginRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        loginGraph(onNavigateToTweets = {
            navController.navigate(TweetsRoute)
        })

        tweetsGraph()
    }
}